package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.TermUnit;
import com.zhixindu.commons.api.utils.MaskUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public class ApplyBaseInfoBO implements Serializable {
    private static final long serialVersionUID = -8520843938618323270L;
    /** 申请ID */
    private Integer apply_id;
    /** 申请人ID */
    private Integer applicant_id;
    /** 客户ID */
    private String customer_id;
    /** 微信ID */
    private String open_id;
    /** 产品ID */
    private String product_id;
    /** 申请编号 */
    private String apply_no;
    /** 借款金额 */
    private BigDecimal loan_amount;
    /** 借款期限 */
    private Integer loan_term;
    /** 期限单位 */
    private TermUnit term_unit;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public TermUnit getTerm_unit() {
        return term_unit;
    }

    public void setTerm_unit(TermUnit term_unit) {
        this.term_unit = term_unit;
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

    public String getMaskReiptCardNumber(){
        return MaskUtil.maskBankCard(getReceipt_card_number());
    }

}
