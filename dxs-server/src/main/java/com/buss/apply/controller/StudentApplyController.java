package com.buss.apply.controller;

import com.buss.apply.entity.ApplyEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.file.entity.FileEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
@Controller
@RequestMapping("/student")
public class StudentApplyController {

    @Autowired
    private FileService fileService;

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 助学金,奖学金申请接口
     * 奖学金 type为1
     * 助学金 type为2
     */
    @RequestMapping("/applay")
    @ResponseBody
    public AjaxJson studentApplay(String fm, String type,ApplyEntity applyEntity, UserDetailEntity userDetailEntity, HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//            // 查询用户详情数据
//            UserDetailEntity ud = this.sysServiceI.findUniqueByProperty(UserDetailEntity.class,"userId", user.getId());
//            if (ud != null ) {
//                try {
//                    this.convert( ud, userDetailEntity);
//                    ud.setUpdateTime(new Date());
//                    ud.setIsDelete(0);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                ud = userDetailEntity;
//                Date date = new Date();
//                ud.setCreateTime(date);
//                ud.setUpdateTime(date);
//                ud.setIsDelete(0);
//            }
////        userDetailEntity.setUserId(user.getId());
//            // 更新用户详情表
//            this.sysServiceI.saveOrUpdate(ud);



            // 用户申请表信息
            Date date = new Date();
            applyEntity.setUserId(user.getId());
            applyEntity.setApplyType(type);

            // 检测用户申请信息
            List<ApplyEntity> list = this.sysServiceI.findByExample(ApplyEntity.class.getName(), applyEntity);
            if ((list==null||list.size()==0) || (list!=null&&list.size()==1&&list.get(0).getCheckcode().equals("4"))){

                applyEntity.setCheckcode("0");
                applyEntity.setCreateTime(date);
                applyEntity.setUpdateTime(date);
                applyEntity.setApplicationTime(date);
                applyEntity.setIsDelete(0);

                // 添加用户申请
                this.sysServiceI.saveOrUpdate(applyEntity);
                applyEntity = (ApplyEntity) this.sysServiceI.findByExample(ApplyEntity.class.getName(), applyEntity).get(0);

                // 更新文件表
                FileEntity file_temp = this.sysServiceI.get(FileEntity.class, fm);
                file_temp.setOutId(applyEntity.getId());
                file_temp.setTableType("1");
                file_temp.setUpdatetime(new Date());
                file_temp.setIsDetail(0);
                sysServiceI.saveOrUpdate(file_temp);

            } else {
                if (list!=null) {
                    if (list.size()==1&&list.get(0).getCheckcode().equals("3")) {
                        message = "你的申请已通过";
                    } else if (list.size()==1&&list.get(0).getCheckcode().equals("0")) {
                        message = "你有待审信息";
                    } else if (list.size()==2) {
                            message = "你的申请次数已用完,明年继续努力!";
                        }
                    }
                }
//            }
//            if (list!=null && list.size()>0&&!(list.size()==1&&list.get(0).getCheckcode("2")) {
//                if (list.get(0).getCheckcode().equals("0")) {
//                    message = "你有待审信息";
//                } else if (list.size()>= 2) {
//                    message = "你的申请次数已用完,明年继续努力!";
//                }
//            } else {
//                applyEntity.setCheckcode("0");
//                applyEntity.setCreateTime(date);
//                applyEntity.setUpdateTime(date);
//                applyEntity.setApplicationTime(date);
//                applyEntity.setIsDelete(0);
//
//
//                // 添加用户申请
//                this.sysServiceI.saveOrUpdate(applyEntity);
//                applyEntity = (ApplyEntity) this.sysServiceI.findByExample(ApplyEntity.class.getName(), applyEntity).get(0);
//
//                // 更新文件表
//                FileEntity file_temp = this.sysServiceI.get(FileEntity.class, fm);
//                file_temp.setOutId(applyEntity.getId());
//                file_temp.setTableType("1");
//                file_temp.setUpdatetime(new Date());
//                file_temp.setIsDetail(0);
//                sysServiceI.saveOrUpdate(file_temp);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败!";
        }
        ajaxJson.setMsg(message);

        return ajaxJson;
    }







    /**
     * 修改工具类
     * @param dest
     * @param orig
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void convert(Object dest, Object orig) throws
            IllegalAccessException, InvocationTargetException {

        // Validate existence of the specified beans
        if (dest == null) {
            throw new IllegalArgumentException
                    ("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }

        // Copy the properties, converting as necessary
        if (orig instanceof DynaBean) {
            DynaProperty origDescriptors[] =
                    ( (DynaBean) orig).getDynaClass().getDynaProperties();
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if (PropertyUtils.isWriteable(dest, name)) {
                    Object value = ( (DynaBean) orig).get(name);
                    try {
                        MyBeanUtils.copyProperty(dest, name, value);
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }
        else if (orig instanceof Map) {
            Iterator names = ( (Map) orig).keySet().iterator();
            while (names.hasNext()) {
                String name = (String) names.next();
                if (PropertyUtils.isWriteable(dest, name)) {
                    Object value = ( (Map) orig).get(name);
                    try {
                        MyBeanUtils.copyProperty(dest, name, value);
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }
        else
      /* if (orig is a standard JavaBean) */
        {
            PropertyDescriptor origDescriptors[] =
                    PropertyUtils.getPropertyDescriptors(orig);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
//              String type = origDescriptors[i].getPropertyType().toString();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                if (PropertyUtils.isReadable(orig, name) &&
                        PropertyUtils.isWriteable(dest, name)) {
                    try {
                        Object value = PropertyUtils.getSimpleProperty(orig, name);
                        if (value != null) {
                            MyBeanUtils.copyProperty(dest, name, value);
                        }
                    }
                    catch (java.lang.IllegalArgumentException ie) {
                        ; // Should not happen
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }

    }
}
