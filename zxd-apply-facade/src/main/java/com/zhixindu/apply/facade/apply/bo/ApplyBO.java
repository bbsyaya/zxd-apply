package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ApplyBO implements Serializable {

    private static final long serialVersionUID = 2181984961531019781L;
    /** 申请借款ID */
    private Integer apply_id;
    /** 借款人ID */
    private Integer lender_id;
    /** 客户ID */
    private String customer_id;
    /** 地址ID */
    private Integer address_id;
    /** 联系人ID列表 */
    private String contact_id_list;
    /** 银行卡ID列表 */
    private String bank_card_id_list;
    /** 申请编号 */
    private String apply_no;
    /** 借款金额 */
    private BigDecimal loan_amount;
    /** 借款期限 */
    private Integer loan_term;
    /** 日利率 */
    private Integer interest_rate;
    /** 借款利息 */
    private BigDecimal loan_interest;
    /** 平台管理费 */
    private BigDecimal platform_manage_fee;
    /** 总费用 */
    private BigDecimal total_fee;
    /** 到期还款 */
    private BigDecimal repayment_amount;
    /** 到账金额 */
    private BigDecimal account_amount;
    /** 收款卡号 */
    private String receipt_card_number;

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id == null ? null : customer_id.trim();
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getContact_id_list() {
        return contact_id_list;
    }

    public void setContact_id_list(String contact_id_list) {
        this.contact_id_list = contact_id_list == null ? null : contact_id_list.trim();
    }

    public String getBank_card_id_list() {
        return bank_card_id_list;
    }

    public void setBank_card_id_list(String bank_card_id_list) {
        this.bank_card_id_list = bank_card_id_list == null ? null : bank_card_id_list.trim();
    }

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no == null ? null : apply_no.trim();
    }

    public BigDecimal getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(BigDecimal loan_amount) {
        this.loan_amount = loan_amount;
    }

    public Integer getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(Integer loan_term) {
        this.loan_term = loan_term;
    }

    public Integer getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Integer interest_rate) {
        this.interest_rate = interest_rate;
    }

    public BigDecimal getLoan_interest() {
        return loan_interest;
    }

    public void setLoan_interest(BigDecimal loan_interest) {
        this.loan_interest = loan_interest;
    }

    public BigDecimal getPlatform_manage_fee() {
        return platform_manage_fee;
    }

    public void setPlatform_manage_fee(BigDecimal platform_manage_fee) {
        this.platform_manage_fee = platform_manage_fee;
    }

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

    public BigDecimal getRepayment_amount() {
        return repayment_amount;
    }

    public void setRepayment_amount(BigDecimal repayment_amount) {
        this.repayment_amount = repayment_amount;
    }

    public BigDecimal getAccount_amount() {
        return account_amount;
    }

    public void setAccount_amount(BigDecimal account_amount) {
        this.account_amount = account_amount;
    }

    public String getReceipt_card_number() {
        return receipt_card_number;
    }

    public void setReceipt_card_number(String receipt_card_number) {
        this.receipt_card_number = receipt_card_number == null ? null : receipt_card_number.trim();
    }
}