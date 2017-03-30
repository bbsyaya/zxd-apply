package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public interface ApplyService {

    /**
     * 开启借款申请
     * @param applicantId
     * @return
     */
    Integer startApplyLoan(Integer applicantId);

    boolean existApplicantAddress(Integer applyId);

    boolean existApplicantContact(Integer applyId);

    boolean existApplicantBankCard(Integer applyId);

    Integer saveOrUpdateAddress(ApplyAddressBO applyAddressBO);

    List<Integer> saveOrUpdateContact(List<ApplyContactBO> applyContactBOList);

    Integer saveOrUpdateBankCard(ApplyBankCardBO applyBankCardBO);

    /**
     * 保存申请贷款
     * @param applyBaseInfoBO
     * @return
     */
    Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO);

    /**
     * 更新申请信用结果
     * @param applyCreditBO
     * @return
     */
    int updateApplyCredit(ApplyCreditBO applyCreditBO);

    /**
     * 更新借款状态
     * @param applyStatusBO
     * @return
     */
    int updateLoanStatus(ApplyStatusBO applyStatusBO);

    /**
     * 更新还款状态
     * @param applyStatusBO
     * @return
     */
    int updateRepaymentStatus(ApplyStatusBO applyStatusBO);

}
