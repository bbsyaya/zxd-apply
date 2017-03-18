package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LoanFillStepBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderMapper {

    int insert(LenderBO record);

    int insertSelective(LenderBO record);

    int insertBaseInfo(LenderBaseInfoPO lenderBaseInfoPO);

    LenderBO selectByPrimaryKey(Integer lender_id);

    int updateByPrimaryKey(LenderBO record);

    int updateByPrimaryKeySelective(LenderBO record);

    LenderBO selectByCustomerId(String customer_id);

    Integer selectPrimaryKeyByCustomerId(String customer_id);

    int countByCustomerId(String customer_id);

    Integer selectMobileVerifyByPrimaryKey(Integer lender_id);

    Integer selectBankCardVerifyByPrimaryKey(Integer lender_id);

    int updateMobileVerify(LenderMobileVerifyBO lenderMobileVerifyBO);

    int updateBankCardVerify(LenderBankCardVerifyBO lenderBankCardVerifyBO);

    int updateLoanFillStep(LoanFillStepBO loanFillStepBO);

    int updateApplyResult(ApplyResultBO applyResultBO);

}