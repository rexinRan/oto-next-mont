package com.buss.common.controller;

import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.*;
import com.buss.dist.trans.form.DistAreaForm;
import com.buss.dist.trans.form.DistCityForm;
import com.buss.dist.trans.form.DistCollegeForm;
import com.buss.dist.trans.form.DistSchoolForm;
import com.buss.dist.trans.vo.*;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
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
 * 区域字典表
 * Created by Administrator on 2016/7/20.
 */
@Controller
@RequestMapping("/dictionary")
public class Regional {

    @Resource
    private SysServiceI sysService;

    /**
     * 查询所有省
     * @param request
     * @return
     */
    @RequestMapping(value = "provincesCities")
    @ResponseBody
    public ReplyDataMode activityArea(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.getList(DxsDistProvinceEntity.class);
        List<DistProvinceVo> distProvinceVos = new ArrayList<DistProvinceVo>();

        if (distProvinceEntityList != null && distProvinceEntityList.size() > 0){
            for (DxsDistProvinceEntity dpe:distProvinceEntityList){
                DistProvinceVo distProvinceVo = new DistProvinceVo();
                distProvinceVo.copyEntity(dpe);
                distProvinceVos.add(distProvinceVo);
            }
        }
        replyDataMode.setData(distProvinceVos);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }

    /**
     * 查询所有的省市
     * @return
     */
    @RequestMapping(value = "activityArea")
    @ResponseBody
    public ReplyDataMode activityArea(){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Map<String,List> region = new HashMap<String,List>();
        List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.getList(DxsDistProvinceEntity.class);
        List<DistProvinceVo> distProvinceVos = new ArrayList<DistProvinceVo>();
        List<DistCityVo> distCityVos = new ArrayList<DistCityVo>();

        if (distProvinceEntityList != null && distProvinceEntityList.size() > 0){
            for (DxsDistProvinceEntity dpe:distProvinceEntityList){
                DistProvinceVo distProvinceVo = new DistProvinceVo();
                distProvinceVo.copyEntity(dpe);
                distProvinceVos.add(distProvinceVo);

                if (dpe.getProvinceid() != null){
                    DistCityForm distCityForm = new DistCityForm();
                    distCityForm.setProvinceid(dpe.getProvinceid() + "");
                    CriteriaQuery criteriaQuery = distCityForm.getCriteriaQuery();
                    List<DxsDistCityEntity> distCityEntityList = this.sysService.list(criteriaQuery);

                    for (DxsDistCityEntity dce:distCityEntityList){
                        DistCityVo distCityVo = new DistCityVo();
                        distCityVo.copyEntity(dce);
                        distCityVos.add(distCityVo);
                    }
                }
            }
        }
        region.put("distProvinceVos",distProvinceVos);  // 省
        region.put("distCityVos",distCityVos);			  // 市
        replyDataMode.setData(region);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }

