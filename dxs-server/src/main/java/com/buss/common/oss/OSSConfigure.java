package com.buss.common.oss;

/**
 * Created by Administrator on 2016/7/7.
 */
import org.jweb.core.util.PropertiesUtil;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class OSSConfigure {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String accessUrl;

    public OSSConfigure() {

    }

    /**
     * 通过配置文件.properties文件获取，这几项内容。
     *
     * @param storageConfName
     * @throws IOException
     */
    public OSSConfigure(String storageConfName) throws IOException {
        PropertiesUtil prop = new PropertiesUtil("conf/" + storageConfName);
        endpoint = prop.readProperty("endpoint").trim();
        accessKeyId = prop.readProperty("accessKeyId").trim();
        accessKeySecret = prop.readProperty("accessKeySecret").trim();
        bucketName = prop.readProperty("bucketName").trim();
        accessUrl = prop.readProperty("accessUrl").trim();
    }

    /**
     * 根据键获取值
     * @param key
     * @return
     */
    public static String getProperties(ResourceBundle bundle, String key){

        String str = bundle.getString(key);
        return str;
    }

    public OSSConfigure(String endpoint, String accessKeyId,
                        String accessKeySecret, String bucketName, String accessUrl) {

        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.accessUrl = accessUrl;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

}