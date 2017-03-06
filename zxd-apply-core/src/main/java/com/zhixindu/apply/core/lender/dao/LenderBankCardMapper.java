package com.zhixindu.apply.core.lender.dao;

import com.zhixindu.apply.core.lender.domain.LenderBankCard;
import org.apache.ibatis.annotations.Param;

public interface LenderBankCardMapper {
    int deleteByPrimaryKey(Integer bank_card_id);

    int insert(LenderBankCard record);

    int insertSelective(LenderBankCard record);

    LenderBankCard selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKeySelective(LenderBankCard record);

    int updateByPrimaryKey(LenderBankCard record);

    LenderBankCard selectByLenderId(Integer lender_id);
}