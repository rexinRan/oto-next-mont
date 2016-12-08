package com.buss.test;

/**
 * Created by Administrator on 2016/7/14.
 */
import com.aliyun.openservices.oss.OSSClient;

public class Sample {

    public static void main(String[] args) {
        String accessKeyId = "<key>";
        String accessKeySecret = "<secret>";

        // 初始化一个OSSClient
        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);

        // 下面是一些调用代码...

    }
/*
    public void listObjects(String bucketName) {

        // 初始化OSSClient
        OSSClient client = ...;

        // 获取指定bucket下的所有Object信息
        ObjectListing listing = client.listObjects(bucketName);

        // 遍历所有Object
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            System.out.println(objectSummary.getKey());
        }
    }
    */

}