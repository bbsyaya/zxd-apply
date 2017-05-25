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

    /**
     * 是否存在申请地址信息
     * @param applyId
     * @return
     */
    boolean existApplyAddress(Integer applyId);

    /**
     * 是否存在申请联系人信息
     * @param applyId
     * @return
     */
    boolean existApplyContact(Integer applyId);

    /**
     * 是否存在申请银行卡信息
     * @param applyId
     * @return
     */
    boolean existApplyBankCard(Integer applyId);

    /**
     * 保存或者更新地址信息
     * @param applyAddressBO
     * @return
     */
    Integer saveOrUpdateAddress(ApplyAddressBO applyAddressBO);

    /**
     * 保存或者更新联系人信息
     * @param applyContactBOList
     * @return
     */
    List<Integer> saveOrUpdateContact(List<ApplyContactBO> applyContactBOList);

    /**
     * 保存或者更新银行卡信息
     * @param applyBankCardBO
     * @return
     */
    Integer saveOrUpdateBankCard(ApplyBankCardBO applyBankCardBO);

    /**
     * 完成信用信用认证
     * @param applicantId
     * @return
     */
    boolean completeCertification(Integer applicantId);

    /**
     * 准备申请借款信息
     * @param applicantId
     * @param applyId
     * @return
     */
    boolean prepareApplyLoan(Integer applicantId, Integer applyId);

    /**
     * 准备申请地址信息
     * @param applicantId
     * @param applyId
     * @return
     */
    boolean prepareApplyAddress(Integer applicantId, Integer applyId);

    /**
     * 准备申请联系人信息
     * @param applicantId
     * @param applyId
     * @return
     */
    boolean prepareApplyContact(Integer applicantId, Integer applyId);

    /**
     * 准备申请银行卡信息
     * @param applicantId
     * @param applyId
     * @return
     */
    boolean prepareApplyBankCard(Integer applicantId, Integer applyId);

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
