package com.buss.complanysponsor.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.complanysponsor.entity.DxsComplanySponsorEntity;
import com.buss.complanysponsor.entity.DxsCsponsorActiveEntity;
import com.buss.complanysponsor.trans.form.DxsComplanySponsorSearchForm;
import com.buss.complanysponsor.trans.form.DxsCsponsorActiveSearchForm;
import com.buss.complanysponsor.trans.vo.DxsComplanySponsorVO;
import com.buss.complanysponsor.trans.vo.DxsCsponsorActiveVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Title: 赞助商申请
 * @Description: dxs_complany_sponsor
 * @author dq
 * @date 2016-07-13 08:54:35
 * @version V1.0
 *
 */

@Controller
@RequestMapping("/dxsComplanySponsorController")
public class DxsComplanySponsorController {

	@Autowired
	private SysServiceI sysService;

	@RequestMapping("/applay")
	@ResponseBody
	public AjaxJson sponsorActive(DxsComplanySponsorSearchForm dxsComplanySponsorSearchForm ) {
		AjaxJson json = new AjaxJson();  //反馈给前端页面提示信息
		String message = "";		//反馈信息内容
		try {
			Date date = new Date();
			// 获取登录人的ID
			// 获取当前登录用户
				Subject currentUser = SecurityUtils.getSubject();
				AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
				//根据登录用户的ID查询唯一对应的这个用户实体信息
				DxsComplanySponsorEntity dxsComplanySponsorEntity = this.sysService.findUniqueByProperty(DxsComplanySponsorEntity.class, "userId", user.getId());
				// 查询是否有过赞助申请，既查看赞助商列表中是否有过赞助记录，有既为赞助过，反之亦然。
				if (dxsComplanySponsorEntity != null && dxsComplanySponsorEntity.getIsDelete() == 0) {
						//更新当前赞助商提交的新信息，
						MyBeanUtils.copyBean2Bean(dxsComplanySponsorEntity, dxsComplanySponsorSearchForm);
						dxsComplanySponsorEntity.setUserId(user.getId());
						dxsComplanySponsorEntity.setUpdateTime(date);
						dxsComplanySponsorEntity.setIsDelete(0);
						this.sysService.saveOrUpdate(dxsComplanySponsorEntity);
						//在关联表中添加一条再次申请赞助活动记录。
						DxsCsponsorActiveEntity dxsCsponsorActiveEntity = new DxsCsponsorActiveEntity();

						dxsCsponsorActiveEntity.setUserId(dxsComplanySponsorEntity.getUserId());
						dxsCsponsorActiveEntity.setActiveId(dxsComplanySponsorSearchForm.getComplanyActive());
						dxsCsponsorActiveEntity.setCsponsorId(dxsComplanySponsorSearchForm.getId());
						dxsCsponsorActiveEntity.setUpdateTime(date);
						dxsCsponsorActiveEntity.setIsDelete(0);
						this.sysService.saveOrUpdate(dxsCsponsorActiveEntity);

						message = "提交成功！";

				} else {
					//保存当前赞助商提交的新信息，
					dxsComplanySponsorEntity= new DxsComplanySponsorEntity();
					MyBeanUtils.copyBean2Bean(dxsComplanySponsorEntity, dxsComplanySponsorSearchForm);
					dxsComplanySponsorEntity.setCreateTime(date);
					dxsComplanySponsorEntity.setIsDelete(0);
					dxsComplanySponsorEntity.setUserId(user.getId());
					this.sysService.saveOrUpdate(dxsComplanySponsorEntity);

					DxsComplanySponsorEntity dcse = (DxsComplanySponsorEntity) this.sysService.findByExample(DxsComplanySponsorEntity.class.getName() ,dxsComplanySponsorEntity).get(0);

					//在关联表中创建一条再次申请赞助活动记录。
					DxsCsponsorActiveEntity dxsCsponsorActiveEntity = new DxsCsponsorActiveEntity();
					dxsCsponsorActiveEntity.setUserId(dxsComplanySponsorEntity.getUserId());
					dxsCsponsorActiveEntity.setActiveId(dxsComplanySponsorSearchForm.getComplanyActive());
					dxsCsponsorActiveEntity.setCsponsorId(dcse.getId());
					dxsCsponsorActiveEntity.setIsDelete(0);
					dxsCsponsorActiveEntity.setCreateTime(date);
					this.sysService.saveOrUpdate(dxsCsponsorActiveEntity);
					message = "提交成功";
				}
		} catch (Exception e) {
			e.printStackTrace();
			message = "提交失败！";
		}

		json.setMsg(message);
		return json;
	}

	@RequestMapping("/activeFindSponsor")
	@ResponseBody
	public ReplyDataMode activeFindSponsor(DxsCsponsorActiveSearchForm dxsCsponsorActiveSearchForm ) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
			CriteriaQuery criteriaQuery = dxsCsponsorActiveSearchForm.getCriteriaQuery();
			List<DxsCsponsorActiveEntity> distCityEntityList = this.sysService.list(criteriaQuery);
			List<DxsCsponsorActiveVO> dxsDistIndustryVOs = new ArrayList<>();

			for (DxsCsponsorActiveEntity dce : distCityEntityList) {
				DxsComplanySponsorEntity dxsComplanySponsorEntity = this.sysService.findUniqueByProperty(DxsComplanySponsorEntity.class, "activeid", dce.getActiveId());
				if (dxsComplanySponsorEntity != null && dxsComplanySponsorEntity.getIsDelete() == 0) {
					DxsCsponsorActiveVO dxsCsponsorActiveVO = new DxsCsponsorActiveVO();
					dxsCsponsorActiveVO.copyEntity(dxsComplanySponsorEntity);
					dxsDistIndustryVOs.add(dxsCsponsorActiveVO);
				}
			}
			replyDataMode.setData(dxsDistIndustryVOs);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
			return replyDataMode;
	}


}
