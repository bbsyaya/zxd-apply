package com.zhixindu.apply.core.applicant.service;


import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface ApplicantService {

    boolean existApplicant(String customerId);

    boolean existApplicantAddress(Integer applicantId);

    boolean existApplicantContact(Integer applicantId);

    boolean existApplicantBankCard(Integer applicantId);

    boolean hasMobileVerified(Integer applicantId);

    boolean hasBankCardVerified(Integer applicantId);

    Integer saveApplicantBaseInfo(ApplicantBaseInfoBO applicantBaseInfoBO);

    Integer saveOrUpdateAddress(ApplyAddressBO applyAddressBO);

    List<Integer> saveOrUpdateContact(List<ApplyContactBO> applyContactBOList);

    Integer saveOrUpdateBankCard(ApplyBankCardBO applyBankCardBO);

    int saveMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO);

    int resetMobileVerify(Integer applicantId, String mobile);

}
