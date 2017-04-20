package com.zhixindu.apply.facade.applicant.bo;

import com.zhixindu.apply.facade.applicant.enums.MobileVerify;
import com.zhixindu.commons.api.utils.MaskUtil;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class ApplicantMobileVerifyBO implements IMobileVerify, Serializable{

    private static final long serialVersionUID = 7938297459259413833L;

    /** 申请人ID */
    private Integer applicant_id;
    /** 手机号 */
    private String mobile;
    /** 服务密码 */
    private String service_password;
    /** 运营商token */
    private String operator_token;
    /** 手机号验证 */
    private MobileVerify mobile_verify;

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
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

    public String getOperator_token() {
        return operator_token;
    }

    public void setOperator_token(String operator_token) {
        this.operator_token = operator_token;
    }

    public MobileVerify getMobile_verify() {
        return mobile_verify;
    }

    public void setMobile_verify(MobileVerify mobile_verify) {
        this.mobile_verify = mobile_verify;
    }

    @Override
    public boolean isMobileVerified() {
        return MobileVerify.VERIFIED.matches(getMobile_verify());
    }

    public String getMaskMobile(){
        return MaskUtil.maskMobile(getMobile());
    }
}
