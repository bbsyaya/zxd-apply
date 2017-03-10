package com.zhixindu.apply.core.lender.dao;


import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenderContactMapper {

    int insert(LenderContactBO record);

    int insertSelective(LenderContactBO record);

    LenderContactBO selectByPrimaryKey(Integer contact_id);

    int updateByPrimaryKey(LenderContactBO record);

    int updateByPrimaryKeySelective(LenderContactBO record);

    List<LenderContactBO> selectByLenderId(Integer lender_id);

    int countByLenderId(Integer lender_id);

}