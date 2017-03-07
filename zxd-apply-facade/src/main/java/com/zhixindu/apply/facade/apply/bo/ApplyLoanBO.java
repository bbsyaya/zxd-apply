package com.zhixindu.apply.facade.apply.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyLoanBO implements Serializable {

    private static final long serialVersionUID = 6811852626457403898L;

    /**
     * 申请贷款ID
     */
    private Integer apply_id;
    /**
     * 申请时间
     */
    private String apply_time;
    /**
     * 借款金额
     */
    private BigDecimal loan_amount;
    /**
     * 到账金额
     */
    private BigDecimal account_amount;
    /**
     * 申请状态
     */
    private String apply_state;


}
