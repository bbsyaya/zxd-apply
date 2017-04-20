package com.zhixindu.apply.core.apply.service;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.service.ApplicantService;
import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.po.ApplyAddressPO;
import com.zhixindu.apply.core.apply.po.ApplyBankCardPO;
import com.zhixindu.apply.core.apply.po.ApplyBankCardVerifyPO;
import com.zhixindu.apply.core.apply.po.ApplyContactPO;
import com.zhixindu.apply.core.apply.po.ApplyLocationPO;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.core.applicant.po.ApplyResultPO;
import com.zhixindu.apply.core.applicant.po.LoanFillStepPO;
import com.zhixindu.apply.facade.applicant.enums.BankCardVerify;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.core.applicant.po.ApplicantBankCardVerifyPO;
import com.zhixindu.apply.facade.apply.bo.ApplyBaseInfoBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyCreditBO;
import com.zhixindu.apply.facade.apply.bo.ApplyStatusBO;
import com.zhixindu.apply.facade.apply.enums.ApplyStatus;
import com.zhixindu.apply.facade.apply.enums.ProcessState;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/7.
 */
@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyAddressMapper applyAddressMapper;
    @Inject
    private ApplyContactMapper applyContactMapper;
    @Inject
    private ApplyBankCardMapper applyBankCardMapper;
    @Inject
    private ApplyLocationMapper applyLocationMapper;
    @Inject
    private ApplyStepService applyStepService;
    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplicantService applicantService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer startApplyLoan(Integer applicantId) {
        ApplyPO applyPO = new ApplyPO();
        applyPO.setApplicant_id(applicantId);
        applyPO.setApply_status(ApplyStatus.PREPARE_SUBMIT);
        applyMapper.insertSelective(applyPO);
        Integer applyId = applyPO.getApply_id();

        applyStepService.startStep(applyId, ProcessStep.SUBMIT);

        LoanFillStepPO loanFillStepPO = new LoanFillStepPO(applicantId, LoanFillStep.BASIC_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepPO);
        return applyId;
    }

    @Override
    public boolean existApplyAddress(Integer applyId) {
        return applyAddressMapper.countByApplyId(applyId) > 0;
    }

    @Override
    public boolean existApplyContact(Integer applyId) {
        return applyContactMapper.countByApplyId(applyId) > 1;
    }

    @Override
    public boolean existApplyBankCard(Integer applyId) {
        return applyBankCardMapper.countByApplyId(applyId) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateAddress(ApplyAddressBO applyAddressBO) {
        ApplyAddressPO applyAddressPO = new ApplyAddressPO();
        BeanUtils.copyProperties(applyAddressBO, applyAddressPO);
        applyAddressPO.setUpdate_time(new Date());
        if(null != applyAddressBO.getAddress_id()) {
            applyAddressMapper.updateByPrimaryKeySelective(applyAddressPO);
        } else {
            applyAddressPO.setCreate_time(new Date());
            applyAddressMapper.insert(applyAddressPO);
            applyAddressBO.setAddress_id(applyAddressPO.getAddress_id());
        }
        LoanFillStepPO loanFillStepPO = new LoanFillStepPO(applyAddressBO.getApplicant_id(), LoanFillStep.CONTACT_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepPO);
        return applyAddressBO.getAddress_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> saveOrUpdateContact(List<ApplyContactBO> applyContactBOList) {
        List<Integer> contactIdList = applyContactBOList.stream().map(applyContactBO -> {
            ApplyContactPO applyContactPO = new ApplyContactPO();
            BeanUtils.copyProperties(applyContactBO, applyContactPO);
            applyContactPO.setUpdate_time(new Date());
            if (null != applyContactBO.getContact_id()) {
                applyContactMapper.updateByPrimaryKeySelective(applyContactPO);
            } else {
                int contactCount = applyContactMapper.countByApplyId(applyContactBO.getApply_id());
                if(contactCount < 2){
                    applyContactPO.setCreate_time(new Date());
                    applyContactMapper.insert(applyContactPO);
                    applyContactBO.setContact_id(applyContactPO.getContact_id());
                } else {
                    throw new ServiceException(ServiceCode.ILLEGAL_PARAM, "contactId不能为空");
                }
            }
            return applyContactBO.getContact_id();
        }).collect(Collectors.toList());
        Integer applicantId = applyContactBOList.stream().map(ApplyContactBO::getApplicant_id).distinct().findAny().orElse(null);
        LoanFillStepPO loanFillStepPO = new LoanFillStepPO(applicantId, LoanFillStep.CERTIFICATION_INFO);
        applicantMapper.updateLoanFillStep(loanFillStepPO);
        return contactIdList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateBankCard(ApplyBankCardBO applyBankCardBO) {
        ApplyBankCardPO applyBankCardPO = new ApplyBankCardPO();
        BeanUtils.copyProperties(applyBankCardBO, applyBankCardPO);
        applyBankCardPO.setUpdate_time(new Date());
        if(null != applyBankCardBO.getBank_card_id()) {
            applyBankCardMapper.updateByPrimaryKeySelective(applyBankCardPO);
        } else {
            applyBankCardPO.setCreate_time(new Date());
            applyBankCardMapper.insert(applyBankCardPO);
            applyBankCardBO.setBank_card_id(applyBankCardPO.getBank_card_id());
        }
        ApplicantBankCardVerifyPO bankCardVerifyPO = new ApplicantBankCardVerifyPO();
        Integer applicantId = applyBankCardBO.getApplicant_id();
        bankCardVerifyPO.setApplicant_id(applicantId);
        bankCardVerifyPO.setBank_card_verify(applyBankCardBO.getBank_card_verify());
        applicantMapper.updateBankCardVerify(bankCardVerifyPO);
        // 银行卡填写且手机号已经认证通过才能更新填写步骤
        if(BankCardVerify.FILLED.matches(bankCardVerifyPO.getBank_card_verify())
            && applicantService.hasMobileVerified(applicantId)) {
            LoanFillStepPO loanFillStepPO = new LoanFillStepPO(applyBankCardBO.getApplicant_id(), LoanFillStep.SUBMIT);
            applicantMapper.updateLoanFillStep(loanFillStepPO);
        }
        return applyBankCardBO.getBank_card_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareApplyLoan(Integer applicantId, Integer applyId) {
        return prepareApplyAddress(applicantId, applyId)
                && prepareApplyContact(applicantId, applyId)
                && prepareApplyBankCard(applicantId, applyId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareApplyAddress(Integer applicantId, Integer applyId) {
        boolean result = true;
        if(!existApplyAddress(applyId)) {
            ApplyAddressPO applyAddressPO = applyAddressMapper.selectLatestByApplicantId(applicantId);
            applyAddressPO.setAddress_id(null);
            applyAddressPO.setApply_id(applyId);
            applyAddressPO.setCreate_time(new Date());
            applyAddressPO.setUpdate_time(new Date());
            result = applyAddressMapper.insert(applyAddressPO) > 0;
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareApplyContact(Integer applicantId, Integer applyId) {
        boolean result = true;
        if(!existApplyContact(applyId)) {
            List<ApplyContactPO> applyContactPOList = applyContactMapper.selectLatestByApplicantId(applicantId);
            result = applyContactPOList.stream()
                    .map(applyContactPO -> {
                        applyContactPO.setContact_id(null);
                        applyContactPO.setApply_id(applyId);
                        applyContactPO.setCreate_time(new Date());
                        applyContactPO.setUpdate_time(new Date());
                        return applyContactMapper.insert(applyContactPO);
                    }).allMatch(effectRows -> effectRows > 0);
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean prepareApplyBankCard(Integer applicantId, Integer applyId) {
        boolean result = true;
        if(!existApplyBankCard(applyId)) {
            ApplyBankCardPO applyBankCardPO = applyBankCardMapper.selectLatestByApplicantId(applicantId);
            applyBankCardPO.setBank_card_id(null);
            applyBankCardPO.setApply_id(applyId);
            applyBankCardPO.setCreate_time(new Date());
            applyBankCardPO.setUpdate_time(new Date());
            result = applyBankCardMapper.insert(applyBankCardPO) > 0;
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveApplyLoan(ApplyBaseInfoBO applyBaseInfoBO) {
        ApplyPO applyPO = new ApplyPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyPO);
        Date now = new Date();
        applyPO.setApply_time(now);
        applyPO.setApply_status(ApplyStatus.UNDER_REVIEW);
        applyMapper.updateByPrimaryKeySelective(applyPO);

        ApplyLocationPO applyLocationPO = new ApplyLocationPO();
        BeanUtils.copyProperties(applyBaseInfoBO, applyLocationPO);
        applyLocationPO.setCreate_time(new Date());
        applyLocationPO.setUpdate_time(new Date());
        applyLocationMapper.insert(applyLocationPO);

        Integer applyId = applyBaseInfoBO.getApply_id();
        applyStepService.completeStep(applyId, ProcessStep.SUBMIT, now, ProcessState.SUCCESS);
        applyStepService.startStep(applyId, ProcessStep.REVIEW);

        LoanFillStepPO loanFillStepPO = new LoanFillStepPO(applyPO.getApplicant_id(), LoanFillStep.COMPLETE);
        applicantMapper.updateLoanFillStep(loanFillStepPO);
        return applyPO.getApply_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateApplyCredit(ApplyCreditBO applyCreditBO) {
        int rows = applyMapper.updateCreditByPrimaryKey(applyCreditBO);

        ApplyResultPO applyResultPO = new ApplyResultPO();
        Integer applyId = applyCreditBO.getApply_id();
        ApplyStatus applyStatus = applyCreditBO.getApply_status();
        applyResultPO.setApplicant_id(applyCreditBO.getApplicant_id());
        applyResultPO.setCredit_score(applyCreditBO.getCredit_score());
        applyResultPO.setApply_result(applyStatus.getApplyResult());
        applyResultPO.setBank_card_verify(applyCreditBO.getBank_card_verify());
        // 审核失败才会更新审核拒绝时间
        if(ApplyStatus.REVIEW_FAIL.matches(applyStatus)) {
            applyResultPO.setReject_time(new Date());
        }
        // 银行卡认证失败的就回到第三步认证信息
        if(BankCardVerify.UNVERIFIED.matches(applyCreditBO.getBank_card_verify())) {
            applyResultPO.setLoan_fill_step(LoanFillStep.CERTIFICATION_INFO);
        }
        rows += applicantMapper.updateApplyResult(applyResultPO);

        ApplyBankCardVerifyPO bankCardVerifyPO = new ApplyBankCardVerifyPO();
        bankCardVerifyPO.setApply_id(applyId);
        bankCardVerifyPO.setBank_card_verify(applyCreditBO.getBank_card_verify());
        rows += applyBankCardMapper.updateBankCardVerifyByApplyId(bankCardVerifyPO);

        applyStepService.completeStep(applyId, ProcessStep.REVIEW, applyCreditBO.getReview_time(), applyStatus.getProcessState());
        // 审核成功才有下一步放款
        if(ApplyStatus.REVIEW_SUCCESS.matches(applyStatus)) {
            applyStepService.startStep(applyId, ProcessStep.LOAN);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateLoanStatus(ApplyStatusBO applyStatusBO) {
        int rows = applyMapper.updateStatusByPrimaryKey(applyStatusBO);

        Integer applyId = applyStatusBO.getApply_id();
        ProcessState processState = applyStatusBO.getApply_status().getProcessState();
        applyStepService.completeStep(applyId, ProcessStep.LOAN, applyStatusBO.getProcess_time(), processState);
        // 放款成功才有下一步结清
        if(ApplyStatus.LOAN_SUCCESS.matches(applyStatusBO.getApply_status())) {
            applyStepService.startStep(applyId, ProcessStep.REPAYMENT);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateRepaymentStatus(ApplyStatusBO applyStatusBO) {
        applyStatusBO.setApply_status(ApplyStatus.REPAYMENT_SETTLED);
        int rows = applyMapper.updateStatusByPrimaryKey(applyStatusBO);

        ProcessState processState = applyStatusBO.getApply_status().getProcessState();
        applyStepService.completeStep(applyStatusBO.getApply_id(), ProcessStep.REPAYMENT, applyStatusBO.getProcess_time(), processState);
        return rows;
    }

}