    /**
     * 省市两级联动
     * @param request
     * @return
     */
    @RequestMapping(value = "provincesCitiesLinkage")
    @ResponseBody
    public ReplyDataMode projetClassLinkage(HttpServletRequest request, String provinceid,String cityid){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (!StringUtil.isEmpty(provinceid) || !StringUtil.isEmpty(cityid)){
            // 根据省的id查市 http://localhost:8080/dxs-server/dictionary/provincesCitiesLinkage.do?provinceid=140000
            if (provinceid != null && !provinceid.isEmpty()){
                DistCityForm distCityForm = new DistCityForm();
                distCityForm.setProvinceid(provinceid);
                CriteriaQuery criteriaQuery = distCityForm.getCriteriaQuery();
                List<DxsDistCityEntity> distCityEntityList = this.sysService.list(criteriaQuery);
                List<DistCityVo> distCityVos = new ArrayList<>();
                for (DxsDistCityEntity dce:distCityEntityList){
                    DistCityVo distCityVo = new DistCityVo();
                    distCityVo.copyEntity(dce);
                    distCityVos.add(distCityVo);
                }


                replyDataMode.setData(distCityVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }

            // 根据市的id查询县    http://localhost:8080/dxs-server/dictionary/provincesCitiesLinkage.do?cityid=140600
            if (cityid != null && !cityid.isEmpty()){
                DistAreaForm distAreaForm = new DistAreaForm();
                distAreaForm.setCityid(cityid);
                CriteriaQuery criteriaQuery = distAreaForm.getCriteriaQuery();
                List<DxsDistAreaEntity> distAreaEntityList = this.sysService.list(criteriaQuery);
                List<DistAreaVo> distAreaVos = new ArrayList<DistAreaVo>();

                if (distAreaEntityList != null && distAreaEntityList.size() > 0){
                    for (DxsDistAreaEntity ddae:distAreaEntityList){
                        DistAreaVo distAreaVo = new DistAreaVo();
                        distAreaVo.copyEntity(ddae);
                        distAreaVos.add(distAreaVo);
                    }
                }

                replyDataMode.setData(distAreaVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {
            // 查询所有省份   http://localhost:8080/dxs-server/dictionary/provincesCitiesLinkage.do
            List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.getList(DxsDistProvinceEntity.class);
            List<DistProvinceVo> distProvinceVos = new ArrayList<DistProvinceVo>();

            if (distProvinceEntityList != null && distProvinceEntityList.size() > 0){
                for (DxsDistProvinceEntity dpe:distProvinceEntityList){
                    DistProvinceVo distProvinceVo = new DistProvinceVo();
                    distProvinceVo.copyEntity(dpe);
                    distProvinceVos.add(distProvinceVo);
                }
            }
            replyDataMode.setData(distProvinceVos);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }


    /**
     * 通过学校级联院系
     * @param coid   大学的ID
     * @param provinceid  省的ID
     * @param request
     * @return
     */
    @RequestMapping(value = "faculty")
    @ResponseBody
    public ReplyDataMode faculty(String coid,String provinceid, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (!StringUtil.isEmpty(coid) || !StringUtil.isEmpty(provinceid)){

            // 根据大学查询院系
            if (coid != null){
                DistSchoolForm distSchoolForm = new DistSchoolForm();
                distSchoolForm.setCollegeid(coid);
                CriteriaQuery criteriaQuery = distSchoolForm.getCriteriaQuery();

                List<DxsDistSchoolEntity> DistSchoolEntityList = this.sysService.list(criteriaQuery);
                List<DistSchoolVo> distSchoolVos = new ArrayList<DistSchoolVo>();

                if (DistSchoolEntityList != null && DistSchoolEntityList.size() > 0){

                    for (DxsDistSchoolEntity ddse:DistSchoolEntityList){
                        DistSchoolVo distSchoolVo = new DistSchoolVo();
                        distSchoolVo.copyEntity(ddse);
                        distSchoolVos.add(distSchoolVo);
                    }
                }
                replyDataMode.setData(distSchoolVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }

            // 根据省份查询大学
            if (provinceid != null){
                DistCollegeForm distCollegeForm = new DistCollegeForm();
                distCollegeForm.setProvinceid(provinceid);
                CriteriaQuery criteriaQuery = distCollegeForm.getCriteriaQuery();
                List<DxsDistCollegeEntity> distCollegeEntityList = this.sysService.list(criteriaQuery);
                List<DistCollegeVo> distCollegeVos = new ArrayList<DistCollegeVo>();

                if (distCollegeEntityList != null && distCollegeEntityList.size() > 0){
                    for (DxsDistCollegeEntity ddce:distCollegeEntityList){
                        DistCollegeVo distCollegeVo = new DistCollegeVo();
                        distCollegeVo.copyEntity(ddce);
                        distCollegeVos.add(distCollegeVo);
                    }
                }

                replyDataMode.setData(distCollegeVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {

            // 查询所有的省会  http://localhost:8080/dxs-server/dictionary/faculty.do
            List<DxsDistProvinceEntity> distProvinceEntityList = this.sysService.getList(DxsDistProvinceEntity.class);
            List<DistProvinceVo> distProvinceVos = new ArrayList<DistProvinceVo>();

            if (distProvinceEntityList != null && distProvinceEntityList.size() > 0){
                for (DxsDistProvinceEntity dpe:distProvinceEntityList){
                    DistProvinceVo distProvinceVo = new DistProvinceVo();
                    distProvinceVo.copyEntity(dpe);
                    distProvinceVos.add(distProvinceVo);
                }
            }

            replyDataMode.setData(distProvinceVos);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }
}
