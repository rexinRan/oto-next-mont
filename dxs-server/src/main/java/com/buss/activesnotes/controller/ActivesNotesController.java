package com.buss.activesnotes.controller;

import com.buss.activesnotes.entity.ActivesNotesEntity;
import com.buss.activesnotes.trans.from.ActivesNotesFrom;
import com.buss.activesnotes.trans.vo.ActivesNotesVo;
import com.buss.common.controller.MessyCode;
import com.buss.common.service.SysServiceI;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
@Controller
@RequestMapping("/activesNotes")
public class ActivesNotesController {

    @Autowired
    private SysServiceI sysServiceI;

    @Autowired
    private MessyCode messyCode;

    /**
     * 游学须知
     * @param activesNotesFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "travelNotes")
    @ResponseBody
    public ReplyDataMode travelNotes(ActivesNotesFrom activesNotesFrom, Integer curPage, Integer pageSize, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 根据id查询详情页
        if (activesNotesFrom.getId() != null && !activesNotesFrom.getId().isEmpty()){
            ActivesNotesEntity activesNotesEntity = this.sysServiceI.get(ActivesNotesEntity.class,activesNotesFrom.getId());
            ActivesNotesVo activesNotesVo = new ActivesNotesVo();
            if (activesNotesEntity != null){
                activesNotesVo.copyEntity(activesNotesEntity);
            }
            replyDataMode.setData(activesNotesVo);
        }else {
            // 国别的乱码处理
            if (activesNotesFrom.getCountrys() != null && !activesNotesFrom.getCountrys().isEmpty()){
                activesNotesFrom.setCountrys(messyCode.messyCodeTreatment(activesNotesFrom.getCountrys()));
            }else if (activesNotesFrom.getCountrys() != null && activesNotesFrom.getCountrys().isEmpty()){
                activesNotesFrom.setCountrys(null);
            }
            activesNotesFrom.setIsDelete("0");

            CriteriaQuery criteriaQuery = activesNotesFrom.getCriteriaQuery();
            criteriaQuery.addOrder("publishTime","desc");

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<ActivesNotesEntity> activesNotesEntityList = mode.getResult();
            List<ActivesNotesVo> activesNotesVos = new ArrayList<ActivesNotesVo>();

            if (activesNotesEntityList != null && activesNotesEntityList.size() > 0){
                for (ActivesNotesEntity ane:activesNotesEntityList){
                    ActivesNotesVo activesNotesVo = new ActivesNotesVo();
                    activesNotesVo.copyEntity(ane);
                    activesNotesVos.add(activesNotesVo);
                }
            }
            mode.setResult(activesNotesVos);
            replyDataMode.setData(mode);
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}
