package com.zhixindu.apply.core.applicant.service;


import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;
import com.zhixindu.commons.api.ServiceException;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface ApplicantService {

    /**
     * 是否存在申请人信息
     * @param customerId
     * @return
     */
    boolean existApplicant(String customerId);

    /**
     * 手机号是否验证
     * @param applicantId
     * @return
     */
    boolean hasMobileVerified(Integer applicantId);

    /**
     * 银行卡是否验证
     * @param applicantId
     * @return
     */
    boolean hasBankCardVerified(Integer applicantId);

    /**
     * 银行卡是否填写
     * @param applicantId
     * @return
     */
    boolean hasBankCardFilled(Integer applicantId);

    /**
     * 保存申请人基本信息
     * @param applicantBaseInfoBO
     * @return
     */
    Integer saveApplicantBaseInfo(ApplicantBaseInfoBO applicantBaseInfoBO);

    /**
     * 保存手机号验证结果
     * @param applicantMobileVerifyBO
     * @return
     */
    int saveMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO);

    /**
     * 充值手机号验证结果
     * @param applicantId
     * @param mobile
     * @return
     */
    int resetMobileVerify(Integer applicantId, String mobile);

    /**
     * 更新申請結果
     * @param applyResultBO
     * @return
     * @throws ServiceException
     */
    int updateApplyResult(ApplyResultBO applyResultBO) throws ServiceException;

    /**
     * 更新信用认证flag
     * @param customerId
     * @return
     * @throws ServiceException
     */
    int updateCertificationFlag(String customerId) throws ServiceException;

}
