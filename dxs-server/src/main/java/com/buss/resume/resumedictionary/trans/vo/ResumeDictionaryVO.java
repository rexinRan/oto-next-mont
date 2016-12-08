package com.buss.resume.resumedictionary.trans.vo;

import com.buss.resume.resumedictionary.entity.ResumeDictionaryEntity;
import com.buss.resume.resumeschool.entity.ResumeSchoolEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-22 14:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeDictionaryEntity.class)
public class ResumeDictionaryVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**值*/
    @Mapping
    private String value;

    public ResumeDictionaryVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
