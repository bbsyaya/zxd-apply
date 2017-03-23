package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.BankCardVerify;
import com.zhixindu.apply.facade.lender.enums.MobileVerify;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class LenderVerifyBO implements ILenderVerify, Serializable {
    private static final long serialVersionUID = -1089420756323886726L;

    /** 借款人ID */
    private Integer lender_id;
    /** 手机号验证 */
    private MobileVerify mobile_verify;
    /** 银行卡验证 */
    private BankCardVerify bank_card_verify;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public MobileVerify getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(MobileVerify mobile_verify) {
        this.mobile_verify = mobile_verify;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    @Override
    public boolean hasNotVerifiedItem() {
        return (null != getMobile_verify() && !isMobileVerified())
                || (null != getBank_card_verify() && !isBankCardVerified());
    }

    @Override
    public boolean isMobileVerified() {
        return MobileVerify.VERIFIED.matches(getMobile_verify());
    }

    @Override
    public boolean isBankCardVerified() {
        return BankCardVerify.VERIFIED.matches(getBank_card_verify());
    }
}
