package com.buss.awardmoney.controller;
import com.buss.awardmoney.entity.AwardMoneyEntity;
import com.buss.awardmoney.trans.form.AwardMoneySearchForm;
import com.buss.awardmoney.trans.vo.AwardMoneyVO;
import com.buss.common.service.SysServiceI;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 *
 */
@Controller
public class AwardMoneyController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/awardMoneyInfo.do")
    @ResponseBody
    public ReplyDataMode awardMoneyInfo(AwardMoneySearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("sort", "desc");
        orderMap.put("createTime","desc");
        criteriaQuery.setOrder(orderMap);

        List<AwardMoneyEntity> awardMoneys = this.sysService.list(criteriaQuery);
        AwardMoneyVO awardMoneyVO = new AwardMoneyVO();
        awardMoneyVO.copyEntity(awardMoneys.get(0));

        replyDataMode.setData(awardMoneyVO);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

