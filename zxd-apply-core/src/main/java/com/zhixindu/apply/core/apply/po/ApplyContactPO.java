package com.zhixindu.apply.core.apply.po;

import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;

import java.util.Date;

/**
 * Created by SteveGuo on 2017/4/1.
 */
public class ApplyContactPO extends ApplyContactBO {

    /** 创建时间 */
    private Date create_time;
    /** 更新时间 */
    private Date update_time;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
