package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.bo.IBankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class ApplyBankCardVerifyBO implements IBankCardVerify, Serializable {
    private static final long serialVersionUID = -8829720976239552424L;

    /** 申请人ID */
    private Integer applicant_id;
    /** 银行卡验证 */
    private BankCardVerify bank_card_verify;

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    @Override
    public boolean isBankCardVerified() {
        return BankCardVerify.VERIFIED.matches(getBank_card_verify());
    }
}
