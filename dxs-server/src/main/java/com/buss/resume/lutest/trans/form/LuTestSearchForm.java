package com.buss.resume.lutest.trans.form;

import com.buss.resume.lutest.entity.LuTestEntity;
import com.buss.resume.resume.entity.ResumeEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-16 17:10:38
 * @version V1.0
 *
 */
@Mapping(entityClass=LuTestEntity.class)
public class LuTestSearchForm extends SearchForm{
    @Mapping
    private String id;
    @Mapping
    private String title;
    @Mapping
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
