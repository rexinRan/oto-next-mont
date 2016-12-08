package com.buss.activity.controller;

import com.buss.account.entity.DxsAccountEntity;
import com.buss.account.service.HongXinMoneyService;
import com.buss.account.trans.form.AccountForm;
import com.buss.account.trans.vo.AccountVO;
import com.buss.activecatelog.entity.ActiveCatelogEntity;
import com.buss.activecatelog.trans.vo.ActiveCatelogVO;
import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.activity.trans.form.ActiveForm;
import com.buss.activity.trans.vo.ActiveVO;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.file.entity.FileEntity;
import com.buss.file.trans.form.FileForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.Order;
import org.hibernate.type.OrderedMapType;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/6/16.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    /**
     * 初始化已报名活动
     */
    @Resource
    private SysServiceI sysServiceI;

    @Resource
    private FileService fileService;

    @Resource
    private  HongXinMoneyService hongXinMoneyService;

    public HongXinMoneyService getHongXinMoneyService() {
        return hongXinMoneyService;
    }

    public void setHongXinMoneyService(HongXinMoneyService hongXinMoneyService) {
        this.hongXinMoneyService = hongXinMoneyService;
    }


    /**
     * 活动报名表
     * @param activeForm
     * @param request
     * @return
     */
    @RequestMapping("/initActivity")
    @ResponseBody
    public ReplyDataMode initActivity(ActiveForm activeForm,HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            // 根据当前用活动已报名的活动
            activeForm.setIsDelete("0");
            activeForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = activeForm.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (!StringUtils.isEmpty(activeForm.getPageNo()) && !StringUtils.isEmpty(activeForm.getPageSize())){
                Integer pageNo = Integer.parseInt(activeForm.getPageNo());
                Integer pageSize = Integer.parseInt(activeForm.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<ActiveUserEntity> activeUserEntityList = mode.getResult();

                List<ActiveVO> activeVOs = new ArrayList<ActiveVO>();
                List<ActivessVO> activessVOs = new ArrayList<ActivessVO>();
                List<ActiveCatelogVO> activeCatelogVOs = new ArrayList<ActiveCatelogVO>();
                List<Map<String,List>> list = new ArrayList<Map<String,List>>();
                Map<String,List> map = new HashMap<String,List>();

                if (activeUserEntityList != null && activeUserEntityList.size() > 0){
                    for (ActiveUserEntity aue:activeUserEntityList){
                        ActiveVO activeVO = new ActiveVO();
                        activeVO.copyEntity(aue);
                        activeVOs.add(activeVO);

                        // 根据activeId查询所有对应的活动
                        ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class,aue.getActiveId());

                        if (activessEntity != null){
                            ActivessVO activessVO = new ActivessVO();
                            activessVO.copyEntity(activessEntity);
                            activessVOs.add(activessVO);

                            // 根据activeCatelogId查询所对应的分类
                            ActiveCatelogEntity activeCatelogEntity = this.sysServiceI.get(ActiveCatelogEntity.class,activessEntity.getActiveCatelogId());

                            if (activeCatelogEntity != null){
                                ActiveCatelogVO activeCatelogVO = new ActiveCatelogVO();
                                activeCatelogVO.copyEntity(activeCatelogEntity);
                                activeCatelogVOs.add(activeCatelogVO);
                            }
                        }
                    }
                }else {
                    mode.setResult(list);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                    return replyDataMode;
                }

                map.put("activeVOs",activeVOs);
                map.put("activessVOs",activessVOs);
                map.put("activeCatelogVOs",activeCatelogVOs);
                list.add(map);

                mode.setResult(list);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {

                replyDataMode.setStatusCode("请设置分页!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }

    /**
     * 报名活动
     * 王腾云
     *
     */

    @RequestMapping("/joinactive")
    @ResponseBody
    public AjaxJson JoinActives(ActiveUserEntity au) {

        // 获取用户相关信息
        Subject subject = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) subject.getSession().getAttribute("userInfo");
        au.setUserId(user.getId());

        Date date = new Date();
        au.setIsDelete(0);
        au.setCreateTime(date);
        au.setUpdateTime(date);
        AjaxJson ajaxJson = new AjaxJson();
        String message = "活动报名成功!";
        try {

            this.sysServiceI.saveOrUpdate(au);

        } catch (Exception e) {
            message = "活动报名失败!";
        }
        ajaxJson.setMsg(message);

        return ajaxJson;

    }

    /**
     * 已报名活动中的上传缴费证明
     * @param activityId  点击记录所对应的活动报名表的ID
     * @pram account    鸿鑫币
     * @return
     */

    @RequestMapping("/UploadPictures")
    @ResponseBody                       // 注:需要核实看是否活动表的ID
    public ReplyDataMode UploadPictures(String activityId,ActiveForm activeform,String fid,String account) throws Exception {
        //@RequestParam(value = "uploadFile", required = false)
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        // 更新账户流水表
        /*if (!account.isEmpty()){
            // 根据当前用户获取对应的账户表(鸿鑫币)
            List<DxsAccountEntity> dxsAccountEntityList = this.sysServiceI.findByProperty(DxsAccountEntity.class,"userId",user.getId());
            // 当前用户所有的鸿鑫币
            Integer account1 = Integer.valueOf(dxsAccountEntityList.get(0).getAccount());           // 用户所有鸿鑫币
            Integer account2 = Integer.valueOf(account);        // 用户所用的鸿鑫币
            Integer account3 = account1-account2;
            // 设置当前用户用了的鸿鑫币
            dxsAccountEntityList.get(0).setAccount(account3.toString());
            // 保存当前用户的账户
            this.sysServiceI.saveOrUpdate(dxsAccountEntityList.get(0));

            // 更新当前用户账户流水
            HongXinMoneyService hongxinmoneyservice =  new HongXinMoneyService();
            hongxinmoneyservice.seetMoney(dxsAccountEntityList.get(0).getId(),user.getId(),null,account,0,1);
        }*/
        // 将指定的活动报名表的ID设置到file中
        try {
            if (activityId != "" && fid != ""){
                FileEntity fileEntity = this.sysServiceI.get(FileEntity.class,fid);
                fileEntity.setOutId(activityId);
                this.sysServiceI.saveOrUpdate(fileEntity);
                hongXinMoneyService.goMoney(user.getId(),account);
            }

            // 判断原价和实际缴费金额是否为空,保存原价和实际缴费金额
            if (!activeform.getOrigin().isEmpty() && !activeform.getPrice().isEmpty()){
                // 获取报名活动
                ActiveUserEntity activeuser = this.sysServiceI.get(ActiveUserEntity.class,activityId);
                activeuser.setOrigin(activeform.getOrigin());
                activeuser.setPrice(activeform.getPrice());
                this.sysServiceI.saveOrUpdate(activeuser);
            }
            replyDataMode.setData("成功!");
            replyDataMode.setSuccess(true);
        }catch (Exception e){
            replyDataMode.setData("失败!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


}
