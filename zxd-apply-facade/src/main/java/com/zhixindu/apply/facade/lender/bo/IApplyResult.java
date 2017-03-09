package com.zhixindu.apply.facade.lender.bo;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public interface IApplyResult {

    /**
     * 贷款申请是否通过
     * @return
     */
    default boolean isApplicationApproved(){
        return false;
    }

}
