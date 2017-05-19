package com.zhixindu.apply.core.applicant.dao;


import com.zhixindu.apply.core.applicant.po.ApplicantBankCardVerifyPO;
import com.zhixindu.apply.core.applicant.po.ApplicantBaseInfoPO;
import com.zhixindu.apply.core.applicant.po.ApplyResultPO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtQueryParam;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.core.applicant.po.LoanFillStepPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantMapper {

    int insert(ApplicantBO record);

    int insertSelective(ApplicantBO record);

    int insertBaseInfo(ApplicantBaseInfoPO applicantBaseInfoPO);

    ApplicantBO selectByPrimaryKey(Integer applicant_id);

    int updateByPrimaryKey(ApplicantBO record);

    int updateByPrimaryKeySelective(ApplicantBO record);

    ApplicantBO selectByCustomerId(String customer_id);

    Integer selectPrimaryKeyByCustomerId(String customer_id);

    int countByCustomerId(String customer_id);

    Integer selectMobileVerifyByPrimaryKey(Integer applicant_id);

    Integer selectBankCardVerifyByPrimaryKey(Integer applicant_id);

    int updateMobileVerify(ApplicantMobileVerifyBO applicantMobileVerifyBO);

    int resetMobileVerify(@Param("applicant_id") Integer applicant_id, @Param("mobile") String mobile);

    int updateBankCardVerify(ApplicantBankCardVerifyPO applicantBankCardVerifyPO);

    int updateLoanFillStep(LoanFillStepPO loanFillStepPO);

    int updateApplyResult(ApplyResultPO applyResultPO);

    List<ApplicantBO> selectListForMgtByPage(ApplicantMgtQueryParam param);

    List<ApplicantBO> selectNoCertificationList();

    int updateCertificationFlag(String customer_id);

}