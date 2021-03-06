package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.commons.api.utils.MaskUtil;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ApplyBankCardBO implements Serializable {
    private static final long serialVersionUID = -4569790136583162019L;
    /**
     * 银行卡ID
     */
    private Integer bank_card_id;
    /**
     * 申请ID
     */
    private Integer apply_id;
    /**
     * 申请人ID
     */
    private Integer applicant_id;
    @NotBlank(message = "银行卡编号不能为空")
    private String bank_card_number;
    @NotNull(message = "银行ID不能为空")
    private Integer bank_id;
    @NotBlank(message = "开户行不能为空")
    private String bank_name;
    @NotNull(message = "开户行地址行政区划代码不能为空")
    @Digits(integer = 6, fraction = 0, message = "开户行地址行政区划代码长度不是6位")
    private Integer bank_address_code;
    @NotBlank(message = "预留手机号不能为空")
    private String reserved_mobile;
    @NotNull(message = "银行卡验证不能为空")
    private BankCardVerify bank_card_verify;

    public Integer getBank_card_id() {
        return bank_card_id;
    }

    public void setBank_card_id(Integer bank_card_id) {
        this.bank_card_id = bank_card_id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number == null ? null : bank_card_number.trim();
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name == null ? null : bank_name.trim();
    }

    public Integer getBank_address_code() {
        return bank_address_code;
    }

    public void setBank_address_code(Integer bank_address_code) {
        this.bank_address_code = bank_address_code;
    }

    public String getReserved_mobile() {
        return reserved_mobile;
    }

    public void setReserved_mobile(String reserved_mobile) {
        this.reserved_mobile = reserved_mobile;
    }

    public BankCardVerify getBank_card_verify() {
        return bank_card_verify;
    }

    public void setBank_card_verify(BankCardVerify bank_card_verify) {
        this.bank_card_verify = bank_card_verify;
    }

    public String getMaskBankCardNumber() {
        return MaskUtil.maskBankCard(getBank_card_number());
    }
}