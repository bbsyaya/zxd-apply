package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

public class LenderMgtContact implements Serializable {

    private static final long serialVersionUID = -1156451918743320197L;

    private Integer lender_id;

    private Integer contact_relationship;

    private String contact_name;

    private String contact_mobile;


    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public Integer getContact_relationship() {
        return contact_relationship;
    }

    public void setContact_relationship(Integer contact_relationship) {
        this.contact_relationship = contact_relationship;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name == null ? null : contact_name.trim();
    }

    public String getContact_mobile() {
        return contact_mobile;
    }

    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile == null ? null : contact_mobile.trim();
    }
}