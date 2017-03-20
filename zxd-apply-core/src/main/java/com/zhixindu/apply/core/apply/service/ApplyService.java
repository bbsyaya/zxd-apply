package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public interface ApplyService {

    /**
     * 保存申请贷款
     * @param applyBaseInfoBO
     * @return
     */
    Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO);

    /**
     * 更新申请信用结果
     * @param applyCreditBO
     * @return
     */
    int updateApplyCredit(ApplyCreditBO applyCreditBO);

    /**
     * 更新借款状态
     * @param applyStatusBO
     * @return
     */
    int updateLoanStatus(ApplyStatusBO applyStatusBO);

    /**
     * 更新还款状态
     * @param applyId
     * @return
     */
    int updateRepaymentStatus(Integer applyId);

}
