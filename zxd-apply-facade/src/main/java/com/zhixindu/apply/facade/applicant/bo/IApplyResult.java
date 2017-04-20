package com.zhixindu.apply.facade.applicant.bo;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public interface IApplyResult {

    /**
     * 是否低信用
     * 审核不通过是否在一个月内
     * 没有数据返回false
     * @return
     */
    boolean isLowCredit();

}
