package com.zhixindu.apply.facade.apply.bo;

import com.zhixindu.apply.facade.applicant.enums.WorkState;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ApplyAddressBO implements Serializable {

    private static final long serialVersionUID = 2319732869984633192L;
    /** 地址ID */
    private Integer address_id;
    /** 申请ID */
    private Integer apply_id;
    /** 申请人ID */
    private Integer applicant_id;
    @NotNull(message = "居住地址行政区划代码不能为空")
    @Length(min = 6, max = 6, message = "居住地址行政区划代码长度不是6位")
    private Integer home_address_code;
    @NotNull(message = "居住详细地址不能为空")
    private String home_address;
    /** 工作状态 */
    private WorkState work_state;
    /** 公司名称 */
    private String company_name;
    /** 公司地址行政区划代码 */
    private Integer company_address_code;
    /** 公司详细地址 */
    private String company_address;
    @NotNull(message = "work_state_value不能为空")
    private Integer work_state_value;

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getApply_id() {
        return apply_id;
    }

    public void setApply_id(Integer apply_id) {
        this.apply_id = apply_id;
    }

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public Integer getHome_address_code() {
        return home_address_code;
    }

    public void setHome_address_code(Integer home_address_code) {
        this.home_address_code = home_address_code;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address == null ? null : home_address.trim();
    }
    @NotNull(message = "work_state不能为空")
    public WorkState getWork_state() {
        return work_state == null ? WorkState.resolve(work_state_value) : work_state;
    }

    public void setWork_state(WorkState work_state) {
        this.work_state = work_state;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    public Integer getCompany_address_code() {
        return company_address_code;
    }

    public void setCompany_address_code(Integer company_address_code) {
        this.company_address_code = company_address_code;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address == null ? null : company_address.trim();
    }

    public Integer getWork_state_value() {
        return work_state_value == null && work_state != null ? work_state.getValue() : work_state_value;
    }

    public void setWork_state_value(Integer work_state_value) {
        this.work_state_value = work_state_value;
    }
}