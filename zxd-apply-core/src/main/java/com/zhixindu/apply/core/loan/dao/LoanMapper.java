package com.zhixindu.apply.core.loan.dao;

import com.zhixindu.apply.core.loan.domain.Loan;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfo;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfoParm;

import java.util.List;

public interface LoanMapper {
    int deleteByPrimaryKey(Integer loan_id);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer loan_id);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);

    Loan selectByLenderId(Integer lender_id);

    List<LoanMgtInfo> selectLoansByPage(LoanMgtInfoParm parm);
}