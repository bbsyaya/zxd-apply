package com.zhixindu.apply.facade.applicant.business;

import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantVerifyBO;
import com.zhixindu.commons.api.ServiceException;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplicantWechatBusiness {

    /**
     * 根据客户ID查找申请人信息
     * @param applicantId
     * @return 申请人信息
     */
    ApplicantBO findApplicant(Integer applicantId);

    /**
     * 根据客户ID查找申请人信息
     * @param customerId
     * @return 申请人信息
     */
    ApplicantBO findApplicant(String customerId);

    /**
     * 保存申请人信息
     * @param applicantBaseInfoBO
     * @return 申请人ID
     */
    Integer submitApplicant(ApplicantBaseInfoBO applicantBaseInfoBO);

    /**
     * 根据申请人ID查找申请人验证信息
     * @param applicantId
     * @return 申请人验证信息
     */
    ApplicantVerifyBO findApplicantVerify(Integer applicantId);

    /**
     * 根据申请人ID查找手机验证信息
     * @param applicantId
     * @return 申请人手机验证信息
     */
    ApplicantMobileVerifyBO findApplicantMobileVerify(Integer applicantId);

    /**
     * 提交手机号码验证
     * @param applicantMobileVerifyBO
     * @return 是否成功
     */
    boolean submitApplicantMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO) throws ServiceException;

    /**
     * 重置手机号码验证
     * @param applicantId
     * @param mobile
     * @return
     */
    boolean resetApplicantMobileVerify(Integer applicantId, String mobile) throws ServiceException;

    /**
     * 通过客户ID获取申请人ID
     * @param customerId
     * @return
     */
    Integer findApplicantId(String customerId) throws ServiceException;

}
