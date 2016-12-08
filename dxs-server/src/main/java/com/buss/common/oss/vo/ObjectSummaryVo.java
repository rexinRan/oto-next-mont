package com.buss.common.oss.vo;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ObjectSummaryVo {
    /* 文件名 */
    private String key;;
    /* 大小 */
    private String size;
    /* 创建时间 */
    private String lastModified;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
