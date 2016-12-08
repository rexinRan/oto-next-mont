package com.buss.aids.controller;
import com.buss.aids.entity.AidsEntity;
import com.buss.aids.trans.form.AidsSearchForm;
import com.buss.aids.trans.vo.AidsVO;
import com.buss.aids.trans.vo.SimpleAidsVO;
import com.buss.common.service.SysServiceI;
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
@RequestMapping("/aids")
public class AidsController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode aidspageList(AidsSearchForm searchForm, HttpServletRequest request){
        if(searchForm.getAidRegion()!=null&&"".equals(searchForm.getAidRegion())){
            searchForm.setAidRegion(null);
        }
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("aidPublishTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<AidsEntity> aids = mode.getResult();

        List<AidsVO> aidsVOs = new ArrayList<AidsVO>();

        for (AidsEntity aidsEntity:aids) {
            AidsVO aidsVO = new AidsVO();
            aidsVO.copyEntity(aidsEntity);
            if(aidsVO.getAidPublishTime()!=null&&!"".equals(aidsVO.getAidPublishTime())){
                String time = aidsVO.getAidPublishTime();
                String t = time.substring(0,11);
                aidsVO.setAidPublishTime(t);
            }
            aidsVOs.add(aidsVO);

        }

        mode.setResult(aidsVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/aidsById.do")
    @ResponseBody
    public ReplyDataMode aidsById(AidsSearchForm searchForm,HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<AidsEntity> aids = this.sysService.list(criteriaQuery);
        List<AidsVO> aidsVOs = new ArrayList<AidsVO>();

        for (AidsEntity aidsEntity:aids) {
            AidsVO aidsVO = new AidsVO();
            aidsVO.copyEntity(aidsEntity);
            String time = aidsVO.getAidPublishTime();
            if(time!=null&&!"".equals(time)){
                String dateTime = time.substring(0,16);
                aidsVO.setAidPublishTime(dateTime);
            }
            aidsVOs.add(aidsVO);

        }
        replyDataMode.setData(aidsVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    /**
     * 获取新闻的上一篇，下一篇
     */
    @RequestMapping("/relationlist.do")
    @ResponseBody
    public ReplyDataMode aidsRelationList(AidsSearchForm searchForm, HttpServletRequest request) {
        String myid = searchForm.getId();

        ReplyDataMode dataMode = new ReplyDataMode();

        String sql ="select * from dxs_aids where is_delete=0 and aid_catelog_id ="
                + searchForm.getAidCatelogId()
                +" order by aid_publish_time desc";

        List aids = this.sysService.findListbySql(sql);

        int preId = 0;
        int nextId = 0;

        for(int i=0;i<aids.size();i++){
            Object [] obj = (Object[])aids.get(i);

            if(myid.equals(obj[0].toString())){
                preId = i+1;
                nextId = i-1;
            }
        }


        // 封装返回数据
        Map<String, Object> temp = new HashMap<>();
        SimpleAidsVO next = new SimpleAidsVO();
        if (nextId != -1) {
            Object [] obj = (Object[])aids.get(nextId);
            next.setId(obj[0].toString());
            next.setAidTitle(obj[2].toString());
        } else {
            next = (null);
        }
        SimpleAidsVO pre = new SimpleAidsVO();
        if (preId != aids.size()) {
            Object [] obj = (Object[])aids.get(preId);
            pre.setId(obj[0].toString());
            pre.setAidTitle(obj[2].toString());
        } else {
            pre = (null);
        }

        temp.put("pre", pre);
        temp.put("next", next);

        dataMode.setData(temp);
        dataMode.setStatusCode("200");
        dataMode.setSuccess(true);

        return dataMode;
    }

}

