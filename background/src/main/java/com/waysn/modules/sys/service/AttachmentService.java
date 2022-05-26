package com.waysn.modules.sys.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.sys.dto.AttachmentDTO;
import com.waysn.modules.sys.entity.AttachmentEntity;
import io.minio.errors.MinioException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 附件管理
 *
 * @author waysn39 waysn39@hotmail.com
 * @since 1.0 2022-01-11
 */
public interface AttachmentService extends CrudService<AttachmentEntity, AttachmentDTO> {
    /**
     * 上传文件
     *
     * @param file 文件
     * @return 附件信息
     */
    AttachmentEntity upload(MultipartFile file);

    /**
     * 根据Path获取附件信息
     *
     * @param path Path
     * @return 附件信息
     */
    AttachmentEntity getByPath(String path);

    /**
     * 获取Paths的附件信息
     *
     * @return
     */
    List<AttachmentEntity> getByPaths(List<String> paths);

    /**
     * 获取Url地址
     *
     * @param path
     * @return
     */
    String getShareUrl(String path);

    /**
     * 获取Url地址
     *
     * @param paths
     * @return
     */
    List<String> getShareUrls(List<String> paths);


}