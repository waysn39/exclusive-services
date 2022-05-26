package com.waysn.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.exception.ServicesException;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.utils.StringUtils;
import com.waysn.modules.oss.cloud.CloudStorageConfig;
import com.waysn.modules.oss.cloud.MinioCloudStorageService;
import com.waysn.modules.oss.cloud.OSSFactory;
import com.waysn.modules.oss.entity.SysOssEntity;
import com.waysn.modules.oss.service.SysOssService;
import com.waysn.modules.sys.dao.AttachmentDao;
import com.waysn.modules.sys.dto.AttachmentDTO;
import com.waysn.modules.sys.entity.AttachmentEntity;
import com.waysn.modules.sys.service.AttachmentService;
import com.waysn.modules.sys.service.SysParamsService;
import io.minio.errors.MinioException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.*;

/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
@Service
public class AttachmentServiceImpl extends CrudServiceImpl<AttachmentDao, AttachmentEntity, AttachmentDTO> implements AttachmentService {
    @Resource
    private SysOssService sysOssService;
    @Resource
    private SysParamsService sysParamsService;

    @Override
    public QueryWrapper<AttachmentEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<AttachmentEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }


    @Override
    public AttachmentEntity upload(MultipartFile file) {
        AttachmentEntity entity = new AttachmentEntity();
        entity.setAttachName(file.getOriginalFilename());
        entity.setAttachLength(file.getSize());
        entity.setAttachExt(getExtension(file.getOriginalFilename()));
        try {
            //上传文件
            String url = OSSFactory.build().uploadSuffix(file.getBytes(), entity.getAttachExt());
            //保存文件信息
            SysOssEntity ossEntity = new SysOssEntity();
            ossEntity.setUrl(url);
            ossEntity.setCreateDate(new Date());
            sysOssService.insert(ossEntity);
            entity.setAttachPath(url);
        } catch (Exception e) {
            throw new ServicesException(e.getMessage(), e);
        }
        baseDao.insert(entity);
        return entity;
    }

    @Override
    public AttachmentEntity getByPath(String path) {
        LambdaQueryWrapper<AttachmentEntity> wrapper = new LambdaQueryWrapper<AttachmentEntity>();
        wrapper.eq(AttachmentEntity::getAttachPath, path);
        return baseDao.selectOne(wrapper);
    }

    @Override
    public List<AttachmentEntity> getByPaths(List<String> paths) {
        LambdaQueryWrapper<AttachmentEntity> wrapper = new LambdaQueryWrapper<AttachmentEntity>();
        wrapper.in(AttachmentEntity::getAttachPath, paths);
        return baseDao.selectList(wrapper);
    }

    @Override
    public String getShareUrl(String path)  {
        LambdaQueryWrapper<AttachmentEntity> wrapper = new LambdaQueryWrapper<AttachmentEntity>();
        wrapper.eq(AttachmentEntity::getAttachPath, path);
        AttachmentEntity entity =baseDao.selectOne(wrapper);
        return entity.getAttachPath();
    }

    @Override
    public List<String> getShareUrls(List<String> paths)  {
        List<AttachmentEntity> attachmentEntityList = getByPaths(paths);
        List<String> image = new ArrayList<>();
        for (AttachmentEntity entity : attachmentEntityList) {
            image.add(entity.getAttachPath());
        }
        return image;
    }

    public static final String DEF_FILE_SEPARATOR = ".";

    private String getExtension(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(DEF_FILE_SEPARATOR)) {
            return StringUtils.EMPTY;
        }
        return fileName.substring(fileName.lastIndexOf(DEF_FILE_SEPARATOR) + 1);
    }
}