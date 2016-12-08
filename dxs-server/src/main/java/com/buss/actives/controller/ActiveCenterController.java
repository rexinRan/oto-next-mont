package com.buss.actives.controller;

import com.buss.activecatelog.entity.ActiveCatelogEntity;
import com.buss.activecatelog.trans.form.ActiveCatelogSearchForm;
import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.activity.entity.ActiveUsersEntity;
import com.buss.activity.trans.form.ActiveForm;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.controller.MessyCode;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.RetentionPolicy;
import java.util.*;

/**
 * Created by Administrator on 2016/7/27.
 */
@Controller
@RequestMapping("/activeCenter")
public class ActiveCenterController {

    @Resource
    private SysServiceI sysServiceI;

    @Autowired
    private MessyCode messyCode;

    /**
     * 根据活动种类名称查询所对应的数据          注:活动标题中的悬浮框
     * @return
     */
    @RequestMapping(value = "activityClassification")
    @ResponseBody
    public ReplyDataMode activityClassification(ActiveCatelogSearchForm activeCatelogSearchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 活动种类名称乱码处理
        if (activeCatelogSearchForm.getActiveCatelogName() != null) {
            try {
                String name = activeCatelogSearchForm.getActiveCatelogName();
                activeCatelogSearchForm.setActiveCatelogName(new String(activeCatelogSearchForm.getActiveCatelogName().getBytes("iso-8859-1"), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (activeCatelogSearchForm.getActiveCatelogName() != null){
            activeCatelogSearchForm.setIsDelete("0");
            CriteriaQuery criteriaQuery = activeCatelogSearchForm.getCriteriaQuery();
            List<ActiveCatelogEntity> activeCatelogEntityList = this.sysServiceI.list(criteriaQuery);
            if (activeCatelogEntityList != null && activeCatelogEntityList.size() > 0){
                replyDataMode.setData(activeCatelogEntityList.get(0));
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {
            replyDataMode.setStatusCode("没有该活动类型!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 所有的出发城市和国家下拉列表的接口
     * @param activesSearchForm
     * @param request
     * @return
     */
    @RequestMapping(value = "activeState")
    @ResponseBody
    public ReplyDataMode activeState(ActivesSearchForm activesSearchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Map<String,List> map = new HashMap<String, List>();
        List countrySql = null;  // 国家
        List addressSql = null;   // 出发城市


        // 判断是否是学生游学还是亲子游学还是白领游学
        if (activesSearchForm.getSctiveType2() != null){
            // 根据所有类型的活动查询所对应的国家
            String sql_country = "SELECT DISTINCT a.active_country FROM dxs_actives a WHERE a.set_out_address IS NOT NULL AND a.set_out_address!='' AND a.is_delete='0' AND a.active_catelog_id='"+ activesSearchForm.getActiveCatelogId() +"'";
            if ("1".equals(activesSearchForm.getSctiveType2()) || "2".equals(activesSearchForm.getSctiveType2()) || "3".equals(activesSearchForm.getSctiveType2())) {
                // 学生游学
                if ("1".equals(activesSearchForm.getSctiveType2())){
                    sql_country = sql_country + " AND a.sctive_type_2=1";
                }else if ("2".equals(activesSearchForm.getSctiveType2())) {
                    sql_country = sql_country + " AND a.sctive_type_2=2";
                }else if ("3".equals(activesSearchForm.getSctiveType2())){
                    sql_country = sql_country + " AND a.sctive_type_2=3";
                }
                countrySql = this.sysServiceI.findListbySql(sql_country);  // 所有的活动国家
            }

        }

        if (countrySql != null){
            map.put("countrySql",countrySql);
        }else {
            replyDataMode.setStatusCode("没有出游国家!");
            replyDataMode.setSuccess(false);
        }


        // 判断是否是学生游学还是亲子游学白领游学
        if (activesSearchForm.getSctiveType2() != null){
            // 根据所有类型的活动查询所对应的出发城市
            String sql_out_address = "SELECT DISTINCT a.set_out_address FROM dxs_actives a WHERE a.set_out_address IS NOT NULL AND a.set_out_address!='' AND a.is_delete='0' AND a.active_catelog_id='"+ activesSearchForm.getActiveCatelogId() +"'";
            if ("1".equals(activesSearchForm.getSctiveType2()) || "2".equals(activesSearchForm.getSctiveType2()) || "3".equals(activesSearchForm.getSctiveType2())) {
                // 学生游学
                if ("1".equals(activesSearchForm.getSctiveType2())) {
                    sql_out_address = sql_out_address + " AND a.sctive_type_2=1";
                } else if ("2".equals(activesSearchForm.getSctiveType2())) {
                    sql_out_address = sql_out_address + " AND a.sctive_type_2=2";
                } else if ("3".equals(activesSearchForm.getSctiveType2())) {
                    sql_out_address = sql_out_address + " AND a.sctive_type_2=3";
                }
            }
            addressSql = this.sysServiceI.findListbySql(sql_out_address);  // 所有的出发城市
        }

        if (addressSql != null){
            map.put("addressSql",addressSql);

        }else {
            replyDataMode.setStatusCode("没有出发城市!");
            replyDataMode.setSuccess(false);
        }
        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 出国游学活动的条件查询
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
    public ReplyDataMode activityList(ActivesSearchForm searchForm,String city, String schedule, int curPage, int pageSize,String priceRange, HttpServletRequest request) {
        // 将省进行乱码处理(活动地点)     注:将省市分开中间加#作为分隔符
        String compancyName = searchForm.getActiveAddress();
        if (compancyName != null && compancyName != "") {
            try {
                compancyName = new String(compancyName.getBytes("iso-8859-1"), "utf-8");
                compancyName = compancyName + "#";
                // 因为活动的地址是模糊查询,searchForm会调CriteriaQuery,所以在调CriteriaQuery之前将searchForm中的活动地址置为null
                searchForm.setActiveAddress(null);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        // 将市进行乱码处理
        if (city != null && !city.isEmpty()){
            city = messyCode.messyCodeTreatment(city);
            // 将省市用#号进行拼接
            compancyName = compancyName + city + "#";
        }

        // 活动进度乱码处理
        if (schedule != null) {
            try {
                schedule = new String(schedule.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        // 当前热门游学路线的乱码处理
        /*if (searchForm.getDisplayMenu() != null && !searchForm.getDisplayMenu().isEmpty()) {
            searchForm.setDisplayMenu(messyCode.messyCodeTreatment(searchForm.getDisplayMenu()));
        }*/
        // 活动国家乱码处理
        if (searchForm.getActiveCountry() != null && !searchForm.getActiveCountry().isEmpty()){
//            searchForm.setActiveCountry(messyCode.messyCodeTreatment(searchForm.getActiveCountry()));
            if ("全部".equals(searchForm.getActiveCountry())){
                searchForm.setActiveCountry(null);
            }
        }
        // 出发城市乱码处理
        if (searchForm.getSetOutAddress() != null && searchForm.getSetOutAddress().isEmpty()){
//            searchForm.setSetOutAddress(messyCode.messyCodeTreatment(searchForm.getSetOutAddress()));
            if ("".equals(searchForm.getSetOutAddress())){
                searchForm.setSetOutAddress(null);
            }
        }
        // 适合人群的乱码处理
        String activeUsertypeId = null;
        if (searchForm.getActiveUsertypeId() != null && !searchForm.getActiveUsertypeId().isEmpty()){
//            activeUsertypeId = messyCode.messyCodeTreatment(searchForm.getActiveUsertypeId());
//            searchForm.setActiveUsertypeId(null);

            if ("全部".equals(searchForm.getActiveUsertypeId())){
                searchForm.setActiveUsertypeId(null);
            }else {
                activeUsertypeId = searchForm.getActiveUsertypeId();
                searchForm.setActiveUsertypeId(null);
            }
        }

        // 活动类型
        if ("全部".equals(searchForm.getSctiveType3())){
            searchForm.setSctiveType3(null);
        }

        // 出发时间
        if ("".equals(searchForm.getSetOutTime())){
            searchForm.setSetOutTime(null);
        }


        ReplyDataMode replyDataMode = new ReplyDataMode();
        PageMode mode = null;

        // 处理精彩回顾为空
        if (searchForm.getHistaryDate() != null && searchForm.getHistaryDate().isEmpty()){
            searchForm.setHistaryDate(null);
        }

        if (searchForm.getActiveCatelogId() != null || searchForm.getPid() != null) {
            // 设置查询条件
            searchForm.setIsDelete("0");

            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            criteriaQuery.addOrder("createTime", "desc");
            criteriaQuery.addOrder("updateTime", "desc");

            /**活动进程*/
            this.activeSchedule(criteriaQuery,schedule);

            // 设置价格区间的查询条件
            this.priceCondition(criteriaQuery,priceRange);

            // 活动地址模糊查询
            if (compancyName != null) {
                criteriaQuery.like("activeAddress", "%" + compancyName + "%");
            }
            // 活动的适合人群模糊查询
            if (activeUsertypeId != null){
                criteriaQuery.like("activeUsertypeId","%" + activeUsertypeId +"%");
            }
            criteriaQuery.add();

            mode = this.sysServiceI.list4page(criteriaQuery, curPage, pageSize);
            List<ActivesEntity> actives = mode.getResult();

            List<Map> maps = new ArrayList<Map>();

            for (ActivesEntity activesEntity : actives) {
                Map<String, Object> map = new HashMap<>();
                if (activesEntity.getActiveCatelogId() != null && activesEntity.getId() != null) {
                    ActiveCatelogEntity activeCatelogEntity = this.sysServiceI.get(ActiveCatelogEntity.class, activesEntity.getActiveCatelogId());
                    List<ActiveUserEntity> list = this.sysServiceI.findByProperty(ActiveUserEntity.class, "activeId", activesEntity.getId());

                    // 报名人数
                    Integer userCount = 0;
                    if (list != null && list.size() != 0) {
                        userCount = list.size();
                    }

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
                    activesVO = this.payCloseAttention(activesVO);

                    map.put("active", activesVO);
                    map.put("catelogName", catelogName);
                    map.put("userCount", activesVO.getRegNumbers());
                    map.put("activeStatu", activeStatu);
                    maps.add(map);
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
     * 判断活动是否已关注
     * @param activesVO     活动
     * @return
     */
    public ActivesVO payCloseAttention(ActivesVO activesVO){
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
            List collentions = this.sysServiceI.findByExample(CollentionsEntity.class.getName(),collentionEntity);
            if(collentions != null&&collentions.size()>0){
                activesVO.setIsCollention("已关注");
            }
        }

        return activesVO;
    }

    /**
     * 活动价格查询条件设置
     * @param criteriaQuery
     * @param priceRange    数字所代表的价格区间
     */
    public void priceCondition(CriteriaQuery criteriaQuery,String priceRange){

        if (priceRange != null && !priceRange.isEmpty()){
            // 1万以下
            if ("1".equals(priceRange)){
                // 活动价格小于10000 <=
                criteriaQuery.lt("activePrice",10000);
                // 1 - 3万
            }else if ("2".equals(priceRange)){
                // 活动价格大于等于10000
                criteriaQuery.ge("activePrice", 10000);
                // 活动价格小于等于30000
                criteriaQuery.lt("activePrice",30000);
                // 3 - 5万
            }else if ("3".equals(priceRange)) {
                // 活动价格大于等于30000
                criteriaQuery.ge("activePrice", 30000);
                // 活动价格小于等于50000
                criteriaQuery.lt("activePrice", 50000);
                // 5万以上
            }else if ("4".equals(priceRange)){
                // 活动价格大于等于50000
                criteriaQuery.ge("activePrice", 50000);
                // 2万以下
            }else if ("5".equals(priceRange)){
                // 小于20000以下
                criteriaQuery.lt("activePrice",20000);
                // 2 - 5万
            }else if ("6".equals(priceRange)){
                // 活动价格大于等于20000
                criteriaQuery.ge("activePrice", 20000);
                // 活动价格小于等于50000
                criteriaQuery.lt("activePrice",50000);
                // 5 - 7万
            }else if ("7".equals(priceRange)){
                // 活动价格大于等于50000
                criteriaQuery.ge("activePrice", 50000);
                // 活动价格小于等于50000
                criteriaQuery.lt("activePrice", 70000);
                // 7万以上
            }else if ("8".equals(priceRange)){
                // 活动价格大于等于70000
                criteriaQuery.ge("activePrice", 70000);
            }else if ("9".equals(priceRange)){
                // 活动小于6000
                criteriaQuery. lt("activePrice",6000);
            }else if ("10".equals(priceRange)){
                // 6000 <= 活动价格 < 8000
                criteriaQuery.ge("activePrice",6000);
                criteriaQuery. lt("activePrice",8000);
            }else if ("11".equals(priceRange)){
                // 8000 <= 活动价格 < 12000
                criteriaQuery.ge("activePrice",8000);
                criteriaQuery.lt("activePrice",12000);
            }else if ("12".equals(priceRange)){
                // 12000 <= 活动价格 < 15000
                criteriaQuery.ge("activePrice",12000);
                criteriaQuery.lt("activePrice",15000);
            }else if ("13".equals(priceRange)){
                // 15000 <= 活动价格 < 20000
                criteriaQuery.ge("activePrice",15000);
                criteriaQuery.lt("activePrice",20000);
            }else if ("14".equals(priceRange)){
                // 20000 <= 活动价格
                criteriaQuery.ge("activePrice",20000);
            }
        }
    }



    /**
     * 活动进度查询条件设置
     * @param criteriaQuery
     * @param schedule      活动的进度
     */
    public void activeSchedule(CriteriaQuery criteriaQuery,String schedule){
        // 当前时间
        Date nowDate = new Date();
        if (schedule != null) {
            if ("报名中".equals(schedule)) {
                // 报名截止时间大于当前时间
                criteriaQuery.gt("deadlineDate", nowDate);
                // 活动发布时间小于当前时间
                criteriaQuery.lt("publishTime", nowDate);
            } else if ("报名结束".equals(schedule)){
                // 活动开始时间膈俞当前时间
                criteriaQuery.gt("activeStateTime",nowDate);
                // 活动报名截止时间小于当前时间
                criteriaQuery.lt("deadlineDate",nowDate);

            } else if ("进行中".equals(schedule)) {
                // 活动结束时间大于当前时间
                criteriaQuery.gt("activeEndTime", nowDate);
                // 开始时间小于当前时间
                criteriaQuery.lt("activeStateTime", nowDate);

            } else if ("已结束".equals(schedule)) {
                // 活动结束时间小于当前时间
                criteriaQuery.lt("activeEndTime", nowDate);
            }
        }
    }

    /**
     * 出国游学中的活动详情页
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
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class, searchForm.getId());
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }
            map.put("activessVO",activessVO);

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

                List<ActiveUsersEntity> list = this.sysServiceI.findByProperty(ActiveUsersEntity.class, "activeId", activessEntity.getId());
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




    // ==================================个人中心=======================================================


    /**
     * 当前用户已参加过的活动
     * @param activeForm 活动报名
     * @param request
     * @return
     */
    @RequestMapping(value = "joinActives")
    @ResponseBody
    public ReplyDataMode joinActives(ActiveForm activeForm, HttpServletRequest request){
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

        if (user != null && user.getId() != null) {

            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(activeForm.getPageNo()) && !StringUtil.isEmpty(activeForm.getPageSize())) {
                pageNo = Integer.parseInt(activeForm.getPageNo());
                pageSize = Integer.parseInt(activeForm.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) + "," + pageSize);
            }

            String sql = "SELECT\n" +
                    "\ta.active_title,\n" +
                    "\tac.active_catelog_name,\n" +
                    "\ta.publish_time,\n" +
                    "\ta.deadline_date,\n" +
                    "\ta.active_state_time,\n" +
                    "\ta.active_end_time,\n" +
                    "\ta.active_price,\n" +
                    "\ta.gift_account_count,\n" +
                    "\ta.remarks,\n" +
                    "\ta.id\n" +
                    "FROM\n" +
                    "\tdxs_actives a ,dxs_active_user au,dxs_active_catelog ac\n" +
                    "\n" +
                    "WHERE\n" +
                    "\ta.active_catelog_id = ac.id\n" +
                    "AND\n" +
                    "\tau.user_id = '"+ user.getId() +"'\n" +
                    "AND\n" +
                    "\ta.active_end_time < SYSDATE()\n" +
                    "AND\n" +
                    "\ta.id = au.active_id\n" +
                    "AND\n" +
                    "\ta.is_delete = 0\n" +
                    "AND\n" +
                    "\tau.is_delete = 0\n" +
                    "AND\n" +
                    "\tac.is_delete = 0" + sb_limit.toString();

            String sqlCount = "SELECT\n" +
                    "\tCOUNT(1)\n" +
                    "FROM\n" +
                    "\tdxs_actives a ,dxs_active_user au,dxs_active_catelog ac\n" +
                    "\n" +
                    "WHERE\n" +
                    "\ta.active_catelog_id = ac.id\n" +
                    "AND\n" +
                    "\tau.user_id = '"+ user.getId() +"'\n" +
                    "AND\n" +
                    "\ta.active_end_time < SYSDATE()\n" +
                    "AND\n" +
                    "\ta.id = au.active_id\n" +
                    "AND\n" +
                    "\ta.is_delete = 0\n" +
                    "AND\n" +
                    "\tau.is_delete = 0\n" +
                    "AND\n" +
                    "\tac.is_delete = 0";

            // 符合条件数据
            List uaList = this.sysServiceI.findListbySql(sql);

            // 符合条件数据的个数(分页总条数)
            List countList = this.sysServiceI.findListbySql(sqlCount);

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
                mode.setTotal(Integer.parseInt(countList.get(0).toString()));
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
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }
}