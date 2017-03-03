package com.zhixindu.apply.core.lender.domain;

import java.io.Serializable;

public class LenderAddress implements Serializable {
    private Integer address_id;

    private Integer lender_id;

    private Short home_code;

    private String home_address;

    private Short career;

    private String company_name;

    private Short company_code;

    private String company_address;

    private static final long serialVersionUID = 1L;

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

    public Short getHome_code() {
        return home_code;
    }

    public void setHome_code(Short home_code) {
        this.home_code = home_code;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address == null ? null : home_address.trim();
    }

    public Short getCareer() {
        return career;
    }

    public void setCareer(Short career) {
        this.career = career;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    public Short getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Short company_code) {
        this.company_code = company_code;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address == null ? null : company_address.trim();
    }
}