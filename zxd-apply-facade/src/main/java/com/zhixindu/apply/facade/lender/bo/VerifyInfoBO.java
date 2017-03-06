package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class VerifyInfoBO implements Serializable {
    private static final long serialVersionUID = -1089420756323886726L;

    /** 借款人ID */
    private Integer lender_id;
    /** 银行卡验证 */
    private boolean bank_card_verify;
    /** 手机号验证 */
    private boolean mobile_verify;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public boolean isBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(boolean bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public boolean isMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(boolean mobile_verify) {
        this.mobile_verify = mobile_verify;
    }

}
