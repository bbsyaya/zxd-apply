package com.zhixindu.apply.facade.applicant.bo;

/**
 * Created by SteveGuo on 2017/3/14.
 */
public interface IBankCardVerify {

    /**
     * 银行卡是否验证
     * 当银行卡验证没有数据的时候返回的是false
     * @return
     */
    boolean isBankCardVerified();

}
