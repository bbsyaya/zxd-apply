package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBankCardMapper {

    int insert(ApplyBankCardBO record);

    int insertSelective(ApplyBankCardBO record);

    ApplyBankCardBO selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKey(ApplyBankCardBO record);

    int updateByPrimaryKeySelective(ApplyBankCardBO record);

    ApplyBankCardBO selectLatestByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplyId(Integer apply_id);

    ApplyBankCardBO selectByApplyId(Integer apply_id);

    String selectBankCardNumber(Integer apply_id);

    int countByApplyId(Integer apply_id);
}