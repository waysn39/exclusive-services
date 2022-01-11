/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.oss.cloud;

import com.waysn.comm.constant.Constant;
import com.waysn.comm.utils.SpringContextUtils;
import com.waysn.modules.sys.service.SysParamsService;

/**
 * 文件上传Factory
 * @author jinyiming waysn39@hotmail.com
 */
public final class OSSFactory {
    private static SysParamsService sysParamsService;

    static {
        OSSFactory.sysParamsService = SpringContextUtils.getBean(SysParamsService.class);
    }

    public static AbstractCloudStorageService build() {
        //获取云存储配置信息
        CloudStorageConfig config = sysParamsService.getValueObject(Constant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            return new QiniuCloudStorageService(config);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            return new QcloudCloudStorageService(config);
        } else if (config.getType() == Constant.CloudService.FASTDFS.getValue()) {
            return new FastDFSCloudStorageService(config);
        } else if (config.getType() == Constant.CloudService.LOCAL.getValue()) {
            return new LocalCloudStorageService(config);
        } else if (config.getType() == Constant.CloudService.MINIO.getValue()) {
            return new MinioCloudStorageService(config);
        }

        return null;
    }

}