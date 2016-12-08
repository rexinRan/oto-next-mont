package com.buss.traincentertest.traintestsubject.trans.vo;

import com.buss.traincentertest.traintest.entity.TrainTestEntity;
import com.buss.traincentertest.traintestsubject.entity.TrainTestSubjectEntity;
import com.buss.traincentertest.traintestsubjectitem.entity.TrainTestSubjectItemEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainTestSubjectEntity.class)
public class TrainTestSubjectVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**试卷id*/
    @Mapping
    private String ttId;
    /**题号*/
    @Mapping
    private String subjectNum;
    /**试题内容*/
    @Mapping
    private String subjectContent;
    /**测试项(预留)*/
    @Mapping
    private String testContent;
    /**试题组*/
    @Mapping
    private String subjectGroup;
    /**编号*/
    @Mapping
    private String sort;
    /**试题选项*/
    private  List<TrainTestSubjectItemEntity> itemList;

    public List<TrainTestSubjectItemEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<TrainTestSubjectItemEntity> itemList) {
        this.itemList = itemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(String subjectNum) {
        this.subjectNum = subjectNum;
    }

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }

    public String getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(String subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
