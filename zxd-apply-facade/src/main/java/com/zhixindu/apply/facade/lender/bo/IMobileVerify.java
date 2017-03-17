package com.zhixindu.apply.facade.lender.bo;

/**
 * Created by SteveGuo on 2017/3/14.
 */
public interface IMobileVerify {

    /**
     * 手机号是否验证
     * 当手机验证没有数据的时候返回的是false
     * @return
     */
    boolean isMobileVerified();

}
