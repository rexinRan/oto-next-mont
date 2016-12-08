package com.buss.trainoutlineusers.controller;


import com.buss.common.service.SysServiceI;
import com.buss.trainoutlineusers.entity.TrainOutlineUsersEntity;
import com.buss.trainoutlineusers.trans.from.TrainOutlineUsersFrom;
import com.buss.trainoutlineusers.trans.vo.TrainOutlineUsersVo;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.format.datetime.joda.ReadableInstantPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Controller
 * @Description: dxs_train_outline_users
 * @author onlineGenerator
 * @date 2016-09-09 09:32:28
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/TrainOutlineUsers")
public class TrainOutlineUsersController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 所有的学员风采
     * @param request
     * @return
     */
    @RequestMapping(value = "allStudent")
    @ResponseBody
    public ReplyDataMode allStudent(TrainOutlineUsersFrom trainOutlineUsersFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        trainOutlineUsersFrom.setIsDelete("0");
        CriteriaQuery criteriaQuery = trainOutlineUsersFrom.getCriteriaQuery();

        if (!StringUtil.isEmpty(trainOutlineUsersFrom.getPageNo()) && !StringUtil.isEmpty(trainOutlineUsersFrom.getPageSize())) {
            Integer pageNo = Integer.parseInt(trainOutlineUsersFrom.getPageNo());
            Integer pageSize = Integer.parseInt(trainOutlineUsersFrom.getPageSize());

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
            List<TrainOutlineUsersEntity> trainOutlineUsersEntityList = mode.getResult();
            List<TrainOutlineUsersVo> trainOutlineUsersVos = new ArrayList<TrainOutlineUsersVo>();

            if (trainOutlineUsersEntityList != null && trainOutlineUsersEntityList.size() > 0){
                for (TrainOutlineUsersEntity toue:trainOutlineUsersEntityList){
                    TrainOutlineUsersVo trainOutlineUsersVo = new TrainOutlineUsersVo();
                    trainOutlineUsersVo.copyEntity(toue);
                    trainOutlineUsersVos.add(trainOutlineUsersVo);
                }
            }

            mode.setResult(trainOutlineUsersVos);
            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }
}
