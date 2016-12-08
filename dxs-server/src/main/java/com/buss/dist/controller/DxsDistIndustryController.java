package com.buss.dist.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistIndustryEntity;
import com.buss.dist.trans.form.DxsDistIndustrySearchForm;
import com.buss.dist.trans.vo.DxsDistIndustryVo;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
@Controller
@RequestMapping("industryController")
public class DxsDistIndustryController {
    @Resource
    private SysServiceI sysService;


    @RequestMapping("industry")
    @ResponseBody
    public  ReplyDataMode  industryLinkage(DxsDistIndustrySearchForm SearchForm, @RequestParam(required = false, value = "callback") String callback, HttpServletResponse response){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        if (SearchForm.getParentNo()!= null){
            CriteriaQuery criteriaQuery = SearchForm.getCriteriaQuery();
            List<DxsDistIndustryEntity> distCityEntityList = this.sysService.list(criteriaQuery);
            List<DxsDistIndustryVo> dxsDistIndustryVOs = new ArrayList<>();
            for (DxsDistIndustryEntity dce:distCityEntityList){
                DxsDistIndustryVo dxsDistIndustryVO = new DxsDistIndustryVo();
                dxsDistIndustryVO.copyEntity(dce);
                dxsDistIndustryVOs.add(dxsDistIndustryVO);
            }
            replyDataMode.setData(dxsDistIndustryVOs);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
//        return replyDataMode;
        if (callback == null || "".equals(callback)) {
            return replyDataMode; // 非 JSONP 请求，返回正常的 JOSN 数据
        } else {
            try { String res = JSON.toJSONString(replyDataMode);
                response.getWriter().write(callback + "(" + res + ")");
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null; // JSONP 请求，返回 JOSNP 数据
        }
    }


    /**
     * 查询所有的行业(两级联动)
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping(value = "ownedIndustry")
    @ResponseBody
    public ReplyDataMode ownedIndustry(DxsDistIndustrySearchForm searchForm,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        List<DxsDistIndustryVo> distIndustryVos = new ArrayList<DxsDistIndustryVo>();

        if (!StringUtils.isEmpty(searchForm.getIndustryNo())){

            List<DxsDistIndustryEntity> distIndustryEntityList = this.sysService.findByProperty(DxsDistIndustryEntity.class,"parentNo",Integer.parseInt(searchForm.getIndustryNo()));

            if (distIndustryEntityList != null && distIndustryEntityList.size() > 0){
                for (DxsDistIndustryEntity ddie:distIndustryEntityList){
                    DxsDistIndustryVo dxsDistIndustryVo = new DxsDistIndustryVo();
                    dxsDistIndustryVo.copyEntity(ddie);

                    distIndustryVos.add(dxsDistIndustryVo);
                }

                replyDataMode.setData(distIndustryVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {
            // 行业(父)
            int count = 13;

            for (int i = 1;i <= count;i++){
                DxsDistIndustryEntity DistIndustry = this.sysService.get(DxsDistIndustryEntity.class,i);

                if (DistIndustry != null){
                    DxsDistIndustryVo dxsDistIndustryVo = new DxsDistIndustryVo();
                    dxsDistIndustryVo.copyEntity(DistIndustry);
                    distIndustryVos.add(dxsDistIndustryVo);
                }
            }

            replyDataMode.setData(distIndustryVos);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }
}
