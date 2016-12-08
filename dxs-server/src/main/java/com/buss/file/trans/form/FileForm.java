package com.buss.file.trans.form;

import com.buss.file.entity.FileEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;

/**
 * Created by Administrator on 2016/6/29.
 */
@Mapping(entityClass= FileEntity.class)
public class FileForm extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**外键*/
    @Mapping
    private java.lang.String outId;
    /**连接表*/
    @Mapping
    private java.lang.String tableType;
    /**文件名*/
    @Mapping
    private java.lang.String name;
    /**title*/
    @Mapping
    private java.lang.String title;
    /**文件类型*/
    @Mapping
    private java.lang.String filetype;
    /**文件审核状态*/
    @Mapping
    private java.lang.String checkstatus;
    /**下载地址*/
    @Mapping
    private java.lang.String downloadUrl;
    /**createtime*/
    @Mapping
    private java.lang.String createtime;
    /**upStringtime*/
    @Mapping
    private java.lang.String upStringtime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpStringtime() {
        return upStringtime;
    }

    public void setUpStringtime(String upStringtime) {
        this.upStringtime = upStringtime;
    }

    public String getIsDetail() {
        return isDetail;
    }

    public void setIsDetail(String isDetail) {
        this.isDetail = isDetail;
    }
}
