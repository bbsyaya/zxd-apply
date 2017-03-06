package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.core.lender.po.LenderPO;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderMapper {

    int insertSelective(LenderPO record);

    LenderPO selectByPrimaryKey(Integer lender_id);

    int updateByPrimaryKeySelective(LenderPO record);

    String selectCreditSituationByCustomerId(String customer_id);

    LenderPO selectByCustomerId(String customer_id);

}