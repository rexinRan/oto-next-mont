package com.buss.actives.controller;

import com.alibaba.fastjson.JSON;
import com.buss.activecatelog.entity.ActiveCatelogEntity;
import com.buss.activecatelog.trans.form.ActiveCatelogSearchForm;
import com.buss.activecatelog.trans.vo.ActiveCatelogVO;
import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activescompanies.entity.ActivesCompaniesEntity;
import com.buss.activescompanies.trans.from.ActivesCompaniesFrom;
import com.buss.activescompanies.trans.vo.ActivesCompaniesVo;
import com.buss.activesfriendship.entity.ActivesFriendshipEntity;
import com.buss.activesfriendship.trans.from.ActivesFriendshipFrom;
import com.buss.activesfriendship.trans.vo.ActivesFriendshipVo;
import com.buss.activesmathch.entity.ActivesMathchEntity;
import com.buss.activesmathch.trans.from.ActivesMathchFrom;
import com.buss.activesmathch.trans.vo.ActivesMathchVo;
import com.buss.activespainting.entity.ActivesPaintingEntity;
import com.buss.activespainting.trans.from.ActivesPaintingFrom;
import com.buss.activespainting.trans.vo.ActivesPaintingVo;
import com.buss.activesroadshowapply.entity.ActivesRoadshowApplyEntity;
import com.buss.activesroadshowapply.trans.from.ActivesRoadshowApplyFrom;
import com.buss.activesroadshowapply.trans.vo.ActivesRoadshowDetailVo;
import com.buss.activesweek.entity.ActivesWeekEntity;
import com.buss.activesweek.trans.from.ActivesWeekFrom;
import com.buss.activesweek.trans.vo.ActivesWeekVo;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.activity.entity.ActiveUsersEntity;
import com.buss.activity.trans.form.ActiveForm;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.collentions.trans.form.CollentionsSearchForm;
import com.buss.common.controller.MessyCode;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistCityEntity;
import com.buss.dist.entity.DxsDistProvinceEntity;
import com.buss.dist.trans.form.DistCityForm;
import com.buss.dist.trans.vo.DistCityVo;
import com.buss.dist.trans.vo.DistProvinceVo;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.form.member.GeneralUserForm;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author lu
 */
@Controller
@RequestMapping("/actives")
public class ActivesController {

    @Resource
    private SysServiceI sysService;
    @Resource
    private RedisClient redisClient;
    @Resource
    private MessyCode messyCode;


