/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.workflow.enums.ProcessingState;
import com.zhixindu.apply.facade.workflow.enums.StepDefinition;

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
    private Integer step_definition_id;
    /**处理状态（0失败、1成功、2中）**/
    private Integer processing_state;
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
        return StepDefinition.resolve(this.step_definition_id).getDesc()+ ProcessingState.resolve(this.processing_state).getDesc();
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

    public Integer getStep_definition_id() {
        return step_definition_id;
    }

    public void setStep_definition_id(Integer step_definition_id) {
        this.step_definition_id = step_definition_id;
    }

    public Integer getProcessing_state() {
        return processing_state;
    }

    public void setProcessing_state(Integer processing_state) {
        this.processing_state = processing_state;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
