package com.zhixindu.apply.core.system.enums;

/**
 * 银行卡BIN长度枚举类
 * Created by SteveGuo on 2017/3/8.
 */
public enum BinLength {

    SIX(6), FIVE(5), SEVEN(7), EIGHT(8), FOUR(4), THREE(3);

    private Integer value;

    BinLength(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
