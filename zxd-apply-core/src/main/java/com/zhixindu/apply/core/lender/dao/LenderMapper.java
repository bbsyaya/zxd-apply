package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.BankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.FillStepBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;
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

    int countByCustomerId(String customer_id);

    int updateMobileVerify(MobileVerifyBO mobileVerifyBO);

    int updateBankCardVerify(BankCardVerifyBO bankCardVerifyBO);

    int updateFillStep(FillStepBO fillStepBO);

    int updateApplyResult(ApplyResultBO applyResultBO);

}