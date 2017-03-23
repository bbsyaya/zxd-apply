package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderBankCardMapper {

    int insert(LenderBankCardBO record);

    int insertSelective(LenderBankCardBO record);

    LenderBankCardBO selectByPrimaryKey(Integer bank_card_id);

    int updateByPrimaryKey(LenderBankCardBO record);

    int updateByPrimaryKeySelective(LenderBankCardBO record);

    LenderBankCardBO selectByLenderId(Integer lender_id);

    Integer selectPrimaryKeyByLenderId(Integer lender_id);

    String selectBankCardNumber(Integer lender_id);

    int countByLenderId(Integer lender_id);
}