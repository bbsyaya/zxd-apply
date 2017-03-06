package com.zhixindu.apply.core.lender.business;

import com.zhixindu.apply.facade.lender.bo.wechat.Address;
import com.zhixindu.apply.facade.lender.bo.wechat.BankCard;
import com.zhixindu.apply.facade.lender.bo.wechat.Contact;
import com.zhixindu.apply.facade.lender.bo.wechat.Lender;
import com.zhixindu.apply.facade.lender.bo.wechat.LenderInfo;
import com.zhixindu.apply.facade.lender.bo.wechat.MobileVerify;
import com.zhixindu.apply.facade.lender.bo.wechat.VerifyInfo;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public class LenderWechatBusinessImpl implements DubboApplyLenderWechatBusiness {

    @Override
    public boolean checkCreditSituation(String customerId) {
        return false;
    }

    @Override
    public LenderInfo findLenderInfo(String customerId) {
        return null;
    }

    @Override
    public List<Contact> findLenderContact(int lenderId) {
        return null;
    }

    @Override
    public VerifyInfo findLenderVerify(int lenderId) {
        return null;
    }

    @Override
    public int saveLender(Lender lender) {
        return 0;
    }

    @Override
    public int submitLenderAddress(Address address) {
        return 0;
    }

    @Override
    public int submitLenderContact(List<Contact> contactList) {
        return 0;
    }

    @Override
    public int submitLenderBankCard(BankCard bankCard) {
        return 0;
    }

    @Override
    public int submitMobileVerify(MobileVerify mobileVerify) {
        return 0;
    }
}
