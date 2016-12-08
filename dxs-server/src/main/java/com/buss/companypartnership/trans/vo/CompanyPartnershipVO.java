package com.buss.companypartnership.trans.vo;

import com.buss.companypartnership.entity.CompanyPartnershipEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass= CompanyPartnershipEntity.class)
public class CompanyPartnershipVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**公司名称*/
    @Mapping
    private String companyname;
    /**加入时间*/
    @Mapping
    private String jointime;
    /**公司展示图*/
    @Mapping
    private String displayImg;
    /**公司宣传视频*/
    @Mapping
    private String displayVideo;
    /**公司简介*/
    @Mapping
    private String introduction;
    /**创建时间*/

    public CompanyPartnershipVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getDisplayVideo() {
        return displayVideo;
    }

    public void setDisplayVideo(String displayVideo) {
        this.displayVideo = displayVideo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
