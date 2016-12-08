package com.buss.authentication.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.trans.form.AuthenticationSearchForm;
import com.buss.authentication.trans.vo.AuthenticationVo;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_authentication
 * @author onlineGenerator
 * @date 2016-07-19 13:24:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsAuthenticationController")
public class DxsAuthenticationController {
		
	@Autowired
	private SysServiceI sysService;

	/**
	 * 申请/认证
	 * @param authenticationSearchForm
	 * @return
     */
	@RequestMapping("/authentication.do")
	@ResponseBody
	public AjaxJson StudentAuthenticationController(AuthenticationSearchForm authenticationSearchForm){
		AjaxJson json = new AjaxJson();
		try {
			Date date = new Date();
			// 获取登录人的ID
			// 获取当前登录用户
			Subject currentUser = SecurityUtils.getSubject();
			AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

			if (user != null){

				json = this.judgeTutorApplication();
				if (json.isSuccess()){
					return json;
				}
				if (authenticationSearchForm != null){
					if (!StringUtil.isEmpty(authenticationSearchForm.getAuthenticationResult())){

						// 用户类型
						String userType_sql = "";
						switch (Integer.parseInt(authenticationSearchForm.getAuthenticationResult())){
							case 4:userType_sql = " AND a.authentication_result in(4,5,6) ";		// 教师
								break;
							case 7:userType_sql = " AND a.authentication_result in(7,8,9) ";		// 创业导师
								break;
							case 10:userType_sql = " AND a.authentication_result in(10,11,12) ";	// 就业导师
								break;
							case 13:userType_sql = " AND a.authentication_result in(13,14,15) ";	// 创客导师
								break;
							case 16:userType_sql = " AND a.authentication_result in(16,17,18) ";	// 学习导师
								break;
							case 19:userType_sql = " AND a.authentication_result in(19,20,21) ";	// 技能培训导师
								break;
						}

						String data_sql = "SELECT a.id,a.authentication_count,a.create_time FROM dxs_authentication a WHERE a.user_id = '"+ user.getId() + "'" + userType_sql + " AND a.is_delete = 0";

						List authenticationList = this.sysService.findListbySql(data_sql);

						//未认证过
						if (authenticationList.size() == 0) {

							DxsAuthenticationEntity authenticationEntity =(DxsAuthenticationEntity) authenticationSearchForm.toEntity();
							authenticationEntity.setIsDelete(0);
							authenticationEntity.setUserId(user.getId());
							authenticationEntity.setCreateTime(new Date());
							// 认证次数
							authenticationEntity.setAuthenticationCount(1);

							this.sysService.saveOrUpdate(authenticationEntity);

							json.setMsg("提交成功!");
							json.setSuccess(true);
						}else {
							//认证过了
							// obj[0]:id   1:认证次数		2:创建时间
							Object[] obj = (Object[]) authenticationList.get(0);
							if (obj[1] != null){
								Integer authenticationCount = ((byte)obj[1])*1;
								if (authenticationCount <= 3){
									authenticationSearchForm.setIsDelete("0");
									authenticationSearchForm.setCreateTime(obj[2].toString());
									DxsAuthenticationEntity authenticationEntity = (DxsAuthenticationEntity) authenticationSearchForm.toEntity();
									authenticationEntity.setUpdateTime(new Date());
									String id = obj[0].toString();
									authenticationEntity.setId(id);
									authenticationEntity.setUserId(user.getId());
									authenticationEntity.setAuthenticationCount(authenticationCount + 1);
									this.sysService.saveOrUpdate(authenticationEntity);

									json.setMsg("提交成功!");
									json.setSuccess(true);
								}else {
									json.setMsg("已达到认证次数!");
									json.setSuccess(false);
								}
							}else {
								json.setMsg("没有传递认证次数参数!");
								json.setSuccess(false);
							}
						}
					}else {
						json.setMsg("提交失败!");
						json.setSuccess(false);
					}
				}else {
					json.setMsg("请完善信息!");
					json.setSuccess(false);
				}
			}else{
				json.setMsg("请登录!");
				json.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setMsg("提交失败");
			json.setSuccess(false);
		}
		return json;
	}


	/**
	 * 判断教师是否认证成功
	 * @return
     */
	@RequestMapping(value = "judgeTeacherauthentication")
	@ResponseBody
	public ReplyDataMode judgeTeacherauthentication(){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			String dataSql = "SELECT\n" +
					"da.id\n" +
					"FROM\n" +
					"dxs_authentication da\n" +
					"WHERE\n" +
					"da.user_id='"+ user.getId() +"'\n" +
					"AND\n" +
					"da.authentication_result in(5)\n" +
					"AND\n" +
					"da.is_delete=0";

			List<Map> list = this.sysService.findListbySql(dataSql);

			if (list != null && list.size() > 0){
//				replyDataMode.setData();
				replyDataMode.setStatusCode("您的教师已经认证成功!");
				replyDataMode.setSuccess(true);
			}else {
				replyDataMode.setStatusCode("请您先去认证教师!");
				replyDataMode.setSuccess(false);
			}
		}else {
			replyDataMode.setStatusCode("请您登录!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}


	/**
	 * 判断导师时候申请成功
	 * @return
     */
	public AjaxJson judgeTutorApplication(){
		AjaxJson ajaxJson = new AjaxJson();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			String dataSql = "SELECT\n" +
					"da.id\n" +
					"FROM\n" +
					"dxs_authentication da\n" +
					"WHERE\n" +
					"da.user_id='"+ user.getId() +"'\n" +
					"AND\n" +
					"da.authentication_result in(7,8,10,11,13,14,16,17,19,20)\n" +
					"AND\n" +
					"da.is_delete=0";

			List<Map> list = this.sysService.findListbySql(dataSql);

			if (list != null && list.size() > 0){
				ajaxJson.setMsg("您的导师身份已经认证成功或待认证!");
				ajaxJson.setSuccess(true);
			}else {

				ajaxJson.setMsg("您的导师认证身份待审核或审核失败!");
				ajaxJson.setSuccess(false);
			}
		}else {

			ajaxJson.setMsg("请您登录!");
			ajaxJson.setSuccess(false);
		}

		return ajaxJson;
	}



	/**
	 * 认证后返回数据
	 * @param authenticationSearchForm
	 * @param request
     * @return
     */
	@RequestMapping(value = "authenticationEcho")
	@ResponseBody
	public ReplyDataMode authenticationEcho(AuthenticationSearchForm authenticationSearchForm,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			List<DxsAuthenticationEntity> authenticationEntityList = this.sysService.findByProperty(DxsAuthenticationEntity.class,"userId",user.getId());

			if (authenticationEntityList != null && authenticationEntityList.size() > 0){
				AuthenticationVo authenticationVo = new AuthenticationVo();
				authenticationVo.copyEntity(authenticationEntityList.get(0));

				replyDataMode.setData(authenticationVo);
				replyDataMode.setStatusCode("200");
				replyDataMode.setSuccess(true);
			}
		}else {

			replyDataMode.setStatusCode("请您登录!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}
}

