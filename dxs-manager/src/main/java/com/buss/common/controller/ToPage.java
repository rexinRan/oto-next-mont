package com.buss.common.controller;

import com.buss.user.entity.DxsRoleEntity;
import com.buss.user.entity.DxsUserEntity;
import org.jeecgframework.core.util.StringUtil;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.asm.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Administrator on 2016/6/15.
 */
@Scope("prototype")
@Controller
@RequestMapping("/commonToPage")
public class ToPage {

    /**
     * 通用页面跳转
     * 王腾云
     *
     * @return
     */
    @RequestMapping(params = {"pack","path"})
    public ModelAndView goAdd(@RequestParam("pack") String pack, @RequestParam("path") String path, HttpServletRequest req) {
        String page = "com/buss/" + pack + "/" + path;
        ModelAndView mav = new ModelAndView(page);

        Enumeration<String> parates = req.getParameterNames();

        while (parates.hasMoreElements()) {

            String key = parates.nextElement();

            String value = req.getParameter(key);

            mav.addObject(key, value);
        }


        return mav;
    }
}
