package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.ContactRelationship;

import java.io.Serializable;

public class LenderContactBO implements Serializable {
    private static final long serialVersionUID = -2075646585551667198L;

    private Integer contact_id;

    private Integer lender_id;

    private ContactRelationship contact_relationship;

    private String contact_name;

    private String contact_mobile;

    private Integer contact_relationship_value;

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public ContactRelationship getContact_relationship() {
        return contact_relationship == null ? ContactRelationship.resolve(contact_relationship_value) : contact_relationship;
    }

    public void setContact_relationship(ContactRelationship contact_relationship) {
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

    public Integer getContact_relationship_value() {
        return contact_relationship_value == null && null != contact_relationship ? contact_relationship.getValue() : contact_relationship_value;
    }

    public void setContact_relationship_value(Integer contact_relationship_value) {
        this.contact_relationship_value = contact_relationship_value;
    }

}