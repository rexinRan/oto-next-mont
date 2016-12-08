package com.buss.voteitem.controller;
import com.buss.common.service.SysServiceI;
import com.buss.vote.entity.VoteEntity;
import com.buss.voteitem.entity.VoteItemEntity;
import com.buss.voteitem.trans.form.VoteItemSearchForm;
import com.buss.voteitem.trans.vo.VoteItemVO;
import org.jweb.core.bean.PageMode;
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
@RequestMapping("/VoteItem")
public class VoteItemController {

    @Resource
    private SysServiceI sysService;

    /**
     查询审核通过企业列表
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode voteItemList(VoteItemSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<VoteItemEntity> voteItems = this.sysService.list(criteriaQuery);
        List<VoteItemVO> voteItemVOs = new ArrayList<VoteItemVO>();

        for (VoteItemEntity voteItem:voteItems) {
            VoteItemVO voteItemVO = new VoteItemVO();
            voteItemVO.copyEntity(voteItem);
            voteItemVOs.add(voteItemVO);

        }
        replyDataMode.setData(voteItemVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode voteItemPageList(VoteItemSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<VoteItemEntity> voteItems = mode.getResult();

        List mapList = new ArrayList();
        for (VoteItemEntity voteItemEntity:voteItems) {
            Map<String,Object> map = new HashMap<>();
            VoteItemVO voteItemVO = new VoteItemVO();
            voteItemVO.copyEntity(voteItemEntity);
            map.put("voteItem",voteItemVO);
            VoteEntity voteEntity = this.sysService.get(VoteEntity.class,searchForm.getVoteId());
            String voteCount = "0";
            if (voteEntity.getVoteCount()!=null){
                voteCount = voteEntity.getVoteCount().toString();
            }
            map.put("voteCount",voteCount);
            mapList.add(map);
        }

        mode.setResult(mapList);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    /**
     查询审核通过企业列表
     */
    @RequestMapping("/voteItemById.do")
    @ResponseBody
    public ReplyDataMode voteItemById(VoteItemSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<VoteItemEntity> voteItems = this.sysService.list(criteriaQuery);
        List<VoteItemVO> voteItemVOs = new ArrayList<VoteItemVO>();

        for (VoteItemEntity voteItem:voteItems) {
            VoteItemVO voteItemVO = new VoteItemVO();
            voteItemVO.copyEntity(voteItem);
            voteItemVOs.add(voteItemVO);

        }
        replyDataMode.setData(voteItemVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    //查询投票结果前三名
    @RequestMapping("/result.do")
    @ResponseBody
    public ReplyDataMode result (VoteItemSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("itemNum", "desc");
        criteriaQuery.setOrder(orderMap);


        PageMode mode = this.sysService.list4page(criteriaQuery,1,3);
        List<VoteItemEntity> voteItems = mode.getResult();

        List<VoteItemVO> voteItemVOs = new ArrayList<VoteItemVO>();

        for (VoteItemEntity voteItemEntity:voteItems) {
            VoteItemVO voteItemVO = new VoteItemVO();
            voteItemVO.copyEntity(voteItemEntity);
            voteItemVOs.add(voteItemVO);

        }

//        mode.setResult(voteItemVOs);
        replyDataMode.setData(voteItemVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

