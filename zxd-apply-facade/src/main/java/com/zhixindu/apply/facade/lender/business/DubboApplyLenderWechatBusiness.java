package com.zhixindu.apply.facade.lender.business;

import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileBO;
import com.zhixindu.apply.facade.lender.bo.VerifyInfoBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyLenderWechatBusiness {

    /**
     * 检查借款人信用情况
     * @param customerId
     * @return
     */
    boolean checkCreditSituation(String customerId);

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
    List<ContactBO> findLenderContact(int lenderId);

    /**
     * 根据借款人ID查找借款验证信息
     * @param lenderId
     * @return
     */
    VerifyInfoBO findLenderVerify(int lenderId);

    /**
     * 根据借款人ID查找银行卡信息
     * @param lenderId
     * @return
     */
    BankCardBO findBankCard(int lenderId);

    /**
     * 根据借款人ID查找手机信息
     * @param lenderId
     * @return
     */
    MobileBO findMobileInfo(int lenderId);

    /**
     * 提交借款人地址信息
     * @param addressBO
     * @return
     */
    int submitLenderAddress(AddressBO addressBO);

    /**
     * 提交借款人联系人信息
     * @param contactBOList
     * @return
     */
    int submitLenderContact(List<ContactBO> contactBOList);

    /**
     * 提交借款人银行卡信息
     * @param bankCardBO
     * @return
     */
    int submitLenderBankCard(BankCardBO bankCardBO);

    /**
     * 提交手机号码验证
     * @param mobileBO
     * @return
     */
    int submitMobile(MobileBO mobileBO);

    /**
     * 提交信用情况
     * @param lenderId
     * @param creditSituation
     * @return
     */
    int submitCreditSituation(Integer lenderId, String creditSituation);

    /**
     * 查找银行卡号
     * @param lenderId
     * @return
     */
    String findBankCardNumber(Integer lenderId);

}
