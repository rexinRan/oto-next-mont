package com.buss.activesdetails.controller;

import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activesdetails.entity.ActivesDetailsEntity;
import com.buss.activesdetails.trans.from.ActivesDetailsFrom;
import com.buss.activesdetailsdays.entity.ActivesDetailsDaysEntity;
import com.buss.activesdetailsdays.trans.from.ActivesDetailsDaysFrom;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.activity.entity.ActiveUsersEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.service.SysServiceI;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
 * Created by Administrator on 2016/8/4.
 */
@Controller
@RequestMapping("/ActivesDetailsController")
public class ActivesDetailsController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 活动游学中的活动详情页
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping(value = "tourDetails")
    @ResponseBody
    public ReplyDataMode tourDetails(ActivesSearchForm searchForm,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (searchForm.getId() != null && !searchForm.getId().isEmpty()) {
            Map map = new HashMap();
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class, searchForm.getId());
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity.getActiveAddress() != null && !activessEntity.getActiveAddress().isEmpty()){
                activessEntity.setActiveAddress(activessEntity.getActiveAddress().replaceAll("#"," "));
            }

            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }

            // 活动定金
            if (activessVO.getActivePrice() != null && !activessVO.getActivePrice().isEmpty()){
                Integer price  = Integer.parseInt(activessVO.getActivePrice());
                int earnest = (int) (price * 0.4);
                map.put("earnest",earnest);
            }

            // 活动
            map.put("activessVO",activessVO);

            // 获取当前登录用户
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            //是否关注、收藏
            /*if(user!=null){
                String isCollention = null;
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(activessVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                collentionEntity.setType(2);
                List<CollentionsEntity> collentions = this.sysServiceI.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null && collentions.size() > 0){
                    isCollention = "已关注";
                }else {
                    isCollention = "未关注";
                }
                map.put("isCollention",isCollention);

                // 是否推荐
                String recommend = null;
                ActiveUserEntity activeUserEntity = new ActiveUserEntity();
                activeUserEntity.setUserId(user.getId());
                activeUserEntity.setActiveId(activessVO.getId());
                activeUserEntity.setIsDelete(0);
                List<ActiveUserEntity> activeUsers = this.sysServiceI.findByExample(ActiveUserEntity.class.getName(),activeUserEntity);
                if (activeUsers != null && activeUsers.size() > 0){
                    // 主动报名
                    if ("0".equals(activeUsers.get(0).getType() + "")){
                        recommend = "主动报名";
                        // 推荐报名
                    }else if ("1".equals(activeUsers.get(0).getType() + "")){
                        recommend = "推荐报名";
                    }
                }
                map.put("recommend",recommend);
            }*/

            List<ActiveUsersEntity> list = this.sysServiceI.findByProperty(ActiveUsersEntity.class, "activeId", activessEntity.getId());
            // 报名人数
            Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }
            // 该活动的报名人数
            map.put("userCount",userCount);

            // 活动扩展(推荐理由)
            ActivesDetailsFrom activesDetailsFrom = new ActivesDetailsFrom();
            activesDetailsFrom.setActivesId(searchForm.getId());
            activesDetailsFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = activesDetailsFrom.getCriteriaQuery();
            List<ActivesDetailsEntity> activesDetailsEntityList = this.sysServiceI.list(criteriaQuery);
            if (activesDetailsEntityList != null && activesDetailsEntityList.size() > 0){
                // 推荐理由
                String[] recommendedReason = null;
                if (activesDetailsEntityList.get(0).getRecommendedReason() != null && !activesDetailsEntityList.get(0).getRecommendedReason().isEmpty()){
                    recommendedReason = activesDetailsEntityList.get(0).getRecommendedReason().split("#");
                }
                map.put("recommendedReason",recommendedReason);

                // 费用包含
                String[] costInclude = activesDetailsEntityList.get(0).getCostInclude().split("#");
                map.put("costInclude",costInclude);

                // 费用不包含
                String[] costUninclude = activesDetailsEntityList.get(0).getCostUninclude().split("#");
                map.put("costUninclude",costUninclude);

                // 行前准备
                String[] preparation = activesDetailsEntityList.get(0).getPreparation().split("#");
                map.put("preparation",preparation);

                // 常见问题
                String[] commonProblem = activesDetailsEntityList.get(0).getCommonProblem().split("#");
                map.put("commonProblem",commonProblem);

                // 签证须知
                String[] visaNote = activesDetailsEntityList.get(0).getVisaNote().split("#");
                map.put("visaNote",visaNote);

                map.put("activesDetailsEntityList",activesDetailsEntityList);
            }

            // 团(选择出发日期和出发城市)
            if (activesDetailsEntityList != null && activesDetailsEntityList.size() > 0){
                String activesStart2 = activesDetailsEntityList.get(0).getActivesStart2();
                if (activesStart2 != null && !activesStart2.isEmpty()){
                    // 团(出发城市)
                    String city = null;
                    // 团(出发时间)
                    String outDate = null;
                    // 团所展示的每一条数据
                    String[] arr = activesStart2.split("#");
                    if (arr != null && arr.length > 0){
                        List<Map> groupLists = new ArrayList<Map>();
                        for (int i = 0;i < arr.length; i++){
                            Map<String,Object> groupMap = new HashMap<String,Object>();
                            // 一条数据中的出发城市和出发时间
                            String[] individuality = arr[i].split("\\*");
                            outDate = individuality[0];
                            city = individuality[1];
                            groupMap.put("outDate",outDate);
                            groupMap.put("city",city);
                            groupLists.add(groupMap);
                        }
                        // 团
                        map.put("groupLists",groupLists);
                    }
                }
            }

            // 活动行程天数
            ActivesDetailsDaysFrom activesDetailsDaysFrom = new ActivesDetailsDaysFrom();
            activesDetailsDaysFrom.setActiveId(searchForm.getId());
            activesDetailsDaysFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery1 = activesDetailsDaysFrom.getCriteriaQuery();
            List<ActivesDetailsDaysEntity> activesDetailsDaysEntityList = this.sysServiceI.list(criteriaQuery1);
            if (activesDetailsDaysEntityList != null){
                map.put("activesDetailsDaysEntityList",activesDetailsDaysEntityList);
            }
            replyDataMode.setData(map);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }
}
