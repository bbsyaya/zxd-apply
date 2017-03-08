package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.ApplyResult;
import com.zhixindu.apply.facade.lender.enums.BankCardVerify;
import com.zhixindu.apply.facade.lender.enums.MobileVerify;

import java.io.Serializable;

public class LenderBO extends LenderBaseInfoBO implements Serializable {

    private static final long serialVersionUID = -1373173161346766532L;

    /** 借款人ID */
    private Integer lender_id;
    /** 手机服务密码 */
    private String service_password;
    /** 手机号验证 */
    private MobileVerify mobile_verify;
    /** 银行卡验证 */
    private BankCardVerify bank_card_verify;
    /** 申请结果 */
    private ApplyResult apply_result;
    /** 信用评分 */
    private Integer credit_score;

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

    public ApplyResult getApply_result() {
        return apply_result;
    }

    public void setApply_result(ApplyResult apply_result) {
        this.apply_result = apply_result;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }
}