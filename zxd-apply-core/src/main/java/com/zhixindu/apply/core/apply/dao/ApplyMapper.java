package com.zhixindu.apply.core.apply.dao;

import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.LoanMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.LoanMgtInfoParm;

import java.util.List;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer apply_id);

    int insert(ApplyBO record);

    int insertSelective(ApplyBO record);

    ApplyBO selectByPrimaryKey(Integer apply_id);

    int updateByPrimaryKeySelective(ApplyBO record);

    int updateByPrimaryKey(ApplyBO record);

    ApplyBO selectByLenderId(Integer lender_id);

    List<LoanMgtDetailBO> selectLoansByPage(LoanMgtInfoParm parm);

}