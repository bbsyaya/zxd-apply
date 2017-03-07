package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyLoanDetailBO extends ApplyLoanBO implements Serializable {

    private static final long serialVersionUID = -7273647920992356043L;

    /**
     * 申请编号
     */
    private String apply_no;
    /**
     * 借款期限
     */
    private int loan_term;
    /**
     * 到期还款
     */
    private BigDecimal repayment_amount;
    /**
     * 扣除费用
     */
    private BigDecimal total_fee;
    /**
     * 收款卡号
     */
    private String receipt_card_number;

    /**
     * 申请借款流程步骤列表
     */
    private List<ApplyLoanStepBO> applyLoanStepBOList;

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
    }

    public int getLoan_term() {
        return loan_term;
    }

    public void setLoan_term(int loan_term) {
        this.loan_term = loan_term;
    }

    public BigDecimal getRepayment_amount() {
        return repayment_amount;
    }

    public void setRepayment_amount(BigDecimal repayment_amount) {
        this.repayment_amount = repayment_amount;
    }

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

    public String getReceipt_card_number() {
        return receipt_card_number;
    }

    public void setReceipt_card_number(String receipt_card_number) {
        this.receipt_card_number = receipt_card_number;
    }

    public List<ApplyLoanStepBO> getApplyLoanStepBOList() {
        return applyLoanStepBOList;
    }

    public void setApplyLoanStepBOList(List<ApplyLoanStepBO> applyLoanStepBOList) {
        this.applyLoanStepBOList = applyLoanStepBOList;
    }
}
