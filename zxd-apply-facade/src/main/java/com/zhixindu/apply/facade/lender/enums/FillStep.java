package com.zhixindu.apply.facade.lender.enums;

import com.zhixindu.commons.bean.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveGuo on 2017/3/10.
 */
public enum FillStep implements IEnum<Integer> {
    BASIC_INFO(1, "基本信息"), CONTACT_INFO(2, "联系人信息"), CERTIFICATION_INFO(3, "认证信息"),
    SUBMIT(4, "提交申请"), COMPLETE(5, "完成申请");

    private int value;
    private String desc;

    FillStep(int value, String desc) {
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

    private static Map<Integer, FillStep> mappings = new HashMap<>();
    static {
        for (FillStep fillStep : FillStep.values()) {
            mappings.put(fillStep.getValue(), fillStep);
        }
    }

    public static FillStep resolve(int fillStep) {
        return mappings.get(fillStep);
    }
}
