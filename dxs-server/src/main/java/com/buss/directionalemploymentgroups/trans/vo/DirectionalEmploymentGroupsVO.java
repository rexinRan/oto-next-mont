package com.buss.directionalemploymentgroups.trans.vo;

import com.buss.directionalemploymentgroups.entity.DirectionalEmploymentGroupsEntity;
import com.buss.employed.entity.EmployedEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;
import java.util.Set;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=DirectionalEmploymentGroupsEntity.class)
public class DirectionalEmploymentGroupsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**企业id*/
    @Mapping
    private String userId;
    /**定项就业名称*/
    @Mapping
    private String directionalEmploymentName;
    /**总投递数*/
    @Mapping
    private String postNum;
    /**显示菜单*/
    @Mapping
    private String directionDisplayMenu;
    /**定项就业发布时间*/
    @Mapping
    private String directionPublishTime;
    /**公司logo*/
    private String displayImg;
    /**招聘信息列表*/
    private List employedList;

    public List getEmployedList() {
        return employedList;
    }

    public void setEmployedList(List employedList) {
        this.employedList = employedList;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDirectionalEmploymentName() {
        return directionalEmploymentName;
    }

    public void setDirectionalEmploymentName(String directionalEmploymentName) {
        this.directionalEmploymentName = directionalEmploymentName;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getDirectionDisplayMenu() {
        return directionDisplayMenu;
    }

    public void setDirectionDisplayMenu(String directionDisplayMenu) {
        this.directionDisplayMenu = directionDisplayMenu;
    }

    public String getDirectionPublishTime() {
        return directionPublishTime;
    }

    public void setDirectionPublishTime(String directionPublishTime) {
        this.directionPublishTime = directionPublishTime;
    }
}
