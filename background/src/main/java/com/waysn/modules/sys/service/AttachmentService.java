package com.waysn.modules.sys.service;

import com.waysn.comm.service.CrudService;
import com.waysn.modules.sys.dto.AttachmentDTO;
import com.waysn.modules.sys.entity.AttachmentEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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
     * 根据Path下载文件
     */
    void download(String path, HttpServletResponse response) throws Exception;

}