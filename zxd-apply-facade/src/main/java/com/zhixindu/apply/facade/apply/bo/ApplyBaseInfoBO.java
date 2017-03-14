package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class ApplyBaseInfoBO implements Serializable {
    private static final long serialVersionUID = -8520843938618323270L;
    /** 申请借款ID */
    private Integer apply_id;
    /** 借款人ID */
    private Integer lender_id;
    /** 客户ID */
    private String customer_id;
    /** 微信ID */
    private String open_id;
    /** 地址ID */
    private Integer address_id;
    /** 联系人ID列表 */
    private String contact_id_list;
    /** 银行卡ID */
    private Integer bank_card_id;
    /** 申请编号 */
    private String apply_no;
    /** 借款金额 */
    private BigDecimal loan_amount;
    /** 借款期限 */
    private Integer loan_term;
    /** 总费用 */
    private BigDecimal total_fee;
    /** 到期还款 */
    private BigDecimal repayment_amount;
    /** 到账金额 */
    private BigDecimal account_amount;
    /** 收款卡号 */
    private String receipt_card_number;
    /** 地理位置纬度 */
    private BigDecimal latitude;
    /** 地理位置经度 */
    private BigDecimal longitude;
    /** 地理位置精度 */
    private BigDecimal precision;

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
        this.customer_id = customer_id;
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
        this.contact_id_list = contact_id_list;
    }

    public Integer getBank_card_id() {
        return bank_card_id;
    }

    public void setBank_card_id(Integer bank_card_id) {
        this.bank_card_id = bank_card_id;
    }

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
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
        this.receipt_card_number = receipt_card_number;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getPrecision() {
        return precision;
    }

    public void setPrecision(BigDecimal precision) {
        this.precision = precision;
    }

}
