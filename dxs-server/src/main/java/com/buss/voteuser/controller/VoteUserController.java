package com.buss.voteuser.controller;

import com.buss.account.entity.DxsAccountEntity;
import com.buss.account.entity.DxsAccountLogEntity;
import com.buss.actives.entity.ActivesEntity;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.vote.entity.VoteEntity;
import com.buss.voteitem.entity.VoteItemEntity;
import com.buss.voteuser.entity.VoteUserEntity;
import com.buss.voteuser.trans.form.VoteUserSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/voteUser")
public class VoteUserController {

    @Autowired
    private SysServiceI sysServiceI;
//查询用户参与投票活动
//SELECT user_id,vote_id from dxs_vote_user WHERE user_id="4028800c55c49bf30155c4a178b10000" and is_delete =0  GROUP BY vote_id
    /**
     * 是否可以报名
     * 报名活动
     */
    @RequestMapping("/isVote")
    @ResponseBody
    public AjaxJson isVote(VoteEntity voteEntity, HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "";
        boolean success = false;

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//            if (user == null) {
//                message = "用户没有登录!";
//            }
            // 查询报名信息
            VoteUserEntity voteUserEntity = new VoteUserEntity();
            voteUserEntity.setUserId(user.getId());
            voteUserEntity.setVoteId(voteEntity.getId());
            List voteUsers = this.sysServiceI.findByExample(VoteUserEntity.class.getName(), voteUserEntity);
            if (voteUsers != null && voteUsers.size()>0) {
                message = "此投票活动您已经参加过";
            } else {
                VoteEntity vote = this.sysServiceI.getEntity(VoteEntity.class, voteEntity.getId()); // activeUserEntity.getActivesEntity();
                if (vote!=null && vote.getDeadlineDate().after(new Date()) && vote.getIsDelete()==0){
                    success = true;
                    message = "可以参加";
                } else{
                    message = "此活动截止日期已过";
                }
            }
            success = true;

        } catch (Exception e) {
            e.printStackTrace();
            message = "报名失败";

        }
        ajaxJson.setMsg(message);
        ajaxJson.setSuccess(success);
        return ajaxJson;
    }



    /**
     * 活动投票
     *
     */
    @RequestMapping("/doVote")
    @ResponseBody
    public AjaxJson doVote(String itemIds,VoteUserEntity voteUserEntity1, HttpServletRequest request) {
        String [] ids = itemIds.split(",");
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";
        boolean success = false;

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            VoteEntity vote = this.sysServiceI.get(VoteEntity.class,voteUserEntity1.getVoteId());
            Integer vNum = vote.getVoteNum();
            if(vNum!=null){
                vNum++;
            }else{
                vNum = 1;
            }

            for(String id:ids){
                VoteUserEntity voteUserEntity = new VoteUserEntity();
                voteUserEntity.setVoteId(voteUserEntity1.getVoteId());
                voteUserEntity.setViItem(id);
                voteUserEntity.setUserId(user.getId());
                List voteUsers = this.sysServiceI.findByExample(VoteUserEntity.class.getName(), voteUserEntity);

                Date date = new Date();
                voteUserEntity.setCreateTime(date);
                voteUserEntity.setUpdateTime(date);
                voteUserEntity.setViTime(date);
                voteUserEntity.setIsDelete(0);
                voteUserEntity.setViNum(vNum);

                VoteItemEntity voteItem = this.sysServiceI.get(VoteItemEntity.class,id);

                Integer voteNum = voteItem.getItemNum();
                if(voteNum!=null){
                    voteNum++;
                }else{
                    voteNum = 1;
                }
                voteItem.setItemNum(voteNum);

                this.sysServiceI.saveOrUpdate(voteItem);
                this.sysServiceI.saveOrUpdate(voteUserEntity);
            }

                vote.setVoteNum(vNum);
            Integer voteItemCount = ids.length;
            Integer oldVoteItemCount =vote.getVoteCount();
            Integer newVoteItemCount;
            if(oldVoteItemCount!=null){
                newVoteItemCount = oldVoteItemCount + voteItemCount;
            }else {
                newVoteItemCount = voteItemCount;
            }
            vote.setVoteCount(newVoteItemCount);
            this.sysServiceI.saveOrUpdate(vote);

            if(vote.getMaxAccountCount()!=null&&vote.getMaxAccountCount()!=""){
                //赠送鸿鑫币
                Integer hxiMoney = Integer.parseInt(vote.getMaxAccountCount());
                DxsAccountEntity accountEntity = this.sysServiceI.findByProperty(DxsAccountEntity.class,"userId",user.getId()).get(0);
                Integer newMoney = accountEntity.getAccount()+hxiMoney;
                accountEntity.setAccount(newMoney);
                this.sysServiceI.saveOrUpdate(accountEntity);

                //账户流水
                DxsAccountLogEntity accountLogEntity = new DxsAccountLogEntity();
                accountLogEntity.setIsDelete(0);
                accountLogEntity.setAccountFrom(0);
                accountLogEntity.setAccountIn(hxiMoney.toString());
                accountLogEntity.setAccountStatus(0);
                Date date = new Date();
                accountLogEntity.setCreateTime(date);
                accountLogEntity.setUpdateTime(date);
                accountLogEntity.setUserId(user.getId());
                this.sysServiceI.saveOrUpdate(accountLogEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败!";
        }
        ajaxJson.setMsg(message);
        ajaxJson.setSuccess(success);

        return ajaxJson;
    }

    @RequestMapping("/myVote")
    @ResponseBody
    public ReplyDataMode myVote(VoteEntity voteEntity, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        String sql ="SELECT user_id,vote_id,vi_time from dxs_vote_user WHERE user_id='" +
                     user.getId() +
                    "' and is_delete =0  GROUP BY vote_id";
        List userVotes = this.sysServiceI.findListbySql(sql);
        List resultData = new ArrayList();
        for (Object o:userVotes) {
            Map<String,String> voteUsers = new HashMap<>();
            Object[] object = (Object[]) o;
            Date voteDate = (Date) object[2];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(voteDate);
            String voteId = (String) object[1];
            VoteEntity vote = this.sysServiceI.get(VoteEntity.class,voteId);
            voteUsers.put("voteName",vote.getVoteTitle());
            voteUsers.put("hxiMoney",vote.getMaxAccountCount());
            voteUsers.put("voteDate",dateString);
            resultData.add(voteUsers);
        }
        replyDataMode.setData(resultData);
        replyDataMode.setSuccess(true);
        replyDataMode.setStatusCode("200");
        return replyDataMode;
    }
    @RequestMapping("/pageList")
    @ResponseBody
    public ReplyDataMode pageList(VoteEntity voteEntity, VoteUserSearchForm searchForm, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        PageMode mode = new PageMode();
        int total = 0;
        int pageNo = 0;
        int pageSize = 0;

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        StringBuffer sb_limit = new StringBuffer();
        if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
            pageNo = Integer.parseInt(searchForm.getPageNo());
            pageSize = Integer.parseInt(searchForm.getPageSize());
            sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );
        }

        String sql ="SELECT vu.user_id,vu.vote_id,vu.vi_time,v.remarks from dxs_vote_user vu,dxs_vote v WHERE vu.user_id='" +
                user.getId() +
                "' and vu.is_delete =0 and v.is_delete = 0 and vu.vote_id = v.id  GROUP BY vu.vote_id"+ sb_limit.toString();
        String sql_count ="SELECT vu.id from dxs_vote_user vu,dxs_vote v WHERE vu.user_id='" +
                user.getId() +
                "' and vu.is_delete =0 and v.is_delete = 0 and vu.vote_id = v.id  GROUP BY vu.vote_id";
        List userVotes = this.sysServiceI.findListbySql(sql);
        List count = this.sysServiceI.findListbySql(sql_count);
        List resultData = new ArrayList();
        for (Object o:userVotes) {
            Map<String,String> voteUsers = new HashMap<>();
            Object[] object = (Object[]) o;
            Date voteDate = (Date) object[2];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(voteDate);
            String voteId = (String) object[1];
            String remarks = (String) object[3];
            VoteEntity vote = this.sysServiceI.get(VoteEntity.class,voteId);
            voteUsers.put("voteName",vote.getVoteTitle());
            voteUsers.put("hxiMoney",vote.getMaxAccountCount());
            voteUsers.put("voteDate",dateString);
            voteUsers.put("remarks",remarks);
            voteUsers.put("id",voteId);
            resultData.add(voteUsers);
        }
        mode.setTotal(count.size());


        final int allCounts;
        if (mode.getTotal() != 0) {
            allCounts = mode.getTotal();
        } else {
            allCounts = 0;
        }
        int pageCount = 0;
        if (pageNo!=0 && pageSize!=0) {
            if(allCounts%pageSize!=0){
                pageCount = allCounts/pageSize + 1;
            }else {
                pageCount = allCounts/pageSize;
            }

        }
        mode.setPageCount(pageCount);
        mode.setPageNo(pageNo);
        mode.setPageSize(pageSize);
        mode.setResult(resultData);

        replyDataMode.setData(mode);
        replyDataMode.setSuccess(true);
        replyDataMode.setStatusCode("200");
        return replyDataMode;
    }
}
