package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.WorkState;

import java.io.Serializable;

public class LenderAddressBO implements Serializable {

    private static final long serialVersionUID = 2319732869984633192L;

    private Integer address_id;

    private Integer lender_id;

    private Integer home_address_code;

    private String home_address;

    private WorkState work_state;

    private String company_name;

    private Integer company_address_code;

    private String company_address;

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
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

    public WorkState getWork_state() {
        return work_state;
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
}