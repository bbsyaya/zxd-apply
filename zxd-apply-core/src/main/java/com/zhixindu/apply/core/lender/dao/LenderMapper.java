package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.LenderBO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderMapper {

    int insertSelective(LenderBO record);

    LenderBO selectByPrimaryKey(Integer lender_id);

    int updateByPrimaryKeySelective(LenderBO record);

    String selectCreditSituationByCustomerId(String customer_id);

    LenderBO selectByCustomerId(String customer_id);

}