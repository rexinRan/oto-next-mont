package com.buss.userdetail.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.model.json.ReplyStatus;
import com.buss.common.redis.RedisClient;
import com.buss.common.service.SysServiceI;
import com.buss.common.util.sms.Constants;
import com.buss.common.util.sms.MailTemplets;
import com.buss.common.util.sms.MailUtil;
import com.buss.common.util.sms.TSSmsEntity;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.form.member.GeneralUserForm;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.buss.userdetail.trans.vo.UserDetailVO;
import com.sun.mail.smtp.SMTPAddressFailedException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.PasswordUtil;
import org.jweb.core.util.PropertiesUtil;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.mail.AuthenticationFailedException;
import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/14.
 * 个人中心
 */

@Controller
@RequestMapping("/userdetail")
public class UserDetailController{

    @Resource
    private SysServiceI sysServiceI;
    @Resource
    private RedisClient redisClient;

    /**
     * 初始化个人中心
     */
    @RequestMapping(value = "/initCentrality")
    @ResponseBody
    public ReplyDataMode initCentrality(HttpServletRequest reuqest){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        /*判断*/
        if (user != null){
            /**学生或老师*/
            if (user.getRolecode().equals("student") || user.getRolecode().equals("teacher")){

                Map<String,Object> map = new HashMap<String,Object>();
                String province = null;         // 省会
                String city = null;             // 市
                String county = null;           // 区县
                String infoAddress = null;      // 详细信息
                UserDetailForm userDetailForm = new UserDetailForm();
                userDetailForm.setIsDelete("0");
                userDetailForm.setUserId(user.getId());
                CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();

                // 用户扩展表
                List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);
                UserDetailVO userDetailVO = new UserDetailVO();
                if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                    userDetailVO.copyEntity(userDetailEntityList.get(0));

                    /*切割通讯地址*/
                    if (userDetailEntityList.get(0).getPostalAddress() != null && !userDetailEntityList.get(0).getPostalAddress().isEmpty() &&
                    userDetailEntityList.get(0).getPostalAddress().contains("#")){
                        String[] address = userDetailEntityList.get(0).getPostalAddress().split("#");

                        for (int i = 0;i < address.length;i++){
                            if (i == 0){
                                province = address[i];
                            }else if (i == 1){
                                city = address[1];
                            }else if (i == 2){
                                county = address[2];
                            }else if (i == 3){
                                infoAddress = address[3];
                            }
                        }
                    }else {
                        infoAddress = userDetailEntityList.get(0).getPostalAddress();
                    }

                    // 切割学校所在地
                    if (!StringUtil.isEmpty(userDetailEntityList.get(0).getSchoolAddress())){
                        String[] address  = userDetailEntityList.get(0).getSchoolAddress().split("#");
                        userDetailEntityList.get(0).setSchoolAddress(address[0]);
                    }
                }else {
                    // 创建当前用户的扩展表
                    userDetailForm.setName(user.getRealname());
                    userDetailForm.setPhone(user.getMphone());
                    UserDetailEntity userDetailEntity = (UserDetailEntity) userDetailForm.toEntity();
                    userDetailEntity.setCreateTime(new Date());

                    // 创建
                    this.sysServiceI.saveOrUpdate(userDetailEntity);

                    // 查询
                    userDetailEntityList = this.sysServiceI.findByProperty(UserDetailEntity.class,"userId",user.getId());
                    if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                        userDetailVO.copyEntity(userDetailEntityList.get(0));
                    }
                }

                map.put("province",province);
                map.put("city",city);
                map.put("city",city);
                map.put("county",county);
                map.put("infoAddress",infoAddress);
                map.put("userDetailVO",userDetailVO);

