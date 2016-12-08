package com.buss.directionalemploymentgroups.controller;
import com.buss.common.service.SysServiceI;
import com.buss.directionalemploymentgroups.entity.DirectionalEmploymentGroupsEntity;
import com.buss.directionalemploymentgroups.trans.form.DirectionalEmploymentGroupsSearchForm;
import com.buss.directionalemploymentgroups.trans.vo.DirectionalEmploymentGroupsVO;
import com.buss.employed.entity.EmployedEntity;
import com.buss.employed.trans.form.EmployedForm;
import com.buss.employed.trans.vo.EmployedVO;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.usercompancy.trans.vo.UserCompancyVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.criterion.*;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.parse.IHqlParse;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/directionalEmploymentGroups")
public class DirectionalEmploymentGroupsController {

    @Resource
    private SysServiceI sysService;



    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode pageList(String sortType,DirectionalEmploymentGroupsSearchForm searchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 分页模型设置
        PageMode mode = new PageMode();
        int pageNo = 0;
        int pageSize = 0;

            // 获取前台传入内容
            String compancyNature = searchForm.getCompancyNature();
            String education = searchForm.getEducation();
            String experience = searchForm.getExperience();
            String employedType = searchForm.getEmployedType();
            String employedSalary = searchForm.getEmployedSalary();

            StringBuffer sb_and = new StringBuffer();
            if (!StringUtil.isEmpty(compancyNature)) { /* 公司性质*/
                sb_and.append(" and u.compancy_nature = '"+compancyNature+"'");
            }
            if (!StringUtil.isEmpty(education)) { /* 学历要求 */
                sb_and.append(" and e.education = '"+education+"'");
            }
            if (!StringUtil.isEmpty(experience)) { /* 工作经验 */
                sb_and.append(" and e.experience = '"+experience+"'");
            }
            if (!StringUtil.isEmpty(employedType)) { /* 工作类型 */
                sb_and.append(" and e.employed_type = '"+employedType+"'");
            }
            if (!StringUtil.isEmpty(employedSalary)) { /* 月薪 */
                sb_and.append(" and e.employed_salary = '"+employedSalary+"'");
            }



            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
                pageNo = Integer.parseInt(searchForm.getPageNo());
                pageSize = Integer.parseInt(searchForm.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) * pageSize +","+ pageSize );
            }

            String sql = "SELECT d.id,d.user_id,d.directional_employment_name,u.compancy_name,u.display_img " +
                    "FROM dxs_directional_employment_groups d,dxs_employed e,dxs_user_compancy u WHERE d.user_id = u.user_id and d.id = e.deg_id and d.is_delete = 0 " +
                    sb_and.toString() + "group by d.id ";
            String sql_count = "SELECT d.id " +
                    "FROM dxs_directional_employment_groups d,dxs_employed e,dxs_user_compancy u WHERE d.user_id = u.user_id and d.id = e.deg_id and d.is_delete = 0 " +
                    sb_and.toString()+ "group by d.id ";

        if(sortType!=null&&!"".equals(sortType)){
            if("最新".equals(sortType)){
                sql+=" ORDER BY d.direction_publish_time desc";
            }
            if("人气".equals(sortType)){
                sql+= " ORDER BY d.post_num desc";
            }
        }
        sql+=sb_limit.toString();
        
            List<Map> groupList = this.sysService.findListbySql(sql);
            List<Map> groupList_count = this.sysService.findListbySql(sql_count);

            List<DirectionalEmploymentGroupsVO> groupVOs = new ArrayList<DirectionalEmploymentGroupsVO>();
            if(!groupList.isEmpty()) for (Object obj : groupList) {
                DirectionalEmploymentGroupsVO groupVo = new DirectionalEmploymentGroupsVO();

                Object[] u = (Object[]) obj;
                String field = "";
                for(int i=0;i<u.length;i++){
                    if(u[i]!=null){
                        field = u[i].toString();
                    }else {
                        field = "";
                    }

                    if(i==0){
                        groupVo.setId(field);
                    }else if(i==1){
                        groupVo.setUserId(field);
                    }else if(i==2){
                        groupVo.setDirectionalEmploymentName(field);
                    }else if(i==4){
                        groupVo.setDisplayImg(field);
                    }
                }
                //组内招聘列表
                EmployedForm employedForm= new EmployedForm();
                employedForm.setDegId(groupVo.getId());
                employedForm.setIsDelete("0");
                employedForm.setCompanyNature(searchForm.getCompancyNature());
                employedForm.setEducation(searchForm.getEducation());
                employedForm.setExperience(searchForm.getExperience());
                employedForm.setEmployedType(searchForm.getEmployedType());
                employedForm.setEmployedSalary(searchForm.getEmployedSalary());
                CriteriaQuery criteriaQuery = employedForm.getCriteriaQuery();
                List<EmployedEntity> employeds = this.sysService.list(criteriaQuery);
                if(employeds!=null&&employeds.size()!=0){
                    List list = new ArrayList();
                    for(EmployedEntity employed:employeds){
                        Map map = new HashMap();
                        map.put("name",employed.getEmployedName());
                        map.put("number",employed.getEmployedNum());
                        list.add(map);
                    }
                    groupVo.setEmployedList(list);
                }
                groupVOs.add(groupVo);

                mode.setTotal(groupList_count.size());
            }

            final int allCounts;
            if (mode.getTotal() != 0) {
                allCounts = mode.getTotal();
            } else {
                allCounts = 0;
            }
            int pageCount = 0;
            if (pageNo!=0 && pageSize!=0) {
                if(allCounts%pageSize!=0){

                    pageCount = allCounts/pageSize + 1;
                }else{
                    pageCount = allCounts/pageSize;
                }
            }
            mode.setPageCount(pageCount);
            mode.setPageNo(pageNo);
            mode.setPageSize(pageSize);
            mode.setResult(groupVOs);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);


        return replyDataMode;
    }


    @RequestMapping("/companyInfo.do")
    @ResponseBody
    public ReplyDataMode companyInfo(DirectionalEmploymentGroupsSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<DirectionalEmploymentGroupsEntity> employeds = this.sysService.list(criteriaQuery);
        if(employeds!=null&&employeds.size()!=0){
            DirectionalEmploymentGroupsEntity directionalEmploymentGroupsEntity = employeds.get(0);
            UserCompancyEntity userCompancyEntity = new UserCompancyEntity();
            userCompancyEntity.setIsDelete(0);
            userCompancyEntity.setUserId(directionalEmploymentGroupsEntity.getUserId());
            List<UserCompancyEntity> companyList = this.sysService.findByExample(UserCompancyEntity.class.getName(),userCompancyEntity);
            if(companyList!=null&&companyList.size()!=0){
                UserCompancyEntity userCompany = companyList.get(0);
                UserCompancyVO userCompancyVO = new UserCompancyVO();
                userCompancyVO.copyEntity(userCompany);
                replyDataMode.setData(userCompancyVO);
            }
        }


        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
    
    

}

