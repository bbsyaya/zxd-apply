package com.zhixindu.apply.facade.lender.business;

import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderVerifyBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyLenderWechatBusiness {

    /**
     * 根据客户ID查找借款信息
     * @param customerId
     * @return
     */
    LenderBO findLender(String customerId);

    /**
     * 申请借款
     * @param lenderBaseInfoBO
     * @return
     */
    LenderInfoBO applyLoan(LenderBaseInfoBO lenderBaseInfoBO);

    /**
     * 根据lenderId查找借款人联系人信息
     * @param lenderId
     * @return
     */
    List<LenderContactBO> findLenderContact(Integer lenderId);

    /**
     * 根据借款人ID查找借款验证信息
     * @param lenderId
     * @return
     */
    LenderVerifyBO findLenderVerify(Integer lenderId);

    /**
     * 根据借款人ID查找银行卡信息
     * @param lenderId
     * @return
     */
    LenderBankCardBO findLenderBankCard(Integer lenderId);

    /**
     * 根据借款人ID查找手机信息
     * @param lenderId
     * @return
     */
    MobileVerifyBO findLenderMobileVerify(Integer lenderId);

    /**
     * 提交借款人地址信息
     * @param lenderAddressBO
     * @return
     */
    Integer submitLenderAddress(LenderAddressBO lenderAddressBO);

    /**
     * 提交借款人联系人信息
     * @param lenderContactBOList
     * @return
     */
    List<Integer> submitLenderContact(List<LenderContactBO> lenderContactBOList);

    /**
     * 提交借款人银行卡信息
     * @param lenderBankCardBO
     * @return
     */
    Integer submitLenderBankCard(LenderBankCardBO lenderBankCardBO);

    /**
     * 提交手机号码验证
     * @param mobileVerifyBO
     * @return
     */
    boolean submitLenderMobileVerify(MobileVerifyBO mobileVerifyBO);

    /**
     * 提交信用情况
     * @param applyResultBO
     * @return
     */
    boolean submitApplyResult(ApplyResultBO applyResultBO);

    /**
     * 查找银行卡号
     * @param lenderId
     * @return
     */
    String findBankCardNumber(Integer lenderId);

}
