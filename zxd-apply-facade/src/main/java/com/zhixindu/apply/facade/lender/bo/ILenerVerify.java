package com.zhixindu.apply.facade.lender.bo;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public interface ILenerVerify {

    /**
     * 手机号是否验证
     * 当手机验证没有数据的时候返回的是true
     * @return
     */
    default boolean isMobileVerify() {
        return false;
    }

    /**
     * 银行卡是否验证
     * 当银行卡验证没有数据的时候返回的是true
     * @return
     */
    default boolean isBankCardVerify() {
        return false;
    }

}
