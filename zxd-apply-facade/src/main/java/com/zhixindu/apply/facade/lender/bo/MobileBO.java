package com.zhixindu.apply.facade.lender.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class MobileBO implements Serializable{

    private static final long serialVersionUID = 7938297459259413833L;

    /** 借款人ID */
    private Integer lender_id;
    /** 手机号 */
    private String mobile;
    /** 服务密码 */
    private String service_password;

    public Integer getLender_id() {
        return lender_id;
    }

    public void setLender_id(Integer lender_id) {
        this.lender_id = lender_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getService_password() {
        return service_password;
    }

    public void setService_password(String service_password) {
        this.service_password = service_password;
    }
}
