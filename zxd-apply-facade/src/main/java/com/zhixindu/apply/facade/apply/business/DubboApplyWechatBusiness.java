package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyWechatBusiness {

    boolean submitLoanApply(ApplyBO applyBO);

}