    /**
     * 首页中的最新活动
     *
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping("/newIndexList.do")
    @ResponseBody
    public ReplyDataMode newIndexList(ActivesSearchForm searchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        String key = "";
        if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
            key = CacheKey.INDEX_ACTIVES;
            // TODO 查Redis缓存
            Object cache = redisClient.get(key);
            if (cache != null) {
                replyDataMode.setData(cache);
                replyDataMode.setStatusCode("201-读缓存");
                replyDataMode.setSuccess(true);
                return replyDataMode;
            }
        }

        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        searchForm.setIsDelete("0");
        searchForm.setDisplayMenu("最新活动");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ActivesEntity> actives = mode.getResult();

        List<Map> maps = new ArrayList<Map>();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
            List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

            Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }

            String activeStatu = "";
            Date date = new Date();
            if (date.before(activesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                activeStatu = "进行中";
            } else if (date.after(activesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            String catelogName = activeCatelogEntity.getActiveCatelogName();
            ActivesVO activesVO = new ActivesVO();
            activesVO.copyEntity(activesEntity);
            //是否关注、收藏
            activesVO.setIsCollention("未关注");
            if(user!=null){
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(activesVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null&&collentions.size()>0){
                    activesVO.setIsCollention("已关注");
                }
            }

            activesVO.setActiveContent(null);
            map.put("active", activesVO);
            map.put("catelogName", catelogName);
            map.put("userCount", activesVO.getRegNumbers());
            map.put("activeStatu", activeStatu);
            maps.add(map);
        }
        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        if (key != "") {
            // TODO 设置Redis缓存
            Object obj = JSON.toJSON(mode);
            redisClient.put(key, obj);
        }
        return replyDataMode;
    }

    //活动中心最新活动
    @RequestMapping("/newList.do")
    @ResponseBody
    public ReplyDataMode newList(ActivesSearchForm searchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        searchForm.setIsDelete("0");
        searchForm.setDisplayMenu("最新活动");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ActivesEntity> actives = mode.getResult();

        List<Map> maps = new ArrayList<Map>();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
            List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

            Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }

            String activeStatu = "";
            Date date = new Date();
            if (date.before(activesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                activeStatu = "进行中";
            } else if (date.after(activesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            ActivesVO activesVO = new ActivesVO();
            activesVO.setIsCollention("未关注");
            if (user != null){
                // 查询是否关注
                if (!StringUtil.isEmpty(activesEntity.getId())){
                    CollentionsSearchForm collentions = new CollentionsSearchForm();
                    collentions.setOutId(activesEntity.getId());
                    collentions.setType("2");
                    collentions.setUserId(user.getId());
                    CriteriaQuery criteriaQuery1 = collentions.getCriteriaQuery();
                    List<CollentionsEntity> collentionsEntitylist = this.sysService.list(criteriaQuery1);

                    if (collentionsEntitylist != null && collentionsEntitylist.size() > 0){
                        activesVO.setIsCollention("已关注");
                    }
                }
            }

            String catelogName = activeCatelogEntity.getActiveCatelogName();
            activesVO.copyEntity(activesEntity);
            activesVO.setActiveContent(null);
            map.put("active", activesVO);
            map.put("catelogName", catelogName);
            map.put("userCount", activesVO.getRegNumbers());
            map.put("activeStatu", activeStatu);
            maps.add(map);
        }
        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 首页中的精品活动
     *
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping("/pageIndexList.do")
    @ResponseBody
    public ReplyDataMode pageIndexList(ActivesSearchForm searchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        String key = "";
        if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
            if (!StringUtil.isEmpty(searchForm.getPid())) {
                key = CacheKey.INDEX_ACTIVES_PID;
            } else if ("6".equals(searchForm.getPageSize())) {
                key = CacheKey.INDEX_ACTIVES_6;
            }

            if (key != "") {
                // TODO 查Redis缓存
                Object cache = redisClient.get(key);
                if (cache != null) {
                    replyDataMode.setData(cache);
                    replyDataMode.setStatusCode("201-读缓存");
                    replyDataMode.setSuccess(true);
                    return replyDataMode;
                }
            }
        }

        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ActivesEntity> actives = mode.getResult();

        List<Map> maps = new ArrayList<Map>();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
            List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

            Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }

            String activeStatu = "";
            Date date = new Date();
            if (date.before(activesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                activeStatu = "进行中";
            } else if (date.after(activesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            String catelogName = activeCatelogEntity.getActiveCatelogName();
            ActivesVO activesVO = new ActivesVO();
            activesVO.copyEntity(activesEntity);

            //是否关注、收藏
            activesVO.setIsCollention("未关注");
            if(user!=null){
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(activesVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null&&collentions.size()>0){
                    activesVO.setIsCollention("已关注");
                }
            }

            activesVO.setActiveContent(null);
            map.put("active", activesVO);
            map.put("catelogName", catelogName);
            map.put("userCount", activesVO.getRegNumbers());
            map.put("activeStatu", activeStatu);
            maps.add(map);
        }
        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        if (key != "") {
            // TODO 设置Redis缓存
            Object obj = JSON.toJSON(mode);
            redisClient.put(key, obj);
        }

        return replyDataMode;
    }

    /**
     * 活动中心的精品活动
     *
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode activespageList(ActivesSearchForm searchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ActivesEntity> actives = mode.getResult();

        List<Map> maps = new ArrayList<Map>();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
            List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

            Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }

            String activeStatu = "";
            Date date = new Date();
            if (date.before(activesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                activeStatu = "进行中";
            } else if (date.after(activesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            String catelogName = activeCatelogEntity.getActiveCatelogName();
            ActivesVO activesVO = new ActivesVO();
            activesVO.copyEntity(activesEntity);
            activesVO.setActiveContent(null);
            map.put("active", activesVO);
            map.put("catelogName", catelogName);
            map.put("userCount", activesVO.getRegNumbers());
            map.put("activeStatu", activeStatu);
            maps.add(map);
        }
        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);


        return replyDataMode;
    }

    /**活动详情*/
    @RequestMapping("/activesById.do")
    @ResponseBody
    public ReplyDataMode activesById(ActivesSearchForm searchForm, HttpServletRequest request) {
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<ActivesEntity> actives = this.sysService.list(criteriaQuery);
        List<ActivesVO> activesVOs = new ArrayList<ActivesVO>();

        for (ActivesEntity activesEntity : actives) {
            ActivesVO activesVO = new ActivesVO();
            activesVO.copyEntity(activesEntity);
            activesVOs.add(activesVO);

        }
        replyDataMode.setData(activesVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    // ===========================================================================================================================================================


    @Resource
    private ActiveCenterController centerController;


    /**
     * 活动条件查询
     *
     * @param searchForm
     * @param schedule   活动进度
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "activityList")
    @ResponseBody
    public ReplyDataMode activityList(ActivesSearchForm searchForm,String city, String schedule, int curPage, int pageSize, HttpServletRequest request) {
        // 将省进行乱码处理     注:将省市分开中间加#作为分隔符
        String compancyName = searchForm.getActiveAddress();
        if (compancyName != null && compancyName != "") {
//            try {
//                compancyName = new String(compancyName.getBytes("iso-8859-1"), "utf-8");
                compancyName = compancyName + "#";
                // 因为活动的地址是模糊查询,searchForm会调CriteriaQuery,所以在调CriteriaQuery之前将searchForm中的活动地址置为null
                searchForm.setActiveAddress(null);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
        }else if (searchForm.getActiveAddress() == null || searchForm.getActiveAddress().isEmpty()){
            searchForm.setActiveAddress(null);
        }
        // 将市进行乱码处理
        if (city != null && !city.isEmpty()){
//            city = messyCode.messyCodeTreatment(city) + "#";
            city = city + "#";
            // 将省市用#号进行拼接
            if (compancyName != null && !compancyName.isEmpty()){
                compancyName = compancyName + city;
            }

        }

        ReplyDataMode replyDataMode = new ReplyDataMode();
        PageMode mode = null;

        // 处理精彩回顾为空的判断
        if (searchForm.getHistaryDate() != null && searchForm.getHistaryDate().isEmpty()){
            searchForm.setHistaryDate(null);
        }
        CriteriaQuery criteriaQuery = null;

        if (searchForm.getActiveCatelogId() != null || searchForm.getPid() != null) {
            // 设置查询条件
            searchForm.setIsDelete("0");

            criteriaQuery = searchForm.getCriteriaQuery();

            criteriaQuery.addOrder("createTime", "desc");
            criteriaQuery.addOrder("updateTime", "desc");

            /**活动进程判断*/
            centerController.activeSchedule(criteriaQuery,schedule);

            // 活动地址模糊查询
            if (compancyName != null && !compancyName.isEmpty()) {
                criteriaQuery.like("activeAddress", "%" + compancyName + "%");
            }else if (city != null && !city.isEmpty()){
                criteriaQuery.like("activeAddress", "%" + city + "%");
            }
            criteriaQuery.add();

            // 查询符合所有查询条件的活动
            mode = this.sysService.list4page(criteriaQuery, curPage, pageSize);
            List<ActivesEntity> actives = mode.getResult();

            List<Map> maps = new ArrayList<Map>();

            if (actives != null && actives.size() > 0){
                for (ActivesEntity activesEntity : actives) {

                    Map<String, Object> map = new HashMap<>();
                    if (activesEntity.getActiveCatelogId() != null && activesEntity.getId() != null) {
                        ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
//                        List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

                        // 列表页查询
                        if(activesEntity.getActiveCatelogId() != null && !activesEntity.getActiveCatelogId().isEmpty()){

                            // 判断activeCatelogId是否为创业路演的活动(9)
                            if ("9".equals(activesEntity.getActiveCatelogId())){
                                ActivesRoadshowDetailVo activesRoadshowApplyVo = this.projectNmae(activesEntity);
                                List<UserCompancyEntity> userCompancyEntityList = this.sysService.findByProperty(UserCompancyEntity.class,"userId",activesRoadshowApplyVo.getUserId());

                                if(userCompancyEntityList!=null&&userCompancyEntityList.size() > 0){
                                    UserCompancyEntity userCompancyEntity = userCompancyEntityList.get(0);
                                    activesRoadshowApplyVo.setCompanyName(userCompancyEntity.getCompancyName());
                                }

                                map.put("activesRoadshowApplyVo",activesRoadshowApplyVo);
                            }

                            // 判断activecatelogIg是否为校园联谊/爱好者同行的活动(11/12)
                            if ("11".equals(activesEntity.getActiveCatelogId()) || "12".equals(activesEntity.getActiveCatelogId())){
                                ActivesFriendshipVo activesFriendshipVo = this.Friendship(activesEntity);

                                map.put("activesFriendshipVo",activesFriendshipVo);
                            }

                            // 判断activecatelogIg是否为周末旅行的活动(14)
                            if ("14".equals(activesEntity.getActiveCatelogId())){
                                ActivesWeekVo activesWeekVo = this.ActivesWeek(activesEntity);

                                map.put("activesWeekVo",activesWeekVo);
                            }

                            // 判断activecatelogIg是否为校园赛事的活动(10)
                            if ("10".equals(activesEntity.getActiveCatelogId())){
                                ActivesMathchVo activesMathchVo = this.activesMathch(activesEntity);

                                map.put("activesMathchVo",activesMathchVo);
                            }

                            // 判断activecatelogIg是否为书画巡展的活动(13)
                            if ("13".equals(activesEntity.getActiveCatelogId())){
                                ActivesPaintingVo activesPaintingVo = this.activesPainting(activesEntity);

                                map.put("activesMathchVo",activesPaintingVo);
                            }
                        }

                        // 报名人数
                        /*Integer userCount = 0;
                        if (list != null && list.size() != 0) {
                            userCount = list.size();
                        }*/



                        String activeStatu = "";
                        Date date = new Date();

                        // 当前时间小于报名截止时间返回true
                        if (date.before(activesEntity.getDeadlineDate())) {
                            activeStatu = "报名中";
                            // 当前时间大于报名截止时间小于报名开始时间
                        } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))) {
                            activeStatu = "报名结束";
                            // 当前时间小于活动结束时间或大于活动开始时间
                        } else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                            activeStatu = "进行中";
                            // 当前时间大于活动结束时间
                        } else if (date.after(activesEntity.getActiveEndTime())) {
                            activeStatu = "已结束";
                        }

                        String catelogName = activeCatelogEntity.getActiveCatelogName();
                        ActivesVO activesVO = new ActivesVO();
                        activesVO.copyEntity(activesEntity);

                        /**当前活动是否有关注*/
                        // 获取当前用户
                        Subject currentUser = SecurityUtils.getSubject();
                        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

                        //是否关注、收藏
                        activesVO.setIsCollention("未关注");
                        if(user!=null){
                            CollentionsEntity collentionEntity = new CollentionsEntity();
                            collentionEntity.setOutId(activesVO.getId());
                            collentionEntity.setUserId(user.getId());
                            collentionEntity.setIsDelete(0);
                            List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                            if(collentions != null&&collentions.size()>0){
                                activesVO.setIsCollention("已关注");
                            }
                        }

                        map.put("active", activesVO);
                        map.put("catelogName", catelogName);
                        map.put("userCount", activesVO.getRegNumbers());
                        map.put("activeStatu", activeStatu);

                        maps.add(map);
                    }
                }
            }

            mode.setResult(maps);
        }

        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 根据活动的ID查询书画巡展
     * @param activesEntity
     * @return
     */
    public ActivesPaintingVo activesPainting(ActivesEntity activesEntity){
        ActivesPaintingFrom activesPaintingFrom = new ActivesPaintingFrom();
        activesPaintingFrom.setIsDelete("0");
        activesPaintingFrom.setActiveId(activesEntity.getId());

        CriteriaQuery criteriaQuery = activesPaintingFrom.getCriteriaQuery();
        List<ActivesPaintingEntity> activesPaintingEntityList = this.sysService.list(criteriaQuery);

        ActivesPaintingVo activesPaintingVo = new ActivesPaintingVo();
        if (activesPaintingEntityList != null && activesPaintingEntityList.size() > 0){

            activesPaintingVo.copyEntity(activesPaintingEntityList.get(0));

            /*// 将精彩回放链接以"#"好切割
            String[] picture = null;
            Map<String,Object> pictureMap = new HashMap<String,Object>();
            if (activesMathchEntityList.get(0).getImgurls() != null && !activesMathchEntityList.get(0).getImgurls().isEmpty()){
                picture = activesMathchEntityList.get(0).getImgurls().split("#");
                activesMathchVo.setPicture(picture);
            }*/
        }
        return activesPaintingVo;
    }


    /**
     * 根据活动的ID查询校园赛事
     * @param activesEntity
     * @return
     */
    public ActivesMathchVo activesMathch(ActivesEntity activesEntity){
        ActivesMathchFrom activesMathchFrom = new ActivesMathchFrom();
        activesMathchFrom.setIsDelete("0");
        activesMathchFrom.setActiveId(activesEntity.getId());

        CriteriaQuery criteriaQuery = activesMathchFrom.getCriteriaQuery();
        List<ActivesMathchEntity> activesMathchEntityList = this.sysService.list(criteriaQuery);

        ActivesMathchVo activesMathchVo = new ActivesMathchVo();
        if (activesMathchEntityList != null && activesMathchEntityList.size() > 0){

            activesMathchVo.copyEntity(activesMathchEntityList.get(0));

            /*// 将精彩回放链接以"#"好切割
            String[] picture = null;
            Map<String,Object> pictureMap = new HashMap<String,Object>();
            if (activesMathchEntityList.get(0).getImgurls() != null && !activesMathchEntityList.get(0).getImgurls().isEmpty()){
                picture = activesMathchEntityList.get(0).getImgurls().split("#");
                activesMathchVo.setPicture(picture);
            }*/
        }

        return activesMathchVo;
    }


    /**
     * 根据活动的ID查询周末旅行
     * @param activesEntity
     * @return
     */
    public ActivesWeekVo ActivesWeek(ActivesEntity activesEntity){
        ActivesWeekFrom activesWeekFrom = new ActivesWeekFrom();
        activesWeekFrom.setIsDelete("0");
        activesWeekFrom.setActiveId(activesEntity.getId());

        CriteriaQuery criteriaQuery = activesWeekFrom.getCriteriaQuery();
        List<ActivesWeekEntity> ActivesWeekEntityList = this.sysService.list(criteriaQuery);

        ActivesWeekVo activesWeekVo = new ActivesWeekVo();
        if (ActivesWeekEntityList != null && ActivesWeekEntityList.size() > 0){

            activesWeekVo.copyEntity(ActivesWeekEntityList.get(0));

            /*// 将精彩回放链接以"#"好切割
            String[] picture = null;
            Map<String,Object> pictureMap = new HashMap<String,Object>();
            if (ActivesWeekEntityList.get(0).getImgUrls() != null && !ActivesWeekEntityList.get(0).getImgUrls().isEmpty()){
                picture = ActivesWeekEntityList.get(0).getImgUrls().split("#");
                activesWeekVo.setPicture(picture);
            }*/
        }

        return activesWeekVo;
    }



    /**
     * 根据活动ID查询校园联谊/爱好者同行
     * @param activesEntity
     * @return
     */
    public ActivesFriendshipVo Friendship(ActivesEntity activesEntity){
        ActivesFriendshipFrom activesFriendshipFrom = new ActivesFriendshipFrom();
        activesFriendshipFrom.setIsDelete("0");
        activesFriendshipFrom.setActiveId(activesEntity.getId());

        CriteriaQuery criteriaQuery = activesFriendshipFrom.getCriteriaQuery();
        List<ActivesFriendshipEntity> activesFriendshipEntityList = this.sysService.list(criteriaQuery);

        ActivesFriendshipVo activesFriendshipVo = new ActivesFriendshipVo();
        if (activesFriendshipEntityList != null && activesFriendshipEntityList.size() > 0){

            activesFriendshipVo.copyEntity(activesFriendshipEntityList.get(0));

            /*// 将精彩回放链接以"#"好切割
            String[] picture = null;
            Map<String,Object> pictureMap = new HashMap<String,Object>();
            if (activesFriendshipVo.getImgUrls() != null && !activesFriendshipVo.getImgUrls().isEmpty()){
                picture = activesFriendshipVo.getImgUrls().split("#");
                activesFriendshipVo.setPicture(picture);
            }*/
        }

        return activesFriendshipVo;
    }


    /**
     * 根据活动的ID查询创业路演的符合条件的数据
     * @param activesEntity 活动的id
     * @return
     */
    public ActivesRoadshowDetailVo projectNmae(ActivesEntity activesEntity){

        ActivesRoadshowApplyFrom activesRoadshowApplyFrom = new ActivesRoadshowApplyFrom();
        activesRoadshowApplyFrom.setIsDelete("0");
        activesRoadshowApplyFrom.setActivesId(activesEntity.getId());
        activesRoadshowApplyFrom.setResult("1");

        CriteriaQuery criteriaQuery1 = activesRoadshowApplyFrom.getCriteriaQuery();
        criteriaQuery1.addOrder("createTime","desc");

        List<ActivesRoadshowApplyEntity> activesRoadshowApplyEntityList = this.sysService.list(criteriaQuery1);

        ActivesRoadshowDetailVo activesRoadshowApplyVo = new ActivesRoadshowDetailVo();
        if (activesRoadshowApplyEntityList != null && activesRoadshowApplyEntityList.size() > 0){

            activesRoadshowApplyVo.copyEntity(activesRoadshowApplyEntityList.get(0));
        }

        return activesRoadshowApplyVo;
    }


    /**
     * 分类下拉列表查询
     *
     * @param request
     * @param searchForm 活动分类
     * @return
     */
    @RequestMapping(value = "/activityType")
    @ResponseBody
    public ReplyDataMode activityType(HttpServletRequest request, ActiveCatelogSearchForm searchForm) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 设置条件
        searchForm.setIsDelete("0");
        // 将大的活动主题的ID赋值到所有大的活动主题中的小分类主题的ID上
        if (searchForm.getId() != null) {
            searchForm.setPid(searchForm.getId());
            searchForm.setId(null);
        }
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
        criteriaQuery.addOrder("createTime", "desc");
        criteriaQuery.addOrder("updateTime", "desc");
        criteriaQuery.add();

        List<ActiveCatelogEntity> activeCatelogEntityList = this.sysService.list(criteriaQuery);
        List<ActiveCatelogVO> activeCatelogVOs = new ArrayList<ActiveCatelogVO>();

        for (ActiveCatelogEntity ace : activeCatelogEntityList) {
            ActiveCatelogVO activeCatelogVO = new ActiveCatelogVO();
            activeCatelogVO.copyEntity(ace);
            activeCatelogVOs.add(activeCatelogVO);
        }

        replyDataMode.setData(activeCatelogVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 活动中心中的活动区域
     *
     * @return
     */
    @RequestMapping(value = "activityArea")
    @ResponseBody
    public ReplyDataMode activityArea() {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Map<String, List> region = new HashMap<String, List>();
        List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.getList(DxsDistProvinceEntity.class);
        List<DistProvinceVo> distProvinceVos = new ArrayList<DistProvinceVo>();
        List<DistCityVo> distCityVos = new ArrayList<DistCityVo>();

        if (distProvinceEntityList != null && distProvinceEntityList.size() > 0) {
            for (DxsDistProvinceEntity dpe : distProvinceEntityList) {
                DistProvinceVo distProvinceVo = new DistProvinceVo();
                distProvinceVo.copyEntity(dpe);
                distProvinceVos.add(distProvinceVo);

                if (dpe.getProvinceid() != null) {
                    DistCityForm distCityForm = new DistCityForm();
                    distCityForm.setProvinceid(dpe.getProvinceid() + "");
                    CriteriaQuery criteriaQuery = distCityForm.getCriteriaQuery();
                    List<DxsDistCityEntity> distCityEntityList = this.sysService.list(criteriaQuery);

                    for (DxsDistCityEntity dce : distCityEntityList) {
                        DistCityVo distCityVo = new DistCityVo();
                        distCityVo.copyEntity(dce);
                        distCityVos.add(distCityVo);
                    }
                }
            }
        }
        region.put("distProvinceVos", distProvinceVos);  // 省
        region.put("distCityVos", distCityVos);              // 市
        replyDataMode.setData(region);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }

    /**
     * 精彩回顾下拉选
     *
     * @param request
     * @param searchForm
     * @return
     */
    @RequestMapping(value = "wonderfulActivities")
    @ResponseBody
    public ReplyDataMode wonderfulActivities(HttpServletRequest request, ActivesSearchForm searchForm) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
        criteriaQuery.addOrder("histaryDate", "asc");

        List<ActivesEntity> activesEntityList = this.sysService.list(criteriaQuery);
        List<ActivesVO> activesVOs = new ArrayList<ActivesVO>();

        for (ActivesEntity ae : activesEntityList) {
            ActivesVO activesVO = new ActivesVO();
            activesVO.copyEntity(ae);
            activesVOs.add(activesVO);
        }

        replyDataMode.setData(activesVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 活动中的活动详情页
     *
     * @param request
     * @param searchForm 必要的参数"活动的id"
     * @return
     */
    @RequestMapping(value = "eventDetails")
    @ResponseBody
    public ReplyDataMode eventDetails(HttpServletRequest request, ActivesSearchForm searchForm) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (searchForm.getId() != null && !searchForm.getId().isEmpty()) {
            Map map = new HashMap();
            // 该活动
            ActivessEntity activessEntity = this.sysService.get(ActivessEntity.class, searchForm.getId());
            activessEntity.setActiveAddress(activessEntity.getActiveAddress().replaceAll("#","  "));
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }
            map.put("activessVO",activessVO);

            // 活动中心->名企参观
            ActivesCompaniesFrom activesCompaniesFrom = new ActivesCompaniesFrom();
            activesCompaniesFrom.setActiveId(searchForm.getId());
            activesCompaniesFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = activesCompaniesFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");
            List<ActivesCompaniesEntity> activesCompaniesEntityList = this.sysService.list(criteriaQuery);
            ActivesCompaniesVo activesCompaniesVo = new ActivesCompaniesVo();
            String[] photo = null;
            if (activesCompaniesEntityList != null && activesCompaniesEntityList.size() > 0){
                activesCompaniesVo.copyEntity(activesCompaniesEntityList.get(0));

                // 图片切割
                if (activesCompaniesEntityList.get(0).getImages() != null && !activesCompaniesEntityList.get(0).getImages().isEmpty()){
                    photo = activesCompaniesEntityList.get(0).getImages().split("#");
                }
            }
            map.put("photo",photo);
            map.put("activesCompaniesVo",activesCompaniesVo);

            // 获取当前登录用户
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            //是否关注、收藏
            if(user!=null){
                String isCollention = null;
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(activessVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                collentionEntity.setType(2);
                List<CollentionsEntity> collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
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
                List<ActiveUserEntity> activeUsers = this.sysService.findByExample(ActiveUserEntity.class.getName(),activeUserEntity);
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

                List<ActiveUsersEntity> list = this.sysService.findByProperty(ActiveUsersEntity.class, "activeId", activessEntity.getId());
                // 报名人数
                Integer userCount = 0;
                if (list != null && list.size() != 0) {
                    userCount = list.size();
                }
                map.put("userCount",userCount);
            }

            replyDataMode.setData(map);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 教师推荐中的搜索账号
     *
     * @param request
     * @param mphone  搜索的账号
     * @param mphone  搜索的账号
     * @return
     */
    @RequestMapping(value = "accountSaearch")
    @ResponseBody
    public ReplyDataMode accountSaearch(HttpServletRequest request, String mphone) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        GeneralUserForm generalUserForm = new GeneralUserForm();

        Map<Object, Object> userInfo = new HashMap<Object, Object>();
        if (mphone != null) {
            generalUserForm.setMphone(mphone);
            generalUserForm.setIsdelete("0");
            CriteriaQuery criteriaQuery = generalUserForm.getCriteriaQuery();
            List<GeneralUserEntity> generalUserEntityList = this.sysService.list(criteriaQuery);
            userInfo.put("generalUserEntity", generalUserEntityList.get(0));

            // 在通过该用户的id查询用户详情表
            if (generalUserEntityList != null) {
                if (generalUserEntityList.get(0).getId() != null) {
                    UserDetailForm userDetailForm = new UserDetailForm();
                    userDetailForm.setIsDelete("0");
                    userDetailForm.setUserId(generalUserEntityList.get(0).getId());
                    CriteriaQuery criteriaQuery1 = userDetailForm.getCriteriaQuery();
                    List<UserDetailEntity> userDetailEntityList = this.sysService.list(criteriaQuery1);
                    userInfo.put("userDetailEntity", userDetailEntityList.get(0));
                }
            }
        }
        replyDataMode.setData(userInfo);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 报名活动 (必要参数活动的ID   可选参数推荐人的ID)
     * @param recommendUserId    推荐人的ID
     * @param activesSearchForm  活动的ID
     * @param request
     * @return
     */
    @RequestMapping(value = "activityRegistration")
    @ResponseBody
    public ReplyDataMode activityRegistration(String recommendUserId, ActivesSearchForm activesSearchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        ActiveUserEntity activeUserEntity = new ActiveUserEntity();
        activeUserEntity.setStep("0");      // 默认未缴费
        activeUserEntity.setType(0);        // 默认自愿报名

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null) {
            if (user.getId() != null) {
                if (!StringUtil.isEmpty(activesSearchForm.getId())) {
                    Date date = new Date();
                    activesSearchForm.setIsDelete("0");
                    CriteriaQuery criteriaQuery = activesSearchForm.getCriteriaQuery();
                    criteriaQuery.lt("deadlineDate",date);
//                    ActivesEntity activesEntity = this.sysService.get(ActivesEntity.class, activesSearchForm.getId());
                    List<ActivessEntity> activessEntityList = this.sysService.list(criteriaQuery);
                    if (activessEntityList != null && activessEntityList.size() > 0){
                        activeUserEntity.setActiveId(activessEntityList.get(0).getId());
                        activeUserEntity.setUserId(user.getId());
                        activeUserEntity.setOrigin(Integer.toString(activessEntityList.get(0).getActivePrice()));

                        if (!StringUtil.isEmpty(recommendUserId)) {
                            activeUserEntity.setType(1);        // 1:推荐报名
                        }
                        activeUserEntity.setCreateTime(date);
                        activeUserEntity.setIsDelete(0);

                        try {
                            this.sysService.saveOrUpdate(activeUserEntity);

                            replyDataMode.setStatusCode("报名成功,请到个人中心缴费");
                            replyDataMode.setSuccess(true);
                        }catch (Exception e){
                            replyDataMode.setStatusCode("操作失败!");
                            replyDataMode.setSuccess(false);
                        }
                    }else {
                        replyDataMode.setStatusCode("该活动不存在或报名以结束!");
                        replyDataMode.setSuccess(false);
                    }
                }
            }
        } else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 精彩回顾活动
     *
     * @param searchForm
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "wonderfulActivitites")
    @ResponseBody
    public ReplyDataMode wonderfulActivities(ActivesSearchForm searchForm, int curPage, int pageSize, HttpServletRequest request) {

        List<ActiveCatelogEntity> activeCatelogEntityList = null;
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        // 所有精彩回顾的活动
        List<ActivesEntity> actives = null;
        PageMode mode = null;
        List<Map> maps = new ArrayList<Map>();

        // 设置查询条件
        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        criteriaQuery.addOrder("createTime", "desc");
        criteriaQuery.addOrder("updateTime", "desc");
        criteriaQuery.lt("activeEndTime",new Date());
        criteriaQuery.add();

        mode = this.sysService.list4page(criteriaQuery, curPage, pageSize);
        actives = mode.getResult();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
            List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

            // 报名人数
           /* Integer userCount = 0;
            if (list != null && list.size() != 0) {
                userCount = list.size();
            }*/

            String activeStatu = "";
            Date date = new Date();

            if (activesEntity.getDeadlineDate() != null && activesEntity.getActiveEndTime() != null && activesEntity.getActiveStateTime() != null) {
                // 当前时间小于报名截止日期返回true
                if (date.before(activesEntity.getDeadlineDate())) {
                    activeStatu = "报名中";
                    // 当前时间大于报名截止时间小于报名开始时间
                } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))){
                    activeStatu = "报名结束";
                    // 当前时间小于活动结束时间或大于活动开始时间
                }else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                    activeStatu = "进行中";
                    // 当前时间大于活动结束时间
                } else if (date.after(activesEntity.getActiveEndTime())) {
                    activeStatu = "已结束";
                }
            }

            ActivesVO activesVO = new ActivesVO();
            activesVO.setIsCollention("未关注");
            if (user != null){
                // 查询是否关注
                if (!StringUtil.isEmpty(activesEntity.getId())){
                    CollentionsSearchForm collentions = new CollentionsSearchForm();
                    collentions.setOutId(activesEntity.getId());
                    collentions.setType("2");
                    collentions.setUserId(user.getId());
                    CriteriaQuery criteriaQuery1 = collentions.getCriteriaQuery();
                    List<CollentionsEntity> collentionsEntitylist = this.sysService.list(criteriaQuery1);

                    if (collentionsEntitylist != null && collentionsEntitylist.size() > 0){
                        activesVO.setIsCollention("已关注");
                    }
                }
            }

            String catelogName = activeCatelogEntity.getActiveCatelogName();
            activesVO.copyEntity(activesEntity);
            map.put("active", activesVO);
            map.put("catelogName", catelogName);
            map.put("userCount", activesVO.getRegNumbers());
            map.put("activeStatu", activeStatu);
            maps.add(map);

        }

        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 报名中的活动
     * @param searchForm
     * @param schedule   活动进度
     * @param curPage
     * @param pageSize
     * @param pid
     * @param request
     * @return
     */
    @RequestMapping(value = "activitiesInRegistration")
    @ResponseBody
    public ReplyDataMode activitiesInRegistration(ActivesSearchForm searchForm, String schedule, int curPage, int pageSize, String pid, HttpServletRequest request) {
        // 处理乱码
        String compancyName = searchForm.getActiveAddress();
        if (compancyName != null && compancyName != "") {
            try {
                compancyName = new String(compancyName.getBytes("iso-8859-1"), "utf-8");

                // 因为活动的地址是模糊查询,searchForm会调CriteriaQuery,所以在调CriteriaQuery之前将searchForm中的活动地址置为null
                searchForm.setActiveAddress(null);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        // 活动进度乱码处理
        if (schedule != null) {
            try {
                schedule = new String(schedule.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        ReplyDataMode replyDataMode = new ReplyDataMode();
        PageMode mode = null;


        // 设置查询条件
        searchForm.setIsDelete("0");

        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        criteriaQuery.addOrder("createTime", "desc");
        criteriaQuery.addOrder("updateTime", "desc");

        /**活动进程*/
        // 当前时间
        Date nowDate = new Date();
        if (schedule != null) {
            if ("报名中".equals(schedule)) {
                // 报名截止时间大于当前时间
                criteriaQuery.gt("deadlineDate", nowDate);
                // 活动发布时间小于当前时间
                criteriaQuery.lt("publishTime", nowDate);
            }else if ("报名结束".equals(schedule)){
                // 活动开始时间膈俞当前时间
                criteriaQuery.gt("activeStateTime",nowDate);
                // 活动报名截止时间小于当前时间
                criteriaQuery.lt("deadlineDate",nowDate);

            }else if ("进行中".equals(schedule)) {
                // 活动结束时间大于当前时间
                criteriaQuery.ge("activeEndTime", nowDate);
                // 开始时间小于当前时间
                criteriaQuery.lt("activeStateTime", nowDate);

            } else if ("已结束".equals(schedule)) {
                // 活动结束时间小于当前时间
                criteriaQuery.lt("activeEndTime", nowDate);
            }
        }else {
            // 报名截止时间大于当前时间
            criteriaQuery.gt("deadlineDate", nowDate);
            // 活动发布时间小于当前时间
            criteriaQuery.lt("publishTime", nowDate);
        }

        // 活动地址模糊查询
        if (compancyName != null) {
            criteriaQuery.like("activeAddress", "%" + compancyName + "%");
        }
        criteriaQuery.add();

        mode = this.sysService.list4page(criteriaQuery, curPage, pageSize);
        List<ActivesEntity> actives = mode.getResult();

        List<Map> maps = new ArrayList<Map>();

        for (ActivesEntity activesEntity : actives) {
            Map<String, Object> map = new HashMap<>();
            if (activesEntity.getActiveCatelogId() != null && activesEntity.getId() != null) {
                ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
                List<ActiveUserEntity> list = this.sysService.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

                // 报名人数
                Integer userCount = 0;
                if (list != null && list.size() != 0) {
                    userCount = list.size();
                }

                String activeStatu = "";
                Date date = new Date();

                // 报名截止日期小于当前时间返回true
                if (date.before(activesEntity.getDeadlineDate())) {
                    activeStatu = "报名中";
                    // 当前时间大于报名截止时间小于报名开始时间
                } else if ((date.after(activesEntity.getDeadlineDate())) && (date.before(activesEntity.getActiveStateTime()))){
                    activeStatu = "报名结束";
                    // 当前时间小于活动结束时间或大于活动开始时间
                }else if ((date.before(activesEntity.getActiveEndTime())) && (date.after(activesEntity.getActiveStateTime()))) {
                    activeStatu = "进行中";
                    // 当前时间大于活动结束时间
                } else if (date.after(activesEntity.getActiveEndTime())) {
                    activeStatu = "已结束";
                }

                String catelogName = activeCatelogEntity.getActiveCatelogName();
                ActivesVO activesVO = new ActivesVO();
                activesVO.copyEntity(activesEntity);
                map.put("active", activesVO);
                map.put("catelogName", catelogName);
                map.put("userCount", userCount);
                map.put("activeStatu", activeStatu);
                maps.add(map);
            }
        }

        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    // =============================================================个人中心中的活动================================================

    /**
     * 关注活动
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "focusActivities")
    @ResponseBody
    public ReplyDataMode focusActivities(HttpServletRequest request, CollentionsSearchForm collentionsForm) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null && user.getId() != null) {
            collentionsForm.setUserId(user.getId());
            collentionsForm.setType("2");   // type类型2是活动
            collentionsForm.setIsDelete("0");

            CriteriaQuery criteriaQuery = collentionsForm.getCriteriaQuery();
            criteriaQuery.addOrder("createTime", "desc");

            if (collentionsForm.getPageNo() != null && collentionsForm.getPageNo() != null) {
                int pageNo = Integer.parseInt(collentionsForm.getPageNo());
                int pageSize = Integer.parseInt(collentionsForm.getPageSize());
                PageMode pageMode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);

                List<CollentionsEntity> collentionsEntityList = pageMode.getResult();
                List<Object> list = new ArrayList<Object>();

                if (collentionsEntityList != null && collentionsEntityList.size() > 0) {
                    for (CollentionsEntity ce : collentionsEntityList) {

                        Map<String,Object> map = new HashMap<String,Object>();
                        if (ce.getOutId() != null && !ce.getOutId().isEmpty()){
                            // 所关注的活动
                            ActivessEntity activessEntity = this.sysService.get(ActivessEntity.class,ce.getOutId());
                            if (activessEntity != null){
                                ActivesVO activesVO = new ActivesVO();
                                activesVO.copyEntity(activessEntity);
                                map.put("activesVo",activesVO);
                            }

                            // 活动类型
                            if (activessEntity.getActiveCatelogId() != null && !activessEntity.getActiveCatelogId().isEmpty()){
                                ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class,activessEntity.getActiveCatelogId());
                                map.put("activeCatelogName",activeCatelogEntity.getActiveCatelogName());
                            }

                            // 活动是否缴费
                            List<ActiveUserEntity> activeUsersEntityList = null;
                            if (ce.getOutId() != null && !ce.getOutId().isEmpty()){
                                ActiveForm activeForm = new ActiveForm();
                                activeForm.setActiveId(ce.getOutId());
                                activeForm.setIsDelete("0");
                                CriteriaQuery criteriaQuery1 = activeForm.getCriteriaQuery();

                                activeUsersEntityList = this.sysService.list(criteriaQuery1);
                            }

                            if (activeUsersEntityList != null && activeUsersEntityList.size() > 0){
                                map.put("whetherToPay",activeUsersEntityList.get(0).getStep());
                            }else {
                                map.put("whetherToPay",null);
                            }
                            list.add(map);
                        }
                    }
                }

                pageMode.setResult(list);
                replyDataMode.setData(pageMode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }


        } else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 已报名的活动
     *
     * @param activeForm 已报名活动
     * @param request
     * @return
     */
    @RequestMapping(value = "registrationActivities")
    @ResponseBody
    public ReplyDataMode registrationActivities(ActiveForm activeForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activeForm.setIsDelete("0");

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null && user.getId() != null) {
            activeForm.setUserId(user.getId());
            activeForm.setIsDelete("0");

            CriteriaQuery criteriaQuery = activeForm.getCriteriaQuery();
            criteriaQuery.addOrder("createTime", "desc");

            if (activeForm.getPageNo() != null && activeForm.getPageNo() != null) {
                int pageNo = Integer.parseInt(activeForm.getPageNo());
                int pageSize = Integer.parseInt(activeForm.getPageSize());
                PageMode pageMode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);

                List<ActiveUserEntity> activeUserEntityList = pageMode.getResult();
                List<Object> list = new ArrayList<Object>();

                if (activeUserEntityList != null && activeUserEntityList.size() > 0) {
                    for (ActiveUserEntity ce : activeUserEntityList) {

                        Map<String,Object> map = new HashMap<String,Object>();
                        if (ce.getActiveId() != null && !ce.getActiveId().isEmpty()){
                            // 报名的活动
                            ActivessEntity activessEntity = this.sysService.get(ActivessEntity.class,ce.getActiveId());
                            if (activessEntity != null){
                                ActivesVO activesVO = new ActivesVO();
                                activesVO.copyEntity(activessEntity);
                                map.put("activesVo",activesVO);
                            }

                            // 活动类型
                            if (activessEntity.getActiveCatelogId() != null && !activessEntity.getActiveCatelogId().isEmpty()){
                                ActiveCatelogEntity activeCatelogEntity = this.sysService.get(ActiveCatelogEntity.class,activessEntity.getActiveCatelogId());
                                map.put("activeCatelogName",activeCatelogEntity.getActiveCatelogName());
                            }

                            // 活动是否缴费
                            map.put("whetherToPay",ce.getStep());
                            // 实际缴费金额
                            map.put("realityPrice",ce.getPrice());
                        }

                        list.add(map);
                    }
                }

                pageMode.setResult(list);
                replyDataMode.setData(pageMode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        } else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }

    /**
     * 已参加活动
     *
     * @param activeForm
     * @param request
     * @return
     */
    @RequestMapping(value = "haveParticipatedInActivities")
    @ResponseBody
    public ReplyDataMode haveParticipatedInActivities(ActiveForm activeForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 分页模型设置
        PageMode mode = new PageMode();
        int total = 0;
        int pageNo = 0;
        int pageSize = 0;
        if (!StringUtil.isEmpty(activeForm.getPageNo()) && !StringUtil.isEmpty(activeForm.getPageSize())) {
            pageNo = Integer.parseInt(activeForm.getPageNo());
            pageSize = Integer.parseInt(activeForm.getPageSize());
        }

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null) {
            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(activeForm.getPageNo()) && !StringUtil.isEmpty(activeForm.getPageSize())) {
                pageNo = Integer.parseInt(activeForm.getPageNo());
                pageSize = Integer.parseInt(activeForm.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) + "," + pageSize);
            }


            String sql = "SELECT\n" +
                    "\ta.active_title,\n" +
                    "\tac.active_catelog_name,\n" +
                    "\ta.active_end_time,\n" +
                    "\ta.active_state_time,\n" +
                    "\ta.deadline_date,\n" +
                    "\ta.publish_time,\n" +
                    "\ta.active_price,\n" +
                    "\ta.gift_account_count,\n" +
                    "\ta.remarks\n" +
                    "FROM\n" +
                    "\tdxs_active_user au,\n" +
                    "\tdxs_actives a,\n" +
                    "\tdxs_active_catelog ac\n" +
                    "WHERE\n" +
                    "\tau.user_id = '"+ user.getId() +"'\n" +
                    "AND au.active_id = a.id\n" +
                    "AND a.active_end_time <= SYSDATE()\n" +
                    "AND a.active_catelog_id = ac.id\n" +
                    "AND\ta.is_delete = '0'\n" +
                    "AND au.is_delete = '0'\n" +
                    "AND ac.is_delete = '0' " + sb_limit.toString();

            String sqlCount = "SELECT\n" +
                    "\tcount(*)\n" +
                    "FROM\n" +
                    "\tdxs_active_user au,\n" +
                    "\tdxs_actives a,\n" +
                    "\tdxs_active_catelog ac\n" +
                    "WHERE\n" +
                    "\tau.user_id = '\"+ user.getId() +\"'\n" +
                    "AND au.active_id = a.id\n" +
                    "AND a.active_end_time <= SYSDATE()\n" +
                    "AND a.active_catelog_id = ac.id\n" +
                    "AND\ta.is_delete = '0'\n" +
                    "AND au.is_delete = '0'\n" +
                    "AND ac.is_delete = '0'";

            // 查询当前用户自参加过的活动
            List<Map> uaList = this.sysService.findListbySql(sql);
            // 共有多少条记录
            List<Map> uaList_count = this.sysService.findListbySql(sqlCount);
            List<Map<String, Object>> aList = new ArrayList();
            if (!uaList.isEmpty()) for (Object obj : uaList) {
                Map map = new HashMap();
                Object[] u = (Object[]) obj;
                String field = "";
                for (int i = 0; i < u.length; i++) {
                    if (u[i] != null) {
                        field = u[i].toString();
                    } else {
                        field = "";
                    }
                    map.put("field" + i, field);
                }
                aList.add(map);
                mode.setTotal(Integer.parseInt(uaList_count.get(0).toString()));
            }
            final int allCounts;
            if (mode.getTotal() != 0) {
                allCounts = mode.getTotal();
            } else {
                allCounts = 0;
            }
            int pageCount = 0;
            if (pageNo != 0 && pageSize != 0) {
                pageCount = (allCounts - 1) / pageSize + 1;
            }
            mode.setPageCount(pageCount);
            mode.setPageNo(pageNo);
            mode.setPageSize(pageSize);
            mode.setResult(aList);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        } else {
            replyDataMode.setStatusCode("用户未登录");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 活动区域
     *
     * @param request
     * @return
     */
    @RequestMapping("activityRegion")
    @ResponseBody
    public ReplyDataMode region(HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Map<String, List> region = new HashMap<String, List>();

        String distProvince = "SELECT\n" +
                "\tdp.pid,dp.pname,dp.provinceID\n" +
                "FROM\n" +
                "\tdxs_dist_province dp\n" +
                "WHERE\n" +
                "\tdp.pname in('北京市','天津市','上海市','重庆市')";
        String distCitySql = "SELECT\n" +
                "\tdc.cid,\n" +
                "\tdc.cityID,\n" +
                "\tdc.city,\n" +
                "\tdc.provinceID\n" +
                "FROM\n" +
                "\tdxs_dist_city dc\n" +
                "WHERE\n" +
                "\tdc.city IN (\n" +
                "\t\t'南京市',\n" +
                "\t\t'兰州市',\n" +
                "\t\t'西安市',\n" +
                "\t\t'济南市',\n" +
                "\t\t'沈阳市',\n" +
                "\t\t'吉林市',\n" +
                "\t\t'石家庄市',\n" +
                "\t\t'哈尔滨市',\n" +
                "\t\t'成都市',\n" +
                "\t\t'武汉市',\n" +
                "\t\t'长沙市',\n" +
                "\t\t'郑州市',\n" +
                "\t\t'太原市',\n" +
                "\t\t'深圳市'\n" +
                "\t)";

        List<DxsDistCityEntity> distCityEntityList = this.sysService.findListbySql(distCitySql);
        List<Map<String, Object>> aList = new ArrayList();
        if (!distCityEntityList.isEmpty()) for (Object obj : distCityEntityList) {
            Map cityMap = new HashMap();
            Object[] u = (Object[]) obj;
            String field = "";
            for (int i = 0; i < u.length; i++) {
                if (u[i] != null) {
                    field = u[i].toString();
                } else {
                    field = "";
                }
                cityMap.put("field" + i, field);
            }
            aList.add(cityMap);
        }


        List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.findListbySql(distProvince);
        if (!distProvinceEntityList.isEmpty()) for (Object obj : distProvinceEntityList) {
            Map ProvinceMap = new HashMap();
            Object[] u = (Object[]) obj;
            String field = "";
            for (int i = 0; i < u.length; i++) {
                if (u[i] != null) {
                    field = u[i].toString();
                } else {
                    field = "";
                }
                ProvinceMap.put("field" + i, field);
            }
            aList.add(ProvinceMap);
        }

        replyDataMode.setData(aList);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }
}

