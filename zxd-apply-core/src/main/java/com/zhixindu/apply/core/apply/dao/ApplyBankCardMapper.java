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

    ApplyBankCardBO selectByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplicantId(Integer applicant_id);

    String selectBankCardNumber(Integer applicant_id);

    int countByApplicantId(Integer applicant_id);
}