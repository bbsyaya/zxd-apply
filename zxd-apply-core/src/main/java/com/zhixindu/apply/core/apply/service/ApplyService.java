package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public interface ApplyService {

    int saveApplyLoan(ApplyBO applyBO);

    String getLatestApplyStatus(Integer applyId);

}
