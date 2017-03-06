package com.zhixindu.apply.facade.lender.business;

import com.zhixindu.apply.facade.lender.bo.wechat.Lender;
import com.zhixindu.apply.facade.lender.bo.wechat.Address;
import com.zhixindu.apply.facade.lender.bo.wechat.BankCard;
import com.zhixindu.apply.facade.lender.bo.wechat.Contact;
import com.zhixindu.apply.facade.lender.bo.wechat.LenderInfo;
import com.zhixindu.apply.facade.lender.bo.wechat.MobileVerify;
import com.zhixindu.apply.facade.lender.bo.wechat.VerifyInfo;

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
     * 根据customerId查找借款人信息
     * @param customerId
     * @return
     */
    LenderInfo findLenderInfo(String customerId);

    /**
     * 根据lenderId查找借款人联系人信息
     * @param lenderId
     * @return
     */
    List<Contact> findLenderContact(int lenderId);

    /**
     * 根据借款人ID查找借款验证信息
     * @param lenderId
     * @return
     */
    VerifyInfo findLenderVerify(int lenderId);

    /**
     * 保存借款人关键信息
     * @param lender
     * @return
     */
    int saveLender(Lender lender);

    /**
     * 提交借款人地址信息
     * @param address
     * @return
     */
    int submitLenderAddress(Address address);

    /**
     * 提交借款人联系人信息
     * @param contactList
     * @return
     */
    int submitLenderContact(List<Contact> contactList);

    /**
     * 提交借款人银行卡信息
     * @param bankCard
     * @return
     */
    int submitLenderBankCard(BankCard bankCard);

    /**
     * 提交手机号码验证
     * @param mobileVerify
     * @return
     */
    int submitMobileVerify(MobileVerify mobileVerify);

}
