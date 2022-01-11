/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.oss.cloud;

import com.waysn.comm.exception.ErrorCode;
import com.waysn.comm.exception.ServicesException;
import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;
import io.minio.http.Method;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * MinIO 存储
 *
 * @author jinyiming waysn39@hotmail.com
 */
public class MinioCloudStorageService extends AbstractCloudStorageService {
    private MinioClient minioClient;

    public MinioCloudStorageService(CloudStorageConfig config) {
        this.config = config;
        //初始化
        init();
    }

    private void init() {
        try {
            minioClient = new MinioClient(config.getMinioEndPoint(), config.getMinioAccessKey(), config.getMinioSecretKey());
        } catch (InvalidEndpointException e) {
            e.printStackTrace();
        } catch (InvalidPortException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            //如果BucketName不存在，则创建
            boolean found = minioClient.bucketExists(config.getMinioBucketName());
            if (!found) {
                minioClient.makeBucket(config.getMinioBucketName());
            }
            minioClient.putObject(config.getMinioBucketName(), path, inputStream, Long.valueOf(inputStream.available()),
                    null, null, "application/octet-stream");
        } catch (Exception e) {
            throw new ServicesException(ErrorCode.OSS_UPLOAD_FILE_ERROR, e, "");
        }
        return config.getMinioEndPoint() + "/" + config.getMinioBucketName() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getMinioPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getMinioPrefix(), suffix));
    }

    public void upload(Path path, InputStream inputStream) {
        try {
            minioClient.putObject(config.getMinioBucketName(), path.toString(), inputStream, Long.valueOf(inputStream.available()), null, null, "application/octet-stream");
        } catch (Exception exception) {
            throw new ServicesException("Error while fetching files in Minio", exception);
        }
    }

    public String getShareUrl(Path path) throws MinioException {
        try {
            return minioClient.getPresignedObjectUrl(Method.GET, config.getMinioBucketName(), path.toString(), 86400, null);
        } catch (Exception var3) {
            throw new ServicesException("Error while get the bucket object share url", var3);
        }
    }

    public InputStream getDownloadFile(Path path) throws MinioException {
        try {
            return minioClient.getObject(config.getMinioBucketName(), path.toString());
        } catch (Exception var3) {
            throw new ServicesException("Error while get the bucket object share url", var3);
        }
    }
}
