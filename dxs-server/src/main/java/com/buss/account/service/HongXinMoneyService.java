package com.buss.account.service;

import com.buss.account.entity.DxsAccountEntity;
import com.buss.account.entity.DxsAccountLogEntity;
import com.buss.common.service.SysServiceI;
import org.hibernate.envers.AuditTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/6/23.
 */
@Service
//@Tran
public class HongXinMoneyService {

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 账户操作表
     * @param accountId 账号
     * @param userid    用户表
     * @param accountIn 进账数目
     * @param accountout    出账数目
     * @param accountFrom   来源
     * @param accountStatus 状态
     * @throws Exception
     */
    public void seetMoney(String accountId, String userid, String accountIn, String accountout, int accountFrom, int accountStatus) throws Exception {

        // 保存流水
        DxsAccountLogEntity accountLogEntity = new DxsAccountLogEntity();
        accountLogEntity.setAccoutId(accountId);
        accountLogEntity.setUserId(userid);
        accountLogEntity.setAccountIn(accountIn);
        accountLogEntity.setAccountOut(accountout);
        accountLogEntity.setAccountFrom(accountFrom);
        accountLogEntity.setAccountStatus(accountStatus);
        Date date = new Date();
        accountLogEntity.setCreateTime(date);
        accountLogEntity.setUpdateTime(date);
        accountLogEntity.setIsDelete(0);

        if (accountStatus == 0) {
            this.sysServiceI.saveOrUpdate(accountLogEntity);
            accountLogEntity = (DxsAccountLogEntity) this.sysServiceI.findByExample(DxsAccountLogEntity.class.getName(), accountLogEntity).get(0);

            // 查询账户
            DxsAccountEntity accountEntity = this.sysServiceI.findUniqueByProperty(DxsAccountEntity.class, "userId", userid);
            if (accountEntity == null) {
                // 设置默认账户
                accountEntity = new DxsAccountEntity();
                accountEntity.setUserId(userid);
                accountEntity.setAccount(0);
//                accountEntity.setUserType(0);// userType 预留
                accountEntity.setAccountStatus(0);
                /* add by wupan on 20160707 start */
                accountEntity.setCreateTime(date);
                accountEntity.setIsDelete(0);
                /* add by wupan on 20160707 end */
            }

            // 账号异常
            if (accountEntity.getAccountStatus() != 0) {
                throw new Exception("账号异常!");
            }

            // 进账
            if (accountIn!=null && !accountIn.equals("")) {
                int account = accountEntity.getAccount();
                int accountadd = Integer.parseInt(accountIn);
                accountEntity.setAccount(account + accountadd);
            }
            // 出账
            if (accountout !=null && !accountout.equals("")) {
                int account = accountEntity.getAccount();
                int accountLea = Integer.parseInt(accountout);
                int accountnow = account - accountLea;
                if (accountnow < 0) {
                    throw new Exception("账目信息有误");
                }
                accountEntity.setAccount(accountnow);
            }

            this.sysServiceI.saveOrUpdate(accountEntity);
        }
    }

    /**
     * 入账
     * @param userid
     * @param accountIn
     * @throws Exception
     */
    public void comeMoney(String userid, String accountIn) throws Exception {
        this.seetMoney(null,userid, accountIn, null, 0, 0);
    }

    /**
     *  出账
     * @param userid
     * @param accountTo
     * @throws Exception
     */
    public  void goMoney(String userid, String accountTo) throws Exception {
        this.seetMoney(null,userid, null, accountTo, 0, 0);
    }
    /**
     * 转账
     */

    public void a() {

    }

}
