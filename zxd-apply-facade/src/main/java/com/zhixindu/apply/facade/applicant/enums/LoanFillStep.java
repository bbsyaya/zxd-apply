package com.zhixindu.apply.facade.applicant.enums;


import com.zhixindu.commons.api.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public enum LoanFillStep implements IEnum<Integer> {
    BASIC_INFO(1, "基本信息"), CONTACT_INFO(2, "联系人信息"), CERTIFICATION_INFO(3, "认证信息"),
    SUBMIT(4, "提交申请"), COMPLETE(5, "完成申请");

    private int value;
    private String desc;

    LoanFillStep(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public boolean matches(Integer value) {
        if(null == value) {
            return false;
        }
        return getValue().intValue() == value.intValue();
    }

    @Override
    public boolean matches(IEnum<Integer> valueBean) {
        if(null == valueBean) {
            return false;
        }
        return matches(valueBean.getValue());
    }

    private static Map<Integer, LoanFillStep> mappings = new HashMap<>();
    static {
        for (LoanFillStep loanFillStep : LoanFillStep.values()) {
            mappings.put(loanFillStep.getValue(), loanFillStep);
        }
    }

    public static LoanFillStep resolve(Integer loanFillStep) {
        return mappings.get(loanFillStep);
    }
}
