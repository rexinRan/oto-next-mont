package com.buss.careerguidance.controller;
import com.buss.careerguidance.entity.CareerGuidanceEntity;
import com.buss.careerguidance.trans.form.CareerGuidanceSearchForm;
import com.buss.careerguidance.trans.vo.CareerGuidanceVO;
import com.buss.careerguidance.trans.vo.SimpleCareerGuidanceVO;
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
@RequestMapping("/careerGuidance")
public class CareerGuidanceController {

    @Resource
    private SysServiceI sysService;
    
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode careerGuidancepageList(CareerGuidanceSearchForm searchForm, HttpServletRequest request){
        if(searchForm.getCgCatelogName()!=null&&"全部".equals(searchForm.getCgCatelogName())){
            searchForm.setCgCatelogName(null);
        }
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("cgPublishTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<CareerGuidanceEntity> careerGuidance = mode.getResult();

        List<CareerGuidanceVO> careerGuidanceVOs = new ArrayList<CareerGuidanceVO>();

        for (CareerGuidanceEntity careerGuidanceEntity:careerGuidance) {
            CareerGuidanceVO careerGuidanceVO = new CareerGuidanceVO();
            careerGuidanceVO.copyEntity(careerGuidanceEntity);
            careerGuidanceVOs.add(careerGuidanceVO);

        }

        mode.setResult(careerGuidanceVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/careerGuidanceById.do")
    @ResponseBody
    public ReplyDataMode careerGuidanceById(CareerGuidanceSearchForm searchForm,HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<CareerGuidanceEntity> careerGuidance = this.sysService.list(criteriaQuery);
        List<CareerGuidanceVO> careerGuidanceVOs = new ArrayList<CareerGuidanceVO>();

        for (CareerGuidanceEntity careerGuidanceEntity:careerGuidance) {
            CareerGuidanceVO careerGuidanceVO = new CareerGuidanceVO();
            careerGuidanceVO.copyEntity(careerGuidanceEntity);
            String time = careerGuidanceVO.getCgPublishTime();
            if(time!=null&&!"".equals(time)){
                String dateTime = time.substring(0,16);
                careerGuidanceVO.setCgPublishTime(dateTime);
            }
            careerGuidanceVOs.add(careerGuidanceVO);

        }
        replyDataMode.setData(careerGuidanceVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    /**
     * 获取新闻的上一篇，下一篇
     */
    @RequestMapping("/relationlist.do")
    @ResponseBody
    public ReplyDataMode careerGuidanceRelationList(CareerGuidanceSearchForm searchForm, HttpServletRequest request) {
        String myid = searchForm.getId();

        ReplyDataMode dataMode = new ReplyDataMode();

        String sql ="select * from dxs_career_guidance where is_delete=0 and cg_catelog_id ="
                + searchForm.getCgCatelogId()
                +" order by cg_publish_time desc";

        List careerGuidance = this.sysService.findListbySql(sql);

        int preId = 0;
        int nextId = 0;

        for(int i=0;i<careerGuidance.size();i++){
            Object [] obj = (Object[])careerGuidance.get(i);

            if(myid.equals(obj[0].toString())){
                preId = i+1;
                nextId = i-1;
            }
        }


        // 封装返回数据
        Map<String, Object> temp = new HashMap<>();
        SimpleCareerGuidanceVO next = new SimpleCareerGuidanceVO();
        if (nextId != -1) {
            Object [] obj = (Object[])careerGuidance.get(nextId);
            next.setId(obj[0].toString());
            next.setCgTitle(obj[2].toString());
        } else {
            next = (null);
        }
        SimpleCareerGuidanceVO pre = new SimpleCareerGuidanceVO();
        if (preId != careerGuidance.size()) {
            Object [] obj = (Object[])careerGuidance.get(preId);
            pre.setId(obj[0].toString());
            pre.setCgTitle(obj[2].toString());
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

