package com.zhixindu.apply.core.applicant.business;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.service.ApplicantService;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBaseInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantVerifyBO;
import com.zhixindu.apply.facade.applicant.business.DubboApplicantWechatBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.utils.Parameters;
import com.zhixindu.commons.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("applicantWechatBusiness")
public class ApplicantWechatBusinessImpl implements DubboApplicantWechatBusiness {

    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplicantService applicantService;

    @Override
    public ApplicantBO findApplicant(Integer applicantId) {
        return applicantMapper.selectByPrimaryKey(applicantId);
    }

    @Override
    public ApplicantBO findApplicant(String customerId) {
        Parameters.requireNotNull(customerId, "customerId不能为空");
        return applicantMapper.selectByCustomerId(customerId);
    }

    @Override
    public Integer submitApplicant(ApplicantBaseInfoBO applicantBaseInfoBO) {
        if(StringUtils.isBlank(applicantBaseInfoBO.getCustomer_id())) {
            throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "customerId不能为空");
        }
        if(!applicantService.existApplicant(applicantBaseInfoBO.getCustomer_id())) {
            Parameters.requireAllPropertyNotNull(applicantBaseInfoBO, new Object[]{"applicant_id"});
            applicantService.saveApplicantBaseInfo(applicantBaseInfoBO);
        }
        return applicantBaseInfoBO.getApplicant_id();
    }

    @Override
    public ApplicantVerifyBO findApplicantVerify(Integer applicantId) {
        Parameters.requireNotNull(applicantId, "applicantId不能为空");
        ApplicantBO applicantBO = applicantMapper.selectByPrimaryKey(applicantId);
        if(null == applicantBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的申请人信息");
        }
        ApplicantVerifyBO applicantVerifyBO = new ApplicantVerifyBO();
        BeanUtils.copyProperties(applicantBO, applicantVerifyBO);
        return applicantVerifyBO;
    }

    @Override
    public ApplicantMobileVerifyBO findApplicantMobileVerify(Integer applicantId) {
        Parameters.requireNotNull(applicantId, "applicantId不能为空");
        ApplicantBO applicantBO = applicantMapper.selectByPrimaryKey(applicantId);
        if(null == applicantBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, "没有对应的申请人信息");
        }
        ApplicantMobileVerifyBO mobileVerify = new ApplicantMobileVerifyBO();
        mobileVerify.setApplicant_id(applicantId);
        mobileVerify.setMobile(applicantBO.getMobile());
        mobileVerify.setService_password(StringUtil.maskPassword(applicantBO.getService_password()));
        return mobileVerify;
    }

    @Override
    public boolean submitApplicantMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO) {
        Parameters.requireAllPropertyNotNull(applicantMobileVerifyBO);
        return applicantService.saveMobileVerify(applicantMobileVerifyBO) > 0;
    }

    @Override
    public boolean resetApplicantMobileVerify(Integer applicantId, String mobile) {
        Parameters.requireNotNull(applicantId, "applicantId不能为空");
        Parameters.requireNotNull(mobile, "mobile不能为空");
        return applicantService.resetMobileVerify(applicantId, mobile) > 0;
    }

    @Override
    public Integer findApplicantId(String customerId) {
        Parameters.requireNotNull(customerId, "customerId不能为空");
        return applicantMapper.selectPrimaryKeyByCustomerId(customerId);
    }

}
