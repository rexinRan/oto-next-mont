package com.buss.awardmoney.trans.vo;

import com.buss.awardmoney.entity.AwardMoneyEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-29 17:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=AwardMoneyEntity.class)
public class AwardMoneyVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**奖金类型（1 奖学金，2 助学金）*/
    @Mapping
    private String type;
    /**奖金申请通知*/
    @Mapping
    private String notice;
    /**编号（备用）*/
    @Mapping
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
