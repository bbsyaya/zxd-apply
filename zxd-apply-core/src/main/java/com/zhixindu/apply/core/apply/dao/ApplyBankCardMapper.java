package com.zhixindu.apply.core.apply.dao;


import com.zhixindu.apply.core.apply.po.ApplyBankCardPO;
import com.zhixindu.apply.core.apply.po.ApplyBankCardVerifyPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyBankCardMapper {

    int insert(ApplyBankCardPO record);

    int insertSelective(ApplyBankCardPO record);

    ApplyBankCardPO selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKey(ApplyBankCardPO record);

    int updateByPrimaryKeySelective(ApplyBankCardPO record);

    ApplyBankCardPO selectLatestByApplicantId(Integer applicant_id);

    List<ApplyBankCardPO> selectByApplicantId(Integer applicant_id);

    Integer selectPrimaryKeyByApplyId(Integer apply_id);

    ApplyBankCardPO selectByApplyId(Integer apply_id);

    String selectBankCardNumber(Integer apply_id);

    int countByApplyId(Integer apply_id);

    int updateBankCardVerifyByApplyId(ApplyBankCardVerifyPO bankCardVerifyPO);

    int countByApplicantId(Integer applicant_id);
}