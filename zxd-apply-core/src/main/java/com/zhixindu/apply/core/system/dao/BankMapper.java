package com.zhixindu.apply.core.system.dao;

import com.zhixindu.apply.facade.system.bo.BankBO;
import com.zhixindu.apply.facade.system.bo.BankBaseBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankMapper {

    int insert(BankBO record);

    int insertSelective(BankBO record);

    BankBO selectByPrimaryKey(Integer bank_id);

    int updateByPrimaryKeySelective(BankBO record);

    int updateByPrimaryKey(BankBO record);

    List<BankBaseBO> selectAll();

}