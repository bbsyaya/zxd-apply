package com.zhixindu.apply.core.apply.po;

import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;

import java.util.Date;

/**
 * Created by SteveGuo on 2017/4/1.
 */
public class ApplyAddressPO extends ApplyAddressBO {

    /** 创建时间 */
    private Date create_time;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
