package com.zhixindu.apply.core.constant;

/**
 * Created by SteveGuo on 2017/3/21.
 */
public enum ApplyErrorCode {

    MOBILE_NOT_VERIFIED(2001, "手机号未通过验证"), BANK_CARD_NOT_VERIFIED(2002, "银行卡号未通过验证"),
    HAS_NOT_SETTLED_APPLY(2003, "有未结清贷款申请");

    private int errorCode;
    private String desc;

    ApplyErrorCode(int errorCode, String desc) {
        this.errorCode = errorCode;
        this.desc = desc;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDesc() {
        return desc;
    }
}
