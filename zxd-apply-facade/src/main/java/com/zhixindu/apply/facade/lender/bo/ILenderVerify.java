package com.zhixindu.apply.facade.lender.bo;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public interface ILenderVerify extends IMobileVerify, IBankCardVerify{

    /**
     * 是否有没通过验证的内容
     * 当手机号验证和银行卡验证都没有数据的时候返回false
     * @return
     */
    boolean hasNotVerifiedItem();

    @Override
    default boolean isMobileVerified() {
        return false;
    }

    @Override
    default boolean isBankCardVerified() {
        return false;
    }
}
