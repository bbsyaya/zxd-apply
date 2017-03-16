package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.commons.page.PageParam;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/7.
 */
public class ApplyPageParam implements Serializable,PageParam {

    private static final long serialVersionUID = -2090091064124790704L;
    /** 客户ID */
    private String customerId;
    /**页数**/
    private int page = 0;
    /**每页大小**/
    private int count = 10;

    public ApplyPageParam() {
    }

    public ApplyPageParam(int page, int count) {
        this.page = page;
        this.count = count;
    }

    public ApplyPageParam(String customerId, int page, int count) {
        this.customerId = customerId;
        this.page = page;
        this.count = count;
    }

    @Override
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
