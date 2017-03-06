package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.BankCardVerify;
import com.zhixindu.apply.facade.lender.enums.MobileVerify;

import java.io.Serializable;

public class LenderBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = -1373173161346766532L;

    private Integer lender_id;

    private String service_password;

    private MobileVerify mobile_verify;

    private BankCardVerify bank_card_verify;

    private String credit_situation;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getService_password() {
        return service_password;
    }

    public void setService_password(String service_password) {
        this.service_password = service_password == null ? null : service_password.trim();
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

    public String getCredit_situation() {
        return credit_situation;
    }

    public void setCredit_situation(String credit_situation) {
        this.credit_situation = credit_situation == null ? null : credit_situation.trim();
    }
}