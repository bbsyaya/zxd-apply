package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.MobileBO;
import com.zhixindu.apply.facade.lender.enums.BankCardVerify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderMapper {

    int insert(LenderBO record);

    int insertSelective(LenderBO record);

    LenderBO selectByPrimaryKey(Integer lender_id);

    int updateByPrimaryKey(LenderBO record);

    int updateByPrimaryKeySelective(LenderBO record);

    String selectCreditSituation(String customer_id);

    LenderBO selectByCustomerId(String customer_id);

    int updateMobileVerify(MobileBO mobileBO);

    int updateBankCardVerify(@Param("lender_id") Integer lender_id, @Param("bank_card_verify") BankCardVerify bank_card_verify);

    int updateCreditSituation(@Param("lender_id") Integer lender_id, @Param("credit_situation") String credit_situation);

}