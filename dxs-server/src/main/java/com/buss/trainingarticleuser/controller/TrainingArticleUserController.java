package com.buss.trainingarticleuser.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.trainingarticleuser.entity.TrainingArticleUserEntity;
import com.buss.trainingarticleuser.trans.form.TrainingArticleUserSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/trainingArticleUser")
public class TrainingArticleUserController {


	@Resource
	private SysServiceI sysService;

	@RequestMapping("/applyTrainingArticle")
	@ResponseBody
	public AjaxJson applyTrainingArticle(TrainingArticleUserSearchForm trainingArticleUserSearchForm, HttpServletRequest request) {
		AjaxJson ajaxJson = new AjaxJson();
		String message = "操作成功!";

		try {
			//获取用户登录信息
			Subject currentUser = SecurityUtils.getSubject();
			AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            if (user == null) {
                message = "用户没有登录!";

				ajaxJson.setMsg(message);
				return ajaxJson;
            }

			TrainingArticleUserEntity trainingArticleUserEntity = new TrainingArticleUserEntity();
			trainingArticleUserEntity.setUserId(user.getId());
			trainingArticleUserEntity.setTrainingArticleId(trainingArticleUserSearchForm.getTrainingArticleId());
			List trainingArticleUsers = this.sysService.findByExample(TrainingArticleUserEntity.class.getName(), trainingArticleUserEntity);
			if (trainingArticleUsers != null && trainingArticleUsers.size()>0) {
				message = "您已经报过名了!";
			} else {

				Date date = new Date();
				trainingArticleUserEntity.setCreateTime(date);
				trainingArticleUserEntity.setUpdateTime(date);
				trainingArticleUserEntity.setApplyTime(date);
				trainingArticleUserEntity.setIsDelete(0);
				trainingArticleUserEntity.setResult(0);

				this.sysService.saveOrUpdate(trainingArticleUserEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "操作失败!";
		}
		ajaxJson.setMsg(message);

		return ajaxJson;
	}


}
