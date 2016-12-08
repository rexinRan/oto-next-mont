package com.buss.member.transfer.vo.pwd;

import com.buss.member.entity.GeneralUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;

/**
 * Created by Administrator on 2016/7/20.
 */
@Mapping(entityClass = GeneralUserEntity.class)
public class GeneralUserVo extends BaseVO {

    /**用户表主键*/
    @Mapping
    private java.lang.String id;
    /**真实姓名*/
    @Mapping
    private java.lang.String realname;
    /**用户角色*/
    @Mapping
    private java.lang.String rolecode;
    /**手机号(老师/学生登录账号)*/
    @Mapping
    private java.lang.String mphone;
    /**身份证号*/
    @Mapping
    private java.lang.String idcardnumber;
    /**密码*/
    @Mapping
    private java.lang.String pwd;
    /**电子邮箱(企业登录账号)*/
    @Mapping
    private java.lang.String email;
    /**企业名称*/
    @Mapping
    private java.lang.String empname;
    /**企业组织代码证号*/
    @Mapping
    private java.lang.String empcode;
    /**核审状态(预留判断企业)*/
    @Mapping
    private java.lang.String checkstatus;
    /**是否删除(0未删除1删除)*/
    @Mapping
    private java.lang.String isdelete;
    /**用户加入时间*/
    @Mapping
    private java.lang.String createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}

