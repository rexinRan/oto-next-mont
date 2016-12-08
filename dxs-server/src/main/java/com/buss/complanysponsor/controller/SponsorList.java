package com.buss.complanysponsor.controller;

import com.buss.common.service.SysServiceI;

import com.buss.complanysponsor.entity.DxsComplanySponsorEntity;
import com.buss.complanysponsor.trans.form.DxsComplanySponsorSearchForm;
import com.buss.complanysponsor.trans.vo.DxsComplanySponsorVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/25.
 */

@Controller
@RequestMapping("/sponsor")
public class SponsorList {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/sponsorlist")
    @ResponseBody
    public ReplyDataMode sponsorList(DxsComplanySponsorSearchForm SearchForm ) {
        SearchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = SearchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();

        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(SearchForm.getPageNo());
        int pageSize = Integer.parseInt(SearchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<DxsComplanySponsorEntity> userCompancys = mode.getResult();

        List<DxsComplanySponsorVO> dxsComplanySponsorVOs = new ArrayList<DxsComplanySponsorVO>();

        for (DxsComplanySponsorEntity dxsComplanySponsorEntity:userCompancys) {
            DxsComplanySponsorVO dxsComplanySponsorVO = new DxsComplanySponsorVO();
            dxsComplanySponsorVO.copyEntity(dxsComplanySponsorEntity);
            dxsComplanySponsorVOs.add(dxsComplanySponsorVO);

        }
        mode.setResult(dxsComplanySponsorVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}