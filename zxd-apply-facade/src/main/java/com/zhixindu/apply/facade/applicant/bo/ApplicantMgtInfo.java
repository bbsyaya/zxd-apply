/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.MobileVerify;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class ApplicantMgtInfo implements Serializable {

    private static final long serialVersionUID = -8507298900725978088L;

    /**
     * 申请人ID
     */
    private Integer applicant_id;
    /**
     * 客户ID
     */
    private String customer_id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String id_card;
    /**
     * 手机号认证信息（0未验证，1已验证）
     */
    private MobileVerify mobile_verify;
    /**
     * 银行卡认证信息（0未验证，1已验证）
     */
    private BankCardVerify bank_card_verify;
    /**
     * 地址
     */
    private ApplyAddressMgtBO applyAddressMgtBO;
    /**
     * 联系人
     */
    private List<ApplyContactBO> applyContactBOS;
    /**
     * 银行卡
     */
    private ApplyBankCardBO applyBankCardBO;

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public ApplyAddressMgtBO getApplyAddressMgtBO() {
        return applyAddressMgtBO;
    }

    public void setApplyAddressMgtBO(ApplyAddressMgtBO applyAddressMgtBO) {
        this.applyAddressMgtBO = applyAddressMgtBO;
    }

    public List<ApplyContactBO> getApplyContactBOS() {
        return applyContactBOS;
    }

    public void setApplyContactBOS(List<ApplyContactBO> applyContactBOS) {
        this.applyContactBOS = applyContactBOS;
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

    public ApplyBankCardBO getApplyBankCardBO() {
        return applyBankCardBO;
    }

    public void setApplyBankCardBO(ApplyBankCardBO applyBankCardBO) {
        this.applyBankCardBO = applyBankCardBO;
    }
}
