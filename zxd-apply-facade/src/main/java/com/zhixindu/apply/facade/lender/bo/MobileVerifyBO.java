package com.zhixindu.apply.facade.lender.bo;

import com.zhixindu.apply.facade.lender.enums.MobileVerify;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class MobileVerifyBO implements Serializable{

    private static final long serialVersionUID = 7938297459259413833L;

    /** 借款人ID */
    private Integer lender_id;
    /** 手机号 */
    private String mobile;
    /** 服务密码 */
    private String service_password;
    /** 手机号验证 */
    private MobileVerify mobile_verify;

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

    public MobileVerify getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(MobileVerify mobile_verify) {
        this.mobile_verify = mobile_verify;
    }
}
