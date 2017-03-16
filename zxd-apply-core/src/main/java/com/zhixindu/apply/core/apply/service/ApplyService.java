package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public interface ApplyService {

    boolean hasUncompleteApply(Integer lenderId);

    Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO);

    int updateLoanStatus(ApplyStatusBO applyStatusBO);

    int updateApplyCredit(ApplyCreditBO applyCreditBO);

}
