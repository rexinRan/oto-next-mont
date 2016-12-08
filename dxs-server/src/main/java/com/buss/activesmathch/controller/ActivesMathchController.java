package com.buss.activesmathch.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activesmatchcom.controller.ActivesMatchComController;
import com.buss.activesmatchcom.entity.ActivesMatchComEntity;
import com.buss.activesmatchcom.trans.from.ActivesMatchComFrom;
import com.buss.activesmatchcom.trans.vo.ActivesMatchComVo;
import com.buss.activesmathch.entity.ActivesMathchEntity;
import com.buss.activesmathch.trans.from.ActivesMathchFrom;
import com.buss.activesmathch.trans.vo.ActivesMathchVo;
import com.buss.common.service.SysServiceI;
import com.buss.common.trans.vo.FileVo;
import com.buss.file.entity.FileEntity;
import com.buss.file.trans.form.FileForm;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.format.datetime.joda.ReadablePartialPrinter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: dxs_actives_mathch
 * @author onlineGenerator
 * @date 2016-08-29 11:29:20
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsActivesMathch")
public class ActivesMathchController {

    @Resource
    private SysServiceI sysServiceI;

    @Resource
    private ActivesMatchComController activesMatchCom;  // 单位

    /**
     * 校园赛事的详情页
     *
     * @param activesMathchFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "detailed")
    @ResponseBody
    public ReplyDataMode detailed(ActivesMathchFrom activesMathchFrom, String dataType, String amId, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesMathchFrom.setIsDelete("0");

        if (activesMathchFrom.getActiveId() != null && !activesMathchFrom.getActiveId().isEmpty()) {

            // 查询活动
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class, activesMathchFrom.getActiveId());
            List<Object> list = new ArrayList<Object>();
            Map<String, Object> acitvesMap = new HashMap<String, Object>();
            ActivessVO activessVO = new ActivessVO();

            if (activessEntity != null) {
                activessVO.copyEntity(activessEntity);
            }
            acitvesMap.put("activessVO", activessVO);
            list.add(acitvesMap);

            // 查询所关联的校园赛事
            CriteriaQuery criteriaQuery = activesMathchFrom.getCriteriaQuery();
            List<ActivesMathchEntity> activesMathchEntityList = this.sysServiceI.list(criteriaQuery);
            Map<String, Object> activesmathchMap = new HashMap<String, Object>();
            ActivesMathchVo activesMathchVo = new ActivesMathchVo();

            if (activesMathchEntityList != null && activesMathchEntityList.size() > 0) {
                activesMathchVo.copyEntity(activesMathchEntityList.get(0));

                // 将精彩回放链接以"#"好切割
                String[] picture = null;
                Map<String, Object> pictureMap = new HashMap<String, Object>();
                if (activesMathchEntityList.get(0).getImgurls() != null && !activesMathchEntityList.get(0).getImgurls().isEmpty()) {
                    picture = activesMathchEntityList.get(0).getImgurls().split("#");
                    activesMathchVo.setPicture(picture);
                }
            }
            activesmathchMap.put("activesMathchVo", activesMathchVo);


            list.add(activesmathchMap);
            replyDataMode.setData(list);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);

        }

        return replyDataMode;
    }


    /**
     * 根据名称/和活动扩展表的ID查询
     *
     * @param fileForm 文件表
     * @param request
     * @return
     */
    @RequestMapping(value = "fileDowload")
    @ResponseBody
    public ReplyDataMode fileDowload(FileForm fileForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (fileForm.getOutId() != null && !fileForm.getOutId().isEmpty() && fileForm.getName() != null && !fileForm.getName().isEmpty()) {

            String sql = "SELECT\n" +
                    "\tf.download_url,\n" +
                    "\tf.id,\n" +
                    "\tf.`name`\n" +
                    "FROM\n" +
                    "\tdxs_file f\n" +
                    "WHERE\n" +
                    "\tf.is_detail = 0\n" +
                    "AND f.out_id = '" + fileForm.getOutId() + "'\n" +
                    "AND f.`name` LIKE '%" + fileForm.getName() + "%'";

            List<Map> list = this.sysServiceI.findListbySql(sql);

            List<Map<String, Object>> aList = new ArrayList();
            if (!list.isEmpty())
                for (Object obj : list) {
                    Map map = new HashMap();
                    Object[] u = (Object[]) obj;
                    String field = "";
                    for (int i = 0; i < u.length; i++) {
                        if (u[i] != null) {
                            field = u[i].toString();
                        } else {
                            field = "";
                        }
                        map.put("field" + i, field);
                    }
                    aList.add(map);

                    replyDataMode.setData(aList);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }
        }
        return replyDataMode;
    }

    /**
     * 下载接口
     *  http://localhost:8080/dxs-server/download.do?fid=402880e455b9c9240155ba147dc90005
     */
}