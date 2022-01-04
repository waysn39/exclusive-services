/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */
package com.waysn.modules.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.page.PageData;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.utils.ConvertUtils;
import com.waysn.modules.notice.service.SysNoticeService;
import com.waysn.modules.notice.service.SysNoticeUserService;
import com.waysn.modules.security.user.SecurityUser;
import com.waysn.websocket.WebSocketServer;
import com.waysn.websocket.data.MessageData;
import com.waysn.modules.notice.dao.SysNoticeDao;
import com.waysn.modules.notice.dto.SysNoticeDTO;
import com.waysn.modules.notice.entity.SysNoticeEntity;
import com.waysn.modules.notice.entity.SysNoticeUserEntity;
import com.waysn.modules.notice.enums.NoticeReadStatusEnum;
import com.waysn.modules.notice.enums.NoticeStatusEnum;
import com.waysn.modules.notice.enums.ReceiverTypeEnum;
import com.waysn.modules.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 通知管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
public class SysNoticeServiceImpl extends CrudServiceImpl<SysNoticeDao, SysNoticeEntity, SysNoticeDTO> implements SysNoticeService {
    @Autowired
    private SysNoticeUserService sysNoticeUserService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public QueryWrapper<SysNoticeEntity> getWrapper(Map<String, Object> params){
        String type = (String)params.get("type");

        QueryWrapper<SysNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(type), "type", type);
        wrapper.orderByDesc(Constant.CREATE_DATE);
        return wrapper;
    }

    @Override
    public PageData<SysNoticeDTO> getNoticeUserPage(Map<String, Object> params) {
        //分页
        IPage<SysNoticeEntity> page = getPage(params, null, false);

        //查询
        List<SysNoticeEntity> list = baseDao.getNoticeUserList(params);

        return getPageData(list, page.getTotal(), SysNoticeDTO.class);
    }

    @Override
    public PageData<SysNoticeDTO> getMyNoticePage(Map<String, Object> params) {
        //分页
        IPage<SysNoticeEntity> page = getPage(params, null, false);

        //查询
        params.put("receiverId", SecurityUser.getUserId());
        List<SysNoticeEntity> list = baseDao.getMyNoticeList(params);

        return getPageData(list, page.getTotal(), SysNoticeDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysNoticeDTO dto) {
        SysNoticeEntity entity = ConvertUtils.sourceToTarget(dto, SysNoticeEntity.class);

        //更新发送者信息
        if(dto.getStatus() == NoticeStatusEnum.SEND.value()){
            entity.setSenderName(SecurityUser.getUser().getRealName());
            entity.setSenderDate(new Date());
        }

        baseDao.insert(entity);

        //发送通知
        dto.setId(entity.getId());
        sendNotice(dto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysNoticeDTO dto) {
        SysNoticeEntity entity = ConvertUtils.sourceToTarget(dto, SysNoticeEntity.class);

        //更新发送者信息
        if(dto.getStatus() == NoticeStatusEnum.SEND.value()){
            entity.setSenderName(SecurityUser.getUser().getRealName());
            entity.setSenderDate(new Date());
        }

        this.updateById(entity);

        //发送通知
        sendNotice(dto);
    }

    /**
     * 发送通知
     */
    public void sendNotice(SysNoticeDTO notice){
        //如果是草稿，在不发送通知
        if(notice.getStatus() == NoticeStatusEnum.DRAFT.value()){
            return;
        }

        //全部用户
        if(notice.getReceiverType() == ReceiverTypeEnum.ALL.value()){
            //发送给全部用户
            sendAllUser(notice);

            //通过WebSocket，提示全部用户，有新通知
            MessageData<String> message = new MessageData<String>().msg(notice.getTitle());
            webSocketServer.sendMessageAll(message);

        }else {  //选中用户
            List<Long> userIdList = sysUserService.getUserIdListByDeptId(notice.getReceiverTypeList());
            if(userIdList.size() == 0){
                return;
            }

            //发送给选中用户
            sendUser(notice, userIdList);

            //通过WebSocket，提示选中用户，有新通知
            MessageData<String> message = new MessageData<String>().msg(notice.getTitle());
            webSocketServer.sendMessage(userIdList, message);
        }
    }

    /**
     * 发送给全部用户
     */
    public void sendAllUser(SysNoticeDTO notice){
        SysNoticeUserEntity noticeUser = new SysNoticeUserEntity()
                .setNoticeId(notice.getId())
                .setReadStatus(NoticeReadStatusEnum.UNREAD.value());
        sysNoticeUserService.insertAllUser(noticeUser);
    }

    /**
     * 发送给选中用户
     */
    public void sendUser(SysNoticeDTO notice, List<Long> userIdList){
        userIdList.forEach(userId -> {
            SysNoticeUserEntity noticeUser = new SysNoticeUserEntity()
                    .setNoticeId(notice.getId())
                    .setReceiverId(userId)
                    .setReadStatus(NoticeReadStatusEnum.UNREAD.value());

            sysNoticeUserService.save(noticeUser);
        });
    }


}