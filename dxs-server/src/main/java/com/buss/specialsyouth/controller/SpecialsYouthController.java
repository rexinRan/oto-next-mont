package com.buss.specialsyouth.controller;

import com.aliyun.openservices.oss.model.MultipartUploadListing;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.controller.MessyCode;
import com.buss.common.service.SysServiceI;
import com.buss.specials.entity.SpecialsEntity;
import com.buss.specials.trans.from.SpecialsFrom;
import com.buss.specials.trans.vo.SpecialsVo;
import com.buss.specialsarticles.entity.SpecialsArticlesEntity;
import com.buss.specialsarticles.trans.from.SpecialsArticlesFrom;
import com.buss.specialsarticles.trans.vo.SpecialsArticlesVo;
import com.buss.specialshiring.entity.SpecialsHiringEntity;
import com.buss.specialshiring.trans.from.SpecialsHiringFrom;
import com.buss.specialshiring.trans.vo.SpecialsHiringVo;
import com.buss.specialsobj.entity.SpecialsObjEntity;
import com.buss.specialsobj.trans.from.SpecialsObjFrom;
import com.buss.specialsyouth.entity.SpecialsYouthEntity;
import com.buss.specialsyouth.trans.from.SpecialsYouthFrom;
import com.buss.specialsyouth.trans.vo.SpecialsYouthVo;
import com.buss.specialsyouthimg.entity.SpecialsYouthImgEntity;
import com.buss.specialsyouthimg.trans.from.SpecialsYouthImgFrom;
import com.buss.specialsyouthimg.trans.vo.SpecialsYouthImgVo;
import com.buss.specialsyouthimgs.entity.SpecialsYouthImgsEntity;
import com.buss.specialsyouthimgs.trans.from.SpecialsYouthImgsFrom;
import com.buss.specialsyouthimgs.trans.vo.SpecialsYouthImgsVo;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.buss.userdetail.trans.vo.UserDetailVO;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sun.tools.javac.code.Attribute;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.omg.CORBA.ULongLongSeqHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/8/5.
 */
@Controller
@RequestMapping("/specialsYouthController")
public class SpecialsYouthController {


    @Resource
    private SysServiceI sysServiceI;
    @Resource
    private MessyCode messyCode;


    /**
     * 就业中心>专项就业
     * @param SpecialsYouthFrom     专项就业->无悔青春
     * @param request
     * @return
     */
    @RequestMapping(value = "employment")
    @ResponseBody
    public ReplyDataMode employment(SpecialsYouthFrom SpecialsYouthFrom, int curPage, int pageSize, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        Map<String,Object> map = new HashMap<String, Object>();
        SpecialsYouthFrom.setType(messyCode.messyCodeTreatment(SpecialsYouthFrom.getType()));

        // 无悔的青春
        SpecialsYouthFrom.setIsDelete("0");
        if (SpecialsYouthFrom.getType() != null && !SpecialsYouthFrom.getType().isEmpty()){
            CriteriaQuery criteriaQuery = SpecialsYouthFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");
            criteriaQuery.addOrder("updateTime","desc");

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialsYouthEntity> specialsYouthEntityList = mode.getResult();
            List<SpecialsYouthVo> specialsYouthVos = new ArrayList<SpecialsYouthVo>();
            if (specialsYouthEntityList != null && specialsYouthEntityList.size() > 0){
                for (SpecialsYouthEntity sye:specialsYouthEntityList){
                    SpecialsYouthVo specialsYouthVo = new SpecialsYouthVo();
                    specialsYouthVo.copyEntity(sye);
                    specialsYouthVos.add(specialsYouthVo);
                }
            }

            // 专项就业类型
            SpecialsFrom specialsFrom = new SpecialsFrom();
            specialsFrom.setType(SpecialsYouthFrom.getType());
            specialsFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery1 = specialsFrom.getCriteriaQuery();

            List<SpecialsEntity> specialsEntityList = this.sysServiceI.list(criteriaQuery1);
            List<SpecialsVo> specialsVos = new ArrayList<SpecialsVo>();
            if (specialsEntityList != null && specialsEntityList.size() > 0){
                for (SpecialsEntity se:specialsEntityList){
                    SpecialsVo specialsVo = new SpecialsVo();
                    specialsVo.copyEntity(se);
                    specialsVos.add(specialsVo);
                }

            }

            mode.setResult(specialsVos);
            map.put("specialsVos",mode);
            map.put("specialsYouthVos",specialsYouthVos);
            replyDataMode.setData(map);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 专线就业>边区支教     根据类型查询所有的专项就业>青春无悔
     * @param specialsYouthFrom
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("typeYouth")
    @ResponseBody
    public ReplyDataMode typeYouth(SpecialsYouthFrom specialsYouthFrom,int curPage, int pageSize,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        if (specialsYouthFrom.getType() != null && !specialsYouthFrom.getType().isEmpty()){
            specialsYouthFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = specialsYouthFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");
            criteriaQuery.addOrder("updateTime","desc");

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialsYouthEntity> specialsYouthEntityList = mode.getResult();
            List<SpecialsYouthVo> specialsYouthVos = new ArrayList<SpecialsYouthVo>();
            if (specialsYouthEntityList != null && specialsYouthEntityList.size() > 0){
                for (SpecialsYouthEntity sye:specialsYouthEntityList){
                    SpecialsYouthVo specialsYouthVo = new SpecialsYouthVo();
                    specialsYouthVo.copyEntity(sye);
                    specialsYouthVos.add(specialsYouthVo);
                }
                replyDataMode.setData(specialsYouthVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }

        return replyDataMode;
    }


    /**
     * 边区支教
     * @param specialsFrom   专项就业
     * @param hiringPlace    支援省份
     * @param hiringJob      志愿项目
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("teacherSupport")
    @ResponseBody
    public ReplyDataMode teacherSupport(SpecialsFrom specialsFrom,String hiringPlace,String hiringJob,int curPage, int pageSize,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        specialsFrom.setIsDelete("0");
        Map<String,Object> map = new HashMap<String, Object>();

        if (specialsFrom.getId() != null && !specialsFrom.getId().isEmpty()){
            /*if (!"4".equals(specialsFrom.getId())) {
                // 根据某专项就业类型的ID查询详细信息(三支一扶/边去支教/志愿西部)
                SpecialsEntity specialsEntity = this.sysServiceI.get(SpecialsEntity.class, specialsFrom.getId());
                if (specialsEntity != null) {
                    SpecialsVo specialsVo = new SpecialsVo();
                    specialsVo.copyEntity(specialsEntity);
                    map.put("specialsVo", specialsVo);
                }
            }*/

            SpecialsEntity specialsEntity = this.sysServiceI.get(SpecialsEntity.class, specialsFrom.getId());
            if (specialsEntity != null) {
                SpecialsVo specialsVo = new SpecialsVo();
                specialsVo.copyEntity(specialsEntity);
                map.put("specialsVo", specialsVo);
            }

            // 根据ID查询所有关联的选聘简章

            SpecialsHiringFrom specialsHiringFrom = new SpecialsHiringFrom();
            specialsHiringFrom.setSpecialsId(specialsFrom.getId());
            specialsHiringFrom.setIsDelete("0");
            if (hiringJob != null && !hiringJob.isEmpty()){
                specialsHiringFrom.setHiringJob(hiringJob);
            }
            CriteriaQuery criteriaQuery = specialsHiringFrom.getCriteriaQuery();
            // 条件查询
            if (hiringPlace != null && !hiringPlace.isEmpty()){
                criteriaQuery.like("hiringPlace","%" + hiringPlace +"%");
            }

            criteriaQuery.addOrder("createTime","desc");
            criteriaQuery.addOrder("updateTime","desc");
            criteriaQuery.add();

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialsHiringEntity> specialsHiringEntityList = mode.getResult();
            List<SpecialsHiringVo>specialsHiringVos = new ArrayList<SpecialsHiringVo>();

            if (specialsHiringEntityList != null && specialsHiringEntityList.size() > 0){
                for (SpecialsHiringEntity she:specialsHiringEntityList){
                    SpecialsHiringVo specialsHiringVo = new SpecialsHiringVo();
                    specialsHiringVo.copyEntity(she);
                    if(specialsHiringVo.getHiringPlace()!=null&&!"".equals(specialsHiringVo.getHiringPlace())){

                        String [] places = specialsHiringVo.getHiringPlace().split("#");
                        String place = places[0];
                        specialsHiringVo.setHiringPlace(place);
                    }
                    specialsHiringVos.add(specialsHiringVo);
                }
                mode.setResult(specialsHiringVos);
            }
            map.put("specialsHiringVos",mode);

        }

        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 大学生村官根据不同类型查询所对应的文章
     * @param specialsArticlesFrom  大学生村官文章
     * @param request
     * @return
     */
    @RequestMapping(value = "villageOfficial")
    @ResponseBody
    public ReplyDataMode villageOfficial(SpecialsArticlesFrom specialsArticlesFrom,int curPage,int pageSize,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        specialsArticlesFrom.setIsDelete("0");

        // 地址
        String addres = specialsArticlesFrom.getAddressArea();
        specialsArticlesFrom.setAddressArea(null);
        if (specialsArticlesFrom.getCateLog() != null && !specialsArticlesFrom.getCateLog().isEmpty()) {
            if (specialsArticlesFrom.getAddressArea() != null && specialsArticlesFrom.getAddressArea().isEmpty()){
                specialsArticlesFrom.setAddressArea(null);
            }

            CriteriaQuery criteriaQuery = specialsArticlesFrom.getCriteriaQuery();
            if (addres != null && !addres.isEmpty()){
                criteriaQuery.like("addressArea","%" + addres + "%");
                criteriaQuery.add();
            }
            criteriaQuery.addOrder("sort","desc");
            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialsArticlesEntity> specialsArticlesEntityList = mode.getResult();
            List<SpecialsArticlesVo> specialsArticlesVos = new ArrayList<SpecialsArticlesVo>();
            if (specialsArticlesEntityList != null && specialsArticlesEntityList.size() > 0){
                for (SpecialsArticlesEntity sae:specialsArticlesEntityList){
                    SpecialsArticlesVo specialsArticlesVo = new SpecialsArticlesVo();
                    specialsArticlesVo.copyEntity(sae);
                    specialsArticlesVos.add(specialsArticlesVo);
                }

            }
            mode.setResult(specialsArticlesVos);
            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 大学生村官文章的详情页
     * @param specialsArticlesFrom  文章
     * @param request
     * @return
     */
    @RequestMapping("articleDetails")
    @ResponseBody
    public ReplyDataMode articleDetails(SpecialsArticlesFrom specialsArticlesFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        if (specialsArticlesFrom.getId() != null && !specialsArticlesFrom.getId().isEmpty()){
            SpecialsArticlesEntity specialsArticlesEntity = this.sysServiceI.get(SpecialsArticlesEntity.class,specialsArticlesFrom.getId());
            SpecialsArticlesVo specialsArticlesVo = new SpecialsArticlesVo();
            if (specialsArticlesEntity != null){
                specialsArticlesVo.copyEntity(specialsArticlesEntity);
            }
            replyDataMode.setData(specialsArticlesVo);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 查询所有的图片集/如果有ID,根据ID查询所关联的图片表的图片
     * @param specialsYouthImgsFrom     图片集
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("atlas")
    @ResponseBody
    public ReplyDataMode atlas(SpecialsYouthImgsFrom specialsYouthImgsFrom,Integer curPage,Integer pageSize, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 根据ID查询图片信息
        if (specialsYouthImgsFrom.getId() != null && !specialsYouthImgsFrom.getId().isEmpty()){
            SpecialsYouthImgFrom specialsYouthImgFrom = new SpecialsYouthImgFrom();
            specialsYouthImgFrom.setDsyiId(specialsYouthImgsFrom.getId());
            specialsYouthImgFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = specialsYouthImgFrom.getCriteriaQuery();
            criteriaQuery.addOrder("sort","desc");
            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialsYouthImgEntity> specialsYouthImgEntityList = mode.getResult();
            List<SpecialsYouthImgVo> specialsYouthImgVos = new ArrayList<SpecialsYouthImgVo>();
            if (specialsYouthImgEntityList != null && specialsYouthImgEntityList.size() > 0){
                for (SpecialsYouthImgEntity syie:specialsYouthImgEntityList){
                    SpecialsYouthImgVo specialsYouthImgVo = new SpecialsYouthImgVo();
                    specialsYouthImgVo.copyEntity(syie);
                    specialsYouthImgVos.add(specialsYouthImgVo);
                }
            }
            replyDataMode.setData(specialsYouthImgVos);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }else {     // 查询所有的图片集
            // 带有分页
            if (curPage != null && pageSize != null){
                specialsYouthImgsFrom.setIsDelete("0");

                // 分类查询
                if (specialsYouthImgsFrom.getType() != null && !specialsYouthImgsFrom.getType().isEmpty()){
                    specialsYouthImgsFrom.setType(specialsYouthImgsFrom.getType());
                }

                CriteriaQuery criteriaQuery = specialsYouthImgsFrom.getCriteriaQuery();
                PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
                List<SpecialsYouthImgsEntity> specialsYouthImgsEntityList = mode.getResult();
                List<SpecialsYouthImgsVo> specialsYouthImgsVos = new ArrayList<SpecialsYouthImgsVo>();
                if (specialsYouthImgsEntityList != null && specialsYouthImgsEntityList.size() > 0){
                    for (SpecialsYouthImgsEntity syie:specialsYouthImgsEntityList){
                        SpecialsYouthImgsVo specialsYouthImgsVo = new SpecialsYouthImgsVo();
                        specialsYouthImgsVo.copyEntity(syie);
                        specialsYouthImgsVos.add(specialsYouthImgsVo);
                    }

                }
                mode.setResult(specialsYouthImgsVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {

                // 注 今后改为类型查询

                SpecialsYouthImgsFrom specialsYouthImgsFrom1 = new SpecialsYouthImgsFrom();
                specialsYouthImgsFrom.setIsDelete("0");

                // 分类查询
                if (specialsYouthImgsFrom.getType() != null && !specialsYouthImgsFrom.getType().isEmpty()){
                    specialsYouthImgsFrom.setType(specialsYouthImgsFrom.getType());
                }

                CriteriaQuery criteriaQuery = specialsYouthImgsFrom.getCriteriaQuery();
                criteriaQuery.addOrder("createTime","desc");
                List<SpecialsYouthImgsEntity> specialsYouthImgsEntityList = this.sysServiceI.list(criteriaQuery);

                List<SpecialsYouthImgsVo> specialsYouthImgsVos = new ArrayList<SpecialsYouthImgsVo>();
                if (specialsYouthImgsEntityList != null && specialsYouthImgsEntityList.size() > 0){
                    for (SpecialsYouthImgsEntity syie:specialsYouthImgsEntityList){
                        SpecialsYouthImgsVo specialsYouthImgsVo = new SpecialsYouthImgsVo();
                        specialsYouthImgsVo.copyEntity(syie);
                        specialsYouthImgsVos.add(specialsYouthImgsVo);
                    }
                }
                replyDataMode.setData(specialsYouthImgsVos);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return replyDataMode;
    }


    /**
     * 我要去这里(边区支教)
     * @param specialsObjFrom   转向就业->我要去这里
     * @param request
     * @return
     */
    @RequestMapping("signUp")
    @ResponseBody
    public ReplyDataMode signUp(SpecialsObjFrom specialsObjFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            SpecialsObjEntity specialsObjEntity = (SpecialsObjEntity) specialsObjFrom.toEntity();
            specialsObjEntity.setIsDelete(0);
            specialsObjEntity.setUserId(user.getId());
            Date date = new Date();
            specialsObjEntity.setCreateTime(date);
            try {
                this.sysServiceI.saveOrUpdate(specialsObjEntity);
                replyDataMode.setStatusCode("提交成功!");
                replyDataMode.setSuccess(true);
            }catch (Exception e){
                replyDataMode.setStatusCode("提交失败!");
                replyDataMode.setSuccess(false);
            }

        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 获取当前用户详细信息(边区支教>我要去这里)
     * @param request
     * @return
     */
    @RequestMapping("getUserInformation")
    @ResponseBody
    public ReplyDataMode getUserInformation(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            UserDetailForm userDetailForm = new UserDetailForm();
            userDetailForm.setIsDelete("0");
            userDetailForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();
            List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);
            if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                Map<String,Object> map = new HashMap<String,Object>();

                // 当前时间
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
                Integer presentTime = Integer.parseInt(simpleDateFormat.format(date));

                // 当前用户的出生年月日
                Integer idCard = Integer.parseInt(userDetailEntityList.get(0).getIdcard().substring(6,10));

                // 当前用户的年龄
                String age = presentTime - idCard + "";

                map.put("userDetailVO",userDetailEntityList.get(0));
                map.put("age",age);
                replyDataMode.setData(map);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("您需完善个人信息!");
                replyDataMode.setSuccess(false);
            }
        }
        return replyDataMode;
    }


    /**
     * 获取青春无悔的详细信息
     * @param specialsYouthFrom
     * @param request
     * @return
     */
    @RequestMapping("/youthMessage")
    @ResponseBody
    public ReplyDataMode youthMessage(SpecialsYouthFrom specialsYouthFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        if (specialsYouthFrom.getId() != null && !specialsYouthFrom.getId().isEmpty()){
            SpecialsYouthEntity specialsYouthEntity = this.sysServiceI.get(SpecialsYouthEntity.class,specialsYouthFrom.getId());
            if (specialsYouthEntity != null){
                SpecialsYouthVo specialsYouthVo = new SpecialsYouthVo();
                specialsYouthVo.copyEntity(specialsYouthEntity);
                replyDataMode.setData(specialsYouthVo);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return replyDataMode;
    }


    /**
     * 选聘简章的详情页
     * @param specialsHiringFrom     选聘简章
     * @param request
     * @return
     */
    @RequestMapping("hiringInfo")
    @ResponseBody
    public ReplyDataMode hiringInfo(SpecialsHiringFrom specialsHiringFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (specialsHiringFrom.getId() != null && !specialsHiringFrom.getId().isEmpty()){
            SpecialsHiringEntity specialsHiringEntity = this.sysServiceI.get(SpecialsHiringEntity.class,specialsHiringFrom.getId());
            if (specialsHiringEntity != null){
                SpecialsHiringVo specialsHiringVo = new SpecialsHiringVo();
                specialsHiringVo.copyEntity(specialsHiringEntity);
                replyDataMode.setData(specialsHiringVo);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return replyDataMode;
    }


    /**
     * 获取招聘简章所有的地址     >>>>>>>>>>>待定
     * @param request
     * @return
     */
    @RequestMapping("getAddress")
    @ResponseBody
    public ReplyDataMode getAddress(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        String sql = "SELECT DISTINCT\n" +
                "\t(sh.hiring_place)\n" +
                "FROM\n" +
                "\tdxs_specials_hiring sh\n" +
                "WHERE\n" +
                "\tsh.is_delete = 0\n" +
                "AND sh.hiring_place IS NOT NULL";
        List<SpecialsHiringEntity> specialsHiringEntityList = this.sysServiceI.findListbySql(sql);

        return replyDataMode;
    }



}
