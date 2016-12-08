package com.buss.member.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.buss.account.service.HongXinMoneyService;
import com.buss.auth.controller.AuthenController;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.entity.HxFile;
import com.buss.common.entity.HxFileUser;
import com.buss.common.service.SMSServiceI;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.common.service.impl.UserFileService;
import com.buss.common.trans.form.FileSearchForm;
import com.buss.common.trans.vo.FileVo;
import com.buss.common.util.IDUtils;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.form.member.MemberRegistForm;
import com.buss.member.util.MemberUtil;
import com.buss.member.util.StatusCode;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.MyBeanUtils;
import org.jweb.core.util.PasswordUtil;
import org.jweb.core.util.ReplyCodeResourceUtil;
import org.jweb.core.util.StringUtil;
import org.jweb.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private SysServiceI sysService;
	@Autowired
	private SMSServiceI smsService;
	@Autowired
	private EhCacheManager ehcacheCacheManager;
	@Autowired
	private HongXinMoneyService hongXinMoneyService;


	/**
	 * 用户注册
	 * 
	 * @param saveForm
	 * @return
	 */
	@RequestMapping(value = "/regist")
	@ResponseBody
	public ReplyDataMode regist(MemberRegistForm saveForm, HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		boolean falg = false;

		// 校验短信验证码
//		if (!MemberUtil.validSMSCode(saveForm.getMphone(), saveForm.getValidCode(), ehcacheCacheManager)) {
//			j.setSuccess(falg);
//			j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_validCode_error"));
//			return j;
//		}
		/* 校验开始 */
		GeneralUserEntity tempUser = null;
		List<GeneralUserEntity> tempUserList = new ArrayList<>();

		if("student".equals(saveForm.getRolecode())||"teacher".equals(saveForm.getRolecode())) {
			// 验证手机号是否被注册过
//			tempUser = this.sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", saveForm.getMphone());
			tempUserList = this.sysService.findByProperty(GeneralUserEntity.class, "mphone", saveForm.getMphone());
			if (tempUserList.size()>0) {
//				j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_mphone_registed"));
				j.setStatusCode("手机号已被注册");
				j.setSuccess(falg);
				return j;
			}
		}

		// 验证企业名称，企业组织代码证号 是否被注册过
		if("emp".equals(saveForm.getRolecode())||"club".equals(saveForm.getRolecode())){
			// 验证邮箱是否被注册过
//			tempUser = this.sysService.findUniqueByProperty(GeneralUserEntity.class, "email", saveForm.getEmail());
//			if (tempUser != null) {
			tempUserList = this.sysService.findByProperty(GeneralUserEntity.class, "email", saveForm.getEmail());
			if (tempUserList.size()>0) {
//				j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_email_registed"));
				j.setStatusCode("邮箱已被注册");
				j.setSuccess(falg);
				return j;
			}
			// 判断是企业则进来
			if(!StringUtil.isEmpty(saveForm.getEmpname()) && !StringUtil.isEmpty(saveForm.getEmpcode())){
				tempUserList = this.sysService.findByProperty(GeneralUserEntity.class, "empname", saveForm.getEmpname());
				if (tempUserList.size()>0) {
//				tempUser = this.sysService.findUniqueByProperty(GeneralUserEntity.class, "empname", saveForm.getEmpname());
//				if (tempUser != null) {
					j.setStatusCode("企业已被注册，请重试");
					j.setSuccess(falg);
					return j;
				}
				tempUserList = this.sysService.findByProperty(GeneralUserEntity.class, "empcode", saveForm.getEmpcode());
				if (tempUserList.size()>0) {
//				tempUser = this.sysService.findUniqueByProperty(GeneralUserEntity.class, "empcode", saveForm.getEmpcode());
//				if (tempUser != null) {
					j.setStatusCode("企业组织代码证号已被注册，请重试");
					j.setSuccess(falg);
					return j;
				}
			}else{
				j.setStatusCode("企业名称，企业组织代码证号不能为空");
				j.setSuccess(falg);
				return j;
			}
		}
		/* 校验结束 */

		GeneralUserEntity userEntity = (GeneralUserEntity) saveForm.toEntity();
		// 解决用户名乱码
		// System.out.println(userEntity.getRealname());
		// 密码加密
		String pwdStr = PasswordUtil.encrypt(userEntity.getPwd(), PasswordUtil.str, PasswordUtil.getStaticSalt());
		userEntity.setPwd(pwdStr);
		userEntity.setCheckstatus(StatusCode.SC_REGIST);
		userEntity.setIsdelete(0);
		userEntity.setCreatetime(new Date());
		// 保存用户，并返回id
//		Object userid = this.sysService.save(userEntity);
//		System.out.println("userid : "+userid.toString());

		this.sysService.saveOrUpdate(userEntity);
		AuthUserVO userVO = new AuthUserVO();
		// 扩展详情表信息  首先判断企业？老师学生？ --> 取到用户id
		AuthenController au = new AuthenController();
		ReplyDataMode jj = null;
		if("emp".equals(saveForm.getRolecode())||"club".equals(saveForm.getRolecode())){
			jj = au.getUserInfoNo(userEntity.getEmail(), this.sysService);
			if ("200".equals(jj.getStatusCode())) {
				userVO = (AuthUserVO) jj.getData();
				userEntity.setId(userVO.getId());
				// 新增 企业详情表
				UserCompancyEntity uc = new UserCompancyEntity();
				uc.setUserEntity(userEntity);
				uc.setCompancyName(userEntity.getEmpname());
				uc.setCreateTime(new Date());
				uc.setIsDelete(0);
				this.sysService.saveOrUpdate(uc);
			}
		} else
		if("student".equals(saveForm.getRolecode())||"teacher".equals(saveForm.getRolecode())) {
			jj = au.getUserInfoNo(userEntity.getMphone(), this.sysService);
			if ("200".equals(jj.getStatusCode())) {
				userVO = (AuthUserVO) jj.getData();
				userEntity.setId(userVO.getId());
				// 新增 老师学生详情表
				UserDetailEntity ud = new UserDetailEntity();
//				ud.setUserEntity(userEntity);
				ud.setUserId(userEntity.getId());
				ud.setName(userEntity.getRealname());
				ud.setPhone(userEntity.getMphone());
				ud.setIdcard(userEntity.getIdcardnumber());
				ud.setCreateTime(new Date());
				ud.setIsDelete(0);
				this.sysService.saveOrUpdate(ud);

				// 新增 学生简历表
				ResumeEntity re = new ResumeEntity();
				re.setUserid(userEntity.getId());
				re.setName(userEntity.getRealname());
				re.setCreateTime(new Date());
				re.setIsDelete(0);
				this.sysService.saveOrUpdate(re);
			}
		}

		//
		try {
			if(userVO != null){
				this.hongXinMoneyService.comeMoney(userVO.getId(), 0+"");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		j.setSuccess(!falg);
		return j;
	}

	/**
	 * 验证手机号是否被注册过
	 * 
	 * @param mphone
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/sendSMSValidCode")
	@ResponseBody
	public ReplyDataMode sendSMSValidCode(String mphone, HttpServletRequest req) {
		GeneralUserEntity tempUser = this.sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", mphone);
		if (tempUser != null) {
			ReplyDataMode j = new ReplyDataMode();
			j.setSuccess(false);
//			j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_mphone_registed"));
			j.setStatusCode("手机号已被注册");
			j.setSuccess(false);
			return j;
		}
		ReplyDataMode mode = MemberUtil.sendSMSValidCode(mphone, req.getLocale(), smsService, ehcacheCacheManager);
		return mode;
	}


	@Autowired
	private FileService fileUploadService;

	@Autowired
	private UserFileService userFileService;

	/**
	 * 用户文件上传 荆志宝
	 * 
	 * @param uploadFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/file/upload")
	@ResponseBody
	public String upload(@RequestParam MultipartFile uploadFile, HttpSession session) throws IOException {

		/*
		 * 临时，模拟用户登录后的操作，后期删除
		 */
		GeneralUserEntity userEntity = sysService.get(GeneralUserEntity.class, "4028800a50dcdcf30150dce147b00001");
		session.setAttribute("userInfo", userEntity);

		/*
		 * 获取Session用户信息，判断用户是否登录,没有登录跳转到登录页面
		 */
		GeneralUserEntity user = (GeneralUserEntity) session.getAttribute("userInfo");
		if (user == null) {
			System.out.println("用户没有登录，请登录！");
			// 用户没有登录，执行上传操作属于非法操作，跳转到用户登录页面
			// 登录页面URL
			return "redirect:index.html";

		}

		// --------------------------------------------------------------------------------------------------------
		// 用户合法后的操作

		// 执行文件上传操作，上传到文件服务器
		// Map result = fileUploadService.uploadFile(uploadFile);
		Map result = userFileService.upload(uploadFile);

		/*
		 * 操作表数据，保存文件的地址和用户关联到数据库
		 */

		// id
		// name
		// checkstatus 文件审核状态（0未审核，1已审核）
		// download_url
		// createtime
		// updatetime
		// filetype 文件类型（1入会申请资料2入会协议3缴费回执单。。）

		// 保存文件实体
		HxFile file = new HxFile();

		String id = IDUtils.getUUID();
		file.setId(id);

		result.put("id", id);
		// 文件名
		String name = uploadFile.getOriginalFilename();
		file.setName(name);

		result.put("fileName", name);

		// 审核状态
		file.setCheckstatus(0);

		// 下载url
		String fileUrl = (String) result.get("url");
		file.setDownloadUrl(fileUrl);

		// 日期
		Date date = new Date();
		file.setCreatetime(date);
		file.setUpdatetime(date);

		// 用户下载入会申请资料
		// public static final int SC_15 = 15;
		// 用户上传材料扫件
		// public static final int SC_20 = 20;
		// 入会申请资料状态：15或20

		// 用户下载签订入会协议
		// public static final int SC_30 = 30;
		// 用户上传签订入会协议
		// public static final int SC_33 = 33;
		// 入会申请资料状态：30或33

		// 用户缴纳会费成功
		// public static final int SC_34 = 34;
		// 上传回执单扫件
		// public static final int SC_35 = 35;

		// 根据用户的状态位对比文件的类型

		// 保存文件记录到数据库
		fileUploadService.saveOrUpdate(file);

		// 长长的分割线-------------------------------------------------------------------------------------------------------------
		// 关联文件和用户操作

		HxFileUser fileUser = new HxFileUser();

		String fileUserId = IDUtils.getUUID();
		fileUser.setId(fileUserId);

		fileUser.setHxUser(user);
		fileUser.setHxFile(file);

		// 上传的文件种类，和文件表保持一致
		fileUser.setStatus(file.getFiletype());

		// 是否删除
		fileUser.setIsDelete(0);

		// 执行保存操作
		sysService.saveOrUpdate(fileUser);

		// 长长的分割线-------------------------------------------------------------------------------------------------------------
		// 修改用户状态码


		this.sysService.saveOrUpdate(user);
		/*
		 * 将返回数据转化为json格式
		 */

		result.remove("url");
		String jsonString = JSONUtils.toJSONString(result);

		return jsonString;

	}

	public String uploadMain(GeneralUserEntity user, MultipartFile uploadFile) {
		Map result = null;
		// 执行文件上传操作，上传到文件服务器
		try {
			result = userFileService.upload(uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * 操作表数据，保存文件的地址和用户关联到数据库
		 */
		// 保存文件实体
		HxFile file = new HxFile();

		String id = IDUtils.getUUID();
		file.setId(id);

		// 文件名
		String name = uploadFile.getOriginalFilename();
		file.setName(name);

		// 审核状态
		file.setCheckstatus(0);

		// 下载url
		String fileUrl = (String) result.get("url");
		file.setDownloadUrl(fileUrl);

		// 日期
		Date date = new Date();
		file.setCreatetime(date);
		file.setUpdatetime(date);

		// 根据用户的状态位对比文件的类型


		// 保存文件记录到数据库
		fileUploadService.saveOrUpdate(file);

		// 长长的分割线-------------------------------------------------------------------------------------------------------------
		// 关联文件和用户操作

		HxFileUser fileUser = new HxFileUser();

		String fileUserId = IDUtils.getUUID();
		fileUser.setId(fileUserId);

		fileUser.setHxUser(user);
		fileUser.setHxFile(file);

		// 上传的文件种类，和文件表保持一致
		fileUser.setStatus(file.getFiletype());

		// 是否删除
		fileUser.setIsDelete(0);

		// 执行保存操作
		sysService.saveOrUpdate(fileUser);

		// 长长的分割线-------------------------------------------------------------------------------------------------------------
		// 修改用户状态码

		this.sysService.saveOrUpdate(user);

		result.put("id", id);
		/*
		 * 将返回数据转化为json格式
		 */
		String jsonString = JSONUtils.toJSONString(result);

		return jsonString;

	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public ReplyDataMode upload(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();

		/** 获取用户登录信息 */
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO userVoForm = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		GeneralUserEntity user = null;
		if (userVoForm != null) {
			user = this.sysService.get(GeneralUserEntity.class, userVoForm.getId());
			// --------------------------------------------------------------------------------------------------------
			// 用户合法后的操作

			// 保存附近文件信息
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

			for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
				MultipartFile uploadFile = entity.getValue();// 获取上传文件对象
				try {
					String result = uploadMain(user, uploadFile);
					System.out.println("result:" + result);
					// 更新session
					AuthUserVO userVo = new AuthUserVO();
					MyBeanUtils.copyBeanNotNull2Bean(user, userVo);
					currentUser.getSession().setAttribute("userInfo", userVo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 如果是单传，则只循环一次
				// break;
			}
			j.setSuccess(true);
		} else {
			// 用户没有登录，执行上传操作属于非法操作，跳转到用户登录页面
			j.setSuccess(false);
			j.setStatusCode("用户没有登录，请登录！");
			// return j;
		}
		return j;
	}

	/**
	 * 下载公共方法
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPath")
	@ResponseBody
	public ReplyDataMode getPath(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		List<HxFile> fileList = this.sysService.findByProperty(HxFile.class, "title", "must");
		// 封装返回数据
		List<FileVo> fileVos = new ArrayList<>();
		FileVo fileVo = null;
		if (fileList != null) {
			for (HxFile file : fileList) {
				fileVo = new FileVo();
				fileVo.copyEntity(file);
				fileVos.add(fileVo);
			}
			j.setData(fileVos);
			j.setStatusCode("200");
			j.setSuccess(true);
		} else {

			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 
	 * 通过文件id下载文件 并更改用户状态
	 * @throws Exception
	 */
	@RequestMapping(value = "/down")
	@ResponseBody
	public ReplyDataMode down(HttpServletResponse res, FileSearchForm form) throws IOException {
		ReplyDataMode j = new ReplyDataMode();
		boolean flag = false;
		/** 获取用户登录信息 */
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO userVoForm = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		GeneralUserEntity user = null;
		if (userVoForm != null) {
			user = this.sysService.get(GeneralUserEntity.class, userVoForm.getId());
			// 根据用户的状态位对比文件的类型
			Integer checkstatus = user.getCheckstatus();

			this.sysService.saveOrUpdate(user);
			Integer fileType = Integer.parseInt(form.getFiletype());
			if(form!=null){
				downMain(res, form);
				return j;
			}
//			if (checkstatus >= fileType) {
//			}
		}
		j.setStatusCode("NO");
		j.setSuccess(flag);
		return j;
	}
	
	/**
	 * 
	 * 通过文件id下载文件
	 * @throws Exception
	 */
	@RequestMapping(value = "/downMain")
	public void downMain(HttpServletResponse res, FileSearchForm form) throws IOException {
		OutputStream os = res.getOutputStream();
		try {
			// 通过文件id查找文件名称和下载路径
			HxFile hxFile = sysService.get(HxFile.class, form.getId());
			
			// 下载的文件路径
			String path = hxFile.getDownloadUrl();

			File file = new File(path);
			String downloadName = hxFile.getName();

			String fileName =  URLEncoder.encode(downloadName, "UTF8");
//			String fileName = new String(downloadName.getBytes("UTF-8"), "ISO8859-1");
//			String fileName = new String(downloadName.getBytes("iso8859-1"), "UTF-8");
//			new String(str.getBytes("iso8859-1"), "UTF-8");
			res.reset();
			res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			res.setContentType("application/octet-stream; charset=utf-8");
			os.write(FileUtils.readFileToByteArray(file));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}
	
	
	

	// private If

	// 真不知道你上面不是写完了么？？？ 下载文件的方法

	
}
