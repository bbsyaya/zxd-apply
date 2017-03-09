package com.zhixindu.apply.facade.lender.bo;

/**
 * Created by SteveGuo on 2017/3/9.
 */
public interface LenerVerify {

    /**
     * 手机号是否验证
     * @return
     */
    default boolean isMobileVerify() {
        return false;
    }

    /**
     * 银行卡是否验证
     * @return
     */
    default boolean isBankCardVerify() {
        return false;
    }

}
