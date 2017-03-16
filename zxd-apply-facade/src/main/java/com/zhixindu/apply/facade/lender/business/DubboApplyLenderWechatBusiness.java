package com.zhixindu.apply.facade.lender.business;

import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderVerifyBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyLenderWechatBusiness {

    /**
     * 根据客户ID查找借款人信息
     * @param lenderId
     * @return 借款人信息
     */
    LenderBO findLender(Integer lenderId);

    /**
     * 根据客户ID查找借款人信息
     * @param customerId
     * @return 借款人信息
     */
    LenderBO findLender(String customerId);

    /**
     * 申请借款
     * @param lenderBaseInfoBO
     * @return 借款人和借款人地址信息
     */
    LenderInfoBO applyLoan(LenderBaseInfoBO lenderBaseInfoBO);

    /**
     * 根据LenderId查找借款人地址信息
     * @param lenderId
     * @return 借款人地址信息
     */
    LenderAddressBO findLenderAddress(Integer lenderId);

    /**
     * 根据lenderId查找借款人联系人信息
     * @param lenderId
     * @return 借款人联系人列表
     */
    List<LenderContactBO> findLenderContact(Integer lenderId);

    /**
     * 根据借款人ID查找借款人验证信息
     * @param lenderId
     * @return 借款人验证信息
     */
    LenderVerifyBO findLenderVerify(Integer lenderId);

    /**
     * 根据借款人ID查找银行卡信息
     * @param lenderId
     * @return 借款人银行卡信息
     */
    LenderBankCardBO findLenderBankCard(Integer lenderId);

    /**
     * 根据借款人ID查找手机验证信息
     * @param lenderId
     * @return 借款人手机验证信息
     */
    LenderMobileVerifyBO findLenderMobileVerify(Integer lenderId);

    /**
     * 提交借款人地址信息
     * @param lenderAddressBO
     * @return 地址ID
     */
    Integer submitLenderAddress(LenderAddressBO lenderAddressBO);

    /**
     * 提交借款人联系人信息
     * @param lenderContactBOList
     * @return  联系人ID列表
     */
    List<Integer> submitLenderContact(List<LenderContactBO> lenderContactBOList);

    /**
     * 提交借款人银行卡信息
     * @param lenderBankCardBO
     * @return 银行卡ID
     */
    Integer submitLenderBankCard(LenderBankCardBO lenderBankCardBO);

    /**
     * 提交手机号码验证
     * @param lenderMobileVerifyBO
     * @return 是否成功
     */
    boolean submitLenderMobileVerify(LenderMobileVerifyBO lenderMobileVerifyBO);

    /**
     * 查找银行卡号
     * @param lenderId
     * @return 银行卡号
     */
    String findBankCardNumber(Integer lenderId);

    /**
     * 通过客户ID获取借款人ID
     * @param customerId
     * @return
     */
    Integer findLenderId(String customerId);

    /**
     * 通过借款人ID获取地址ID
     * @param lenderId
     * @return
     */
    Integer findAddressId(Integer lenderId);

    /**
     * 通过借款人ID获取联系人ID列表
     * @param lenderId
     * @return
     */
    List<Integer> findContactIdList(Integer lenderId);

    /**
     * 通过借款人ID获取银行卡ID
     * @param lenderId
     * @return
     */
    Integer findBankCardId(Integer lenderId);

}
