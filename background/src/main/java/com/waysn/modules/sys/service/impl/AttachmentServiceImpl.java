package com.waysn.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.waysn.comm.constant.Constant;
import com.waysn.comm.exception.ServicesException;
import com.waysn.comm.service.impl.CrudServiceImpl;
import com.waysn.comm.utils.StringUtils;
import com.waysn.modules.oss.cloud.CloudStorageConfig;
import com.waysn.modules.oss.cloud.MinioCloudStorageService;
import com.waysn.modules.sys.dao.AttachmentDao;
import com.waysn.modules.sys.dto.AttachmentDTO;
import com.waysn.modules.sys.entity.AttachmentEntity;
import com.waysn.modules.sys.service.AttachmentService;
import com.waysn.modules.sys.service.SysParamsService;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
@Service
public class AttachmentServiceImpl extends CrudServiceImpl<AttachmentDao, AttachmentEntity, AttachmentDTO> implements AttachmentService {

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
        String path = generateAttachmentName(entity.getAttachExt());
        entity.setAttachPath(path);
        try {
            getMinio().upload(Paths.get(path), file.getInputStream());
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
    public List<AttachmentEntity> getAllBlogImage() {
        LambdaQueryWrapper<AttachmentEntity> wrapper = new LambdaQueryWrapper<AttachmentEntity>();
        return baseDao.selectList(wrapper);
    }

    @Override
    public String getShareUrl(String path) throws MinioException {
        return getMinio().getShareUrl(Paths.get(path));
    }

    @Override
    public void download(String path, HttpServletResponse response) throws Exception {
        AttachmentEntity attachment = getByPath(path);

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(attachment.getAttachName(), "UTF-8"));

        //打开本地文件流
        InputStream inputStream = getMinio().getDownloadFile(Paths.get(path));
        //激活下载操作
        OutputStream os = response.getOutputStream();

        //循环写入输出流
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }

        // 这里主要关闭。
        b = null;
        os.close();
        inputStream.close();
    }

    public static final String DEF_FILE_SEPARATOR = ".";

    private String getExtension(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(DEF_FILE_SEPARATOR)) {
            return StringUtils.EMPTY;
        }
        return fileName.substring(fileName.lastIndexOf(DEF_FILE_SEPARATOR) + 1);
    }

    /**
     * 构建文件path
     *
     * @param extension
     * @return
     */
    public static String generateAttachmentName(String extension) {
        String randomKey = UUID.randomUUID().toString();
        return randomKey + DEF_FILE_SEPARATOR + extension;
    }

    public MinioCloudStorageService getMinio() {
        //获取云存储配置信息
        CloudStorageConfig config = sysParamsService.getValueObject(Constant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);
        if (config.getType() == Constant.CloudService.MINIO.getValue()) {
            return new MinioCloudStorageService(config);
        }
        return null;
    }
}