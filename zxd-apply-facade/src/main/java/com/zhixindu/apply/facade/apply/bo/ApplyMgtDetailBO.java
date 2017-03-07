/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yulei
 * @version 1.0
 * @date 2017/3/7
 * @description
 */
public class ApplyMgtDetailBO implements Serializable {
    private static final long serialVersionUID = 2840701069750299567L;
    /**申请ID**/
    private String apply_id;
    /**申请人ID**/
    private String lender_id;
    /**用户手机号**/
    private String mobile;
    /**用户姓名**/
    private String name;
    /**用户身份证号**/
    private String id_card;
    /**步骤 1提交申请，2审核，3放款**/
    private Integer process_step;
    /**处理状态（0失败、1成功、2中）**/
    private Integer process_state;
    /**申请状态描述**/
    private String apply_status_desc;
    /**申请时间**/
    private Date start_time;


    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getApply_status_desc() {
        return ProcessStep.resolve(this.process_step).getDesc()+ ProcessState.resolve(this.process_state).getDesc();
    }

    public void setApply_status_desc(String apply_status_desc) {
        this.apply_status_desc = apply_status_desc;
    }

    public String getLender_id() {
        return lender_id;
    }

    public void setLender_id(String lender_id) {
        this.lender_id = lender_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Integer getProcess_step() {
        return process_step;
    }

    public void setProcess_step(Integer process_step) {
        this.process_step = process_step;
    }

    public Integer getProcess_state() {
        return process_state;
    }

    public void setProcess_state(Integer process_state) {
        this.process_state = process_state;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
