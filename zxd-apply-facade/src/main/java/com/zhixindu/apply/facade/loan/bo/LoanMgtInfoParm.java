/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.loan.bo;

import com.zhixindu.commons.page.PageParam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/6
 * @description
 */
public class LoanMgtInfoParm implements Serializable,PageParam {

    private static final long serialVersionUID = 2481093266378962060L;
    /**用户手机号**/
    private String mobile;
    /**用户身份证号**/
    private String id_card;
    /**申请ID**/
    private String lender_id;
    /**状态 1审核中，2审核成功，3审核失败，4放款成功，5放款失败**/
    private Integer status;
    /**申请开始时间**/
    private Date lender_start_time;
    /**申请结束时间**/
    private Date lender_end_time;
    /**页数**/
    private int page = 0;
    /**每页大小**/
    private int count = 10;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getLender_id() {
        return lender_id;
    }

    public void setLender_id(String lender_id) {
        this.lender_id = lender_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLender_start_time() {
        return lender_start_time;
    }

    public void setLender_start_time(Date lender_start_time) {
        this.lender_start_time = lender_start_time;
    }

    public Date getLender_end_time() {
        return lender_end_time;
    }

    public void setLender_end_time(Date lender_end_time) {
        this.lender_end_time = lender_end_time;
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
