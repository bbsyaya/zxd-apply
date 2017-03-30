package com.zhixindu.apply.core.applicant.service;


import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface ApplicantService {

    boolean existApplicant(String customerId);

    boolean hasMobileVerified(Integer applicantId);

    boolean hasBankCardVerified(Integer applicantId);

    Integer saveApplicantBaseInfo(ApplicantBaseInfoBO applicantBaseInfoBO);

    int saveMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO);

    int resetMobileVerify(Integer applicantId, String mobile);

}
