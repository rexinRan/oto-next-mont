package com.buss.common.controller;

import org.jweb.core.bean.ReplyDataMode;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.UnsupportedEncodingException;


@Component
public class MessyCode {


    /**
     * 乱码处理
     * Created by Administrator on 2016/7/28.
     */
    public String messyCodeTreatment(String name){

        if (name != null && !name.isEmpty()){
            try {
                return  new String(name.getBytes("iso-8859-1"), "utf-8");
            } catch (Exception e) {
                return "乱码处理失败!";
            }
        }
        return "name为空!";
    }

}