                replyDataMode.setData(map);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }

            /*企业----->未完成*/

        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }

        return  replyDataMode;
    }


    /**
     * 保存个人基本信息
     * @param userDetailForm        用户扩展表
     * @param province              省会
     * @param city                  市
     * @param county                县
     * @param infoAddress           详细地址
     * @return
     */
    @RequestMapping(value = "saveOrUpdataInformation")
    @ResponseBody
    public ReplyDataMode saveOrUpdataInformation(UserDetailForm userDetailForm,String province,String city,String county,String infoAddress){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){

            // 判断用户(教师)是否已认证(待申请)或认证通过
            replyDataMode = this.judgeAuthentication();
            if (replyDataMode.isSuccess()){
                return replyDataMode;
            }

            if (userDetailForm != null){

                String address = null;
                if (!StringUtil.isEmpty(province) && !StringUtil.isEmpty(city) && !StringUtil.isEmpty(county) && !StringUtil.isEmpty(infoAddress)){

                    // 拼接通讯地址
                    address = province + "#" + city + "#" + county + "#" + infoAddress;
                    userDetailForm.setPostalAddress(address);

                    // 判断真实姓名是否被修改(同步到user表中)
                    if (!StringUtil.isEmpty(user.getRealname()) && !StringUtil.isEmpty(userDetailForm.getName())){

                        // 已修改
                        if (!user.getRealname().equals(userDetailForm.getName())){
                            GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                            generalUserEntity.setRealname(userDetailForm.getName());
                            this.sysServiceI.saveOrUpdate(generalUserEntity);
                        }

                        // 保存信息
                        UserDetailForm userDetailForm1 = new UserDetailForm();
                        userDetailForm1.setIsDelete("0");
                        userDetailForm1.setUserId(user.getId());
                        CriteriaQuery criteriaQuery = userDetailForm1.getCriteriaQuery();
                        List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);

                        if (userDetailEntityList != null && userDetailEntityList.size() > 0) {
                            UserDetailEntity userDetailEntity = userDetailEntityList.get(0);

                            // 学生
                            if ("student".equals(user.getRolecode())){
                                userDetailEntity.setZipCode(userDetailForm.getZipCode());
                                userDetailEntity.setSchoolGrade(userDetailForm.getSchoolGrade());
                            }

                            // 教师
                            if ("teacher".equals(user.getRolecode())){
                                userDetailEntity.setJobSchool(userDetailForm.getJobSchool());
                                userDetailEntity.setDepartment(userDetailForm.getDepartment());
                                userDetailEntity.setBorthday(userDetailForm.getBorthday());
                                userDetailEntity.setJobSchoolPosition(userDetailForm.getJobSchoolPosition());
                            }
                            userDetailEntity.setName(userDetailForm.getName());
                            userDetailEntity.setUserId(user.getId());
                            userDetailEntity.setUpdateTime(new Date());
                            userDetailEntity.setHeadImg(userDetailForm.getHeadImg());
                            userDetailEntity.setSex(userDetailForm.getSex());
                            userDetailEntity.setPostalAddress(address);
                            userDetailEntity.setSchoolAdmission(userDetailForm.getSchoolAdmission());
                            userDetailEntity.setSchoolName(userDetailForm.getSchoolName());
                            userDetailEntity.setIdcard(userDetailForm.getIdcard());
                            userDetailEntity.setSchoolMajor(userDetailForm.getSchoolMajor());
                            userDetailEntity.setSchoolFaculty(userDetailForm.getSchoolFaculty());
                            userDetailEntity.setSchoolEducation(userDetailForm.getSchoolEducation());

                            // 判断学校所在地是否为空
                            if (!StringUtil.isEmpty(userDetailForm.getSchoolAddress())){
                                // 判断库中的学校所在地是否存在存在"#"
                                if (!StringUtil.isEmpty(userDetailEntity.getSchoolAddress()) && userDetailEntity.getSchoolAddress().contains("#")){
                                    // 如果包含#号,那么将0索引位置的数据替换
                                    String[] arr = userDetailEntity.getSchoolAddress().split("#");
                                    arr[0] = userDetailForm.getSchoolAddress();
                                    userDetailEntity.setSchoolAddress(arr.toString());
                                }else {

                                    userDetailEntity.setSchoolAddress(userDetailForm.getSchoolAddress());
                                }
                            }else {
                                replyDataMode.setStatusCode("请填写学校所属省份!");
                                replyDataMode.setSuccess(true);
                                return replyDataMode;
                            }
                            try {
                                this.sysServiceI.saveOrUpdate(userDetailEntity);

                                // 更新user表中的checkstatus
                                GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                                generalUserEntity.setCheckstatus(5);
                                this.sysServiceI.saveOrUpdate(generalUserEntity);

                                replyDataMode.setStatusCode("提交成功!");
                                replyDataMode.setSuccess(true);
                            }catch (Exception e){
                                replyDataMode.setStatusCode("提交失败!");
                                replyDataMode.setSuccess(true);
                                return replyDataMode;
                            }
                        }else {

                            replyDataMode.setStatusCode("该用户不存在!");
                            replyDataMode.setSuccess(false);
                        }
                    }else {

                        replyDataMode.setStatusCode("请填写姓名!");
                        replyDataMode.setSuccess(false);
                    }
                }else {

                    replyDataMode.setStatusCode("请填写地址信息!");
                    replyDataMode.setSuccess(false);
                }
            }else {

                replyDataMode.setStatusCode("请完善信息!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }




    /**
     * 判断当前用户是否已经教师认证或认证通过
     * @return
     */
    @RequestMapping(value = "judgeAuthentication")
    @ResponseBody
    public ReplyDataMode judgeAuthentication(){
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
                    "da.authentication_result in(4,5,7,8,10,11,13,14,16,17,19,20)\n" +
                    "AND\n" +
                    "da.is_delete=0";

            List<Map> list = this.sysServiceI.findListbySql(dataSql);

            if (list != null && list.size() > 0){
                replyDataMode.setStatusCode("您已申请待认证或认证已通过!");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("您未认证或认证失败!");
                replyDataMode.setSuccess(false);
            }

        }else {
            replyDataMode.setStatusCode("请您登陆!");
        }

        return replyDataMode;
    }





    /**
     * 判断当前用户是否完善个人信息
     * @param request
     * @return
     */
    @RequestMapping(value = "judgeUserDetail")
    @ResponseBody
    public ReplyDataMode judgeUserDetail(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            UserDetailForm userDetailForm = new UserDetailForm();
            userDetailForm.setUserId(user.getId());
            userDetailForm.setIsDelete("0");
            CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();

            List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);

            if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                replyDataMode.setStatusCode("以完善个人信息!");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("请完善个人信息!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 保存个人中心>>个人基本信息
     */
    @RequestMapping(value = "/savePersonalCenter")
    @ResponseBody
    public ReplyDataMode saveUserDetail1(UserDetailEntity userDetailEntity, ResumeEntity resumeEntity, HttpServletRequest request){
        userDetailEntity.setIsDelete(0);
        resumeEntity.setId(null);
        ReplyDataMode replyDataMode = new ReplyDataMode();
        UserDetailVO userDetailVO = new UserDetailVO();
        GeneralUserEntity generalUserEntity = new GeneralUserEntity();

        Subject currentUser = SecurityUtils.getSubject();
        // 获取当前登录用户
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        String pwd = request.getParameter("pwd");


        try {
            Date data = new Date();
            userDetailEntity.setUserId(user.getId());
            userDetailEntity.setUpdateTime(data);

            //luyueyue
            //更改审核码
            generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
            if("student".equals(user.getRolecode())){
                generalUserEntity.setCheckstatus(3);
            }else{
                generalUserEntity.setCheckstatus(6);
            }
            this.sysServiceI.saveOrUpdate(generalUserEntity);
            // 保存个人信息
            this.sysServiceI.saveOrUpdate(userDetailEntity);

            /**保存密码*/
            if(pwd != null && !pwd.isEmpty()) {
                GeneralUserEntity userentry = this.sysServiceI.get(GeneralUserEntity.class , user.getId());
                // 将修改后的密码保存到用户表中
                userentry.setPwd(PasswordUtil.encrypt(pwd));
                /*// 将修改后的电话号码保存到用户表中 电话号码不可以改是账户
                if (userDetailEntity.getPhone() != null && userDetailEntity.getPhone() != ""){
                    userentry.setMphone(userDetailEntity.getPhone());
                }*/
                this.sysServiceI.saveOrUpdate(userentry);
            }

            /**保存用户身份证到注册表中*/
            if (userDetailEntity.getIdcard() != null && !userDetailEntity.getIdcard().isEmpty()){
                GeneralUserEntity userentry = this.sysServiceI.get(GeneralUserEntity.class , user.getId());
                userentry.setIdcardnumber(userDetailEntity.getIdcard());
                this.sysServiceI.saveOrUpdate(userentry);
            }
            // 判断注册表中的name和个人中心表中的name是否一致
            if (userDetailEntity.getName() != null && userDetailEntity.getName() != ""){
//                generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                if (!generalUserEntity.getRealname().equals(userDetailEntity.getName())){
                    generalUserEntity.setRealname(userDetailEntity.getName());
                    this.sysServiceI.saveOrUpdate(generalUserEntity);
                }
            }
            // 判断注册表中的mPhone和个人中心表中的phone是否一致
            if (userDetailEntity.getPhone() != null && userDetailEntity.getPhone() != ""){
//                generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                if (!generalUserEntity.getMphone().equals(userDetailEntity.getPhone())){
                    generalUserEntity.setMphone(userDetailEntity.getPhone());
                    this.sysServiceI.saveOrUpdate(generalUserEntity);
                }
            }
        } catch (Exception e) {
            replyDataMode.setStatusCode("修改失败！");
            replyDataMode.setSuccess(false);
            return replyDataMode;
        }

        replyDataMode.setStatusCode("修改成功！");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 判断邮箱或电话号是否存在
     * @param phone     电话号(登陆账号)
     * @param email     邮箱
     * @param request
     * @return
     */
    @RequestMapping(value = "judgePhone")
    @ResponseBody
    public ReplyDataMode judgePhone(String phone,String email,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 电话
        if (phone != null && !phone.isEmpty()){
            GeneralUserForm generalUserForm = new GeneralUserForm();
            generalUserForm.setMphone(phone);

            generalUserForm.setIsdelete("0");
            CriteriaQuery criteriaQuery = generalUserForm.getCriteriaQuery();

            List<GeneralUserEntity> generalUserEntityList = this.sysServiceI.list(criteriaQuery);

            // 判断是否存在
            if (generalUserEntityList != null && generalUserEntityList.size() > 0){
                replyDataMode.setStatusCode("该账号已存在!");
                replyDataMode.setSuccess(false);
            }else {
                replyDataMode.setStatusCode("该账号不存在!");
                replyDataMode.setSuccess(true);
            }
        }

        // 邮箱
        if (email != null && !email.isEmpty()){
            UserDetailForm userDetailForm = new UserDetailForm();
            userDetailForm.setIsDelete("0");
            userDetailForm.setEmail(email);

            CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();

            List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);

            // 判断是否存在
            if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                replyDataMode.setStatusCode("该邮箱已存在!");
                replyDataMode.setSuccess(false);
            }else {
                replyDataMode.setStatusCode("该邮箱不存在!");
                replyDataMode.setSuccess(true);
            }
        }

        return replyDataMode;
    }


    /**
     * 发送手机验证码
     * @param phone     验证的手机号
     * @param request
     * @return
     */
    @RequestMapping(value = "mobilePhoneVerification")
    @ResponseBody
    public ReplyDataMode mobilePhoneVerification(String phone,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (!StringUtil.isEmpty(phone)){

            // 确认手机号是否存在
            replyDataMode = this.judgePhone(phone,null,request);
            if (replyDataMode.isSuccess()){
                // 不存在
                //随机生成验证码
                String code = "";

                Random random = new Random();
                int x = random.nextInt(899999) + 100000;
                //	code = RandomUtil.generateRandom(6);
                code = x + "";

                // 将验证码存到session中
                request.getSession().setAttribute("code",code);

                replyDataMode.setData(code);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }

        return replyDataMode;
    }


    /**
     * 修改登陆账号(提交手机号和手机验证码)
     * @param identifying       手机验证码
     * @param phone             要修改的手机号
     * @param request
     * @return
     */
    @RequestMapping(value = "identifyingCode")
    @ResponseBody
    public ReplyDataMode identifyingCode(String identifying,String phone,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Subject currentUser = SecurityUtils.getSubject();
        // 获取当前登录用户
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        if (user != null){
            if (!StringUtil.isEmpty(identifying)){
                if (!StringUtil.isEmpty(phone)){
                    String code  = (String) request.getSession().getAttribute("code");
                    if (code.equals(identifying)){
                        GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                        generalUserEntity.setMphone(phone);

                        // 用户表
                        this.sysServiceI.saveOrUpdate(generalUserEntity);

                        // 用户扩展表
                        UserDetailForm userDetailForm = new UserDetailForm();
                        userDetailForm.setUserId(user.getId());
                        CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();
                        List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);

                        if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                            UserDetailEntity userDetailEntity = userDetailEntityList.get(0);
                            userDetailEntity.setPhone(phone);
                            userDetailEntity.setUpdateTime(new Date());

                            this.sysServiceI.saveOrUpdate(userDetailEntity);

                            replyDataMode.setStatusCode("修改成功!");
                            replyDataMode.setSuccess(true);
                        }
                    }else {
                        replyDataMode.setStatusCode("验证码输入错误!");
                        replyDataMode.setSuccess(false);
                    }
                }else {

                    replyDataMode.setStatusCode("请输入电话号!");
                    replyDataMode.setSuccess(false);
                }
            }else {

                replyDataMode.setStatusCode("请输入验证码!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }



    /**
     * 邮箱验证
     * @param email
     * @param request
     * @return
     */
    @RequestMapping(value = "mailboxVerification")
    @ResponseBody
    public ReplyDataMode mailboxVerification(String email,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Subject currentUser = SecurityUtils.getSubject();
        // 获取当前登录用户
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            if (!StringUtil.isEmpty(email)){
                replyDataMode = this.judgePhone(null,email,request);

                if (replyDataMode.isSuccess()){

                GeneralUserEntity userEntity = this.sysServiceI.get(GeneralUserEntity.class,user.getId());
                userEntity.setEmail(email);
                replyDataMode = doEmail(userEntity,0,request);

                if (replyDataMode.isSuccess()){
                    PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
                    String host = util.readProperty("mail.url.host");
                    String url = "http://"+host+"/"+util.readProperty("mail.url.user.join")+"?id="+ userEntity.getId() + "&email=" + email;

                    String key = userEntity.getId();
                    // 将用户的id作为key存储
                    if (!StringUtil.isEmpty(key)) {
                        // TODO 设置Redis缓存
                        int date = 1 * 24 * 60 * 60 * 3;       // 缓存时间
                        redisClient.put(key, url,date);
                    }
                }
                else {
                    return  replyDataMode;
                }
                }else {
                    return  replyDataMode;
                }
            }else {

                replyDataMode.setStatusCode("请输入邮箱!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 邮箱激活
     * @param request
     * @return
     */
    @RequestMapping(value = "mailboxActivation")
    @ResponseBody
    public ReplyDataMode mailboxActivation(String userId, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (!StringUtil.isEmpty(userId)){

            // 从redis中将指定的key取出
            String key = userId;

            if (!StringUtil.isEmpty(key)){
                String cache = (String) redisClient.get(key);
                if (!StringUtil.isEmpty(cache) && cache.contains("email")){
                    // 获取url中email
                    String email = cache.substring(cache.indexOf("email=")+6,cache.length());

                    // 活动url中的id
                    int status = cache.indexOf("id=")+3;
                    int end = cache.indexOf("&email");
                    String id = cache.substring(status,end);
                    // 判断从客户端传来的id和从url中取出的id是否相同
                    if (id.equals(userId)){
                        // 将邮箱保存至用户表和扩展表中
                        GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,userId);
                        // 更新绑定的邮箱
                        generalUserEntity.setEmail(email);
                        this.sysServiceI.saveOrUpdate(generalUserEntity);

                        UserDetailForm userDetailForm = new UserDetailForm();
                        userDetailForm.setUserId(userId);
                        List<UserDetailEntity> userDetailEntityList = this.sysServiceI.findByProperty(UserDetailEntity.class,"userId",userId);

                        if (userDetailEntityList != null && userDetailEntityList.size() > 0) {
                            UserDetailEntity userDetailEntity = userDetailEntityList.get(0);
                            userDetailEntity.setEmail(email);
                            userDetailEntity.setUpdateTime(new Date());

                            this.sysServiceI.saveOrUpdate(userDetailEntity);

                            replyDataMode.setStatusCode("激活成功!");
                            replyDataMode.setSuccess(true);
                        }else {
                            replyDataMode.setStatusCode("激活失败!!");
                            replyDataMode.setSuccess(false);
                        }
                    }else {
                        replyDataMode.setStatusCode("激活失败!!");
                        replyDataMode.setSuccess(false);
                    }
                }else {
                    replyDataMode.setStatusCode("激活失败!!");
                    replyDataMode.setSuccess(false);
                }
            }else {
                replyDataMode.setStatusCode("激活失败!!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("激活失败!!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 发送邮件
     * @param userEntity
     * @param mailContentType       // 邮件类型  "0":拼接邮件
     * @param request
     * @return
     */
    public ReplyDataMode doEmail(GeneralUserEntity userEntity,int mailContentType, HttpServletRequest request) {
        ReplyStatus j = new ReplyStatus();

        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 获取配置参数
        PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
        String remark = "";
        //邮件
        TSSmsEntity tsSmsEntity = new TSSmsEntity();
        try {
//			tsSmsEntity.setEsReceiver("wupands@qq.com");
            tsSmsEntity.setEsReceiver(userEntity.getEmail());
            tsSmsEntity.setEsTitle("全国大学生创业就业中心");
            /**邮件内容填充**/
            String esContent = MailTemplets.getMailContent(util, userEntity, tsSmsEntity, mailContentType, request);

            tsSmsEntity.setEsContent(esContent);
//			tsSmsEntity.setEsContent("测试内容");

            tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_1);
            MailUtil.sendEmail(util.readProperty("mail.smtpHost"),
                    tsSmsEntity.getEsReceiver(),tsSmsEntity.getEsTitle(), tsSmsEntity.getEsContent(),
                    util.readProperty("mail.sender"), util.readProperty("mail.user"), util.readProperty("mail.pwd"));

            tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_2);
            tsSmsEntity.setEsSendtime(new Date());
            remark = "已发送请到邮箱激活!";
            tsSmsEntity.setRemark(remark);
            replyDataMode.setStatusCode(remark);
            replyDataMode.setSuccess(true);

            // 保存发送记录
            if(this.sysServiceI!=null){
                this.sysServiceI.saveOrUpdate(tsSmsEntity);
            }else{
                sysServiceI.saveOrUpdate(tsSmsEntity);
            }
        } catch (Exception e) {
            //tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
            if (e instanceof AuthenticationFailedException){
                remark = "认证失败错误的用户名或者密码";
            }else if (e instanceof SMTPAddressFailedException){
                remark = "接受邮箱格式不对";
            }else if (e instanceof ConnectException){
                remark = "邮件服务器连接失败";
            }else{
                remark = e.getMessage();
            }
            //System.out.println(remark);
            //e.printStackTrace();
            tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
            tsSmsEntity.setEsSendtime(new Date());
            tsSmsEntity.setRemark(remark);
            // 保存发送记录
            if(this.sysServiceI!=null){
                this.sysServiceI.saveOrUpdate(tsSmsEntity);
            }else{
                sysServiceI.saveOrUpdate(tsSmsEntity);
            }
            replyDataMode.setStatusCode(remark);
            replyDataMode.setSuccess(false);
        }

        j.setStatus(tsSmsEntity.getRemark());
        return replyDataMode;
    }
}
