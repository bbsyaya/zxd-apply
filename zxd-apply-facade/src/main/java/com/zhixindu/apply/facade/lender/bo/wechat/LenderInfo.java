package com.zhixindu.apply.facade.lender.bo.wechat;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public class LenderInfo implements Serializable {

    private static final long serialVersionUID = 1514697726721474544L;

    private Integer lender_id;

    private String customer_id;

    private String mobile;

    private String name;

    private String id_card;

    private Address address;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id == null ? null : customer_id.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
