package com.zhixindu.apply.core.loan.dao;

import com.zhixindu.apply.facade.loan.bo.LoanBO;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfo;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfoParm;

import java.util.List;

public interface LoanMapper {
    int deleteByPrimaryKey(Integer loan_id);

    int insert(LoanBO loanBO);

    int insertSelective(LoanBO loanBO);

    LoanBO selectByPrimaryKey(Integer loan_id);

    int updateByPrimaryKeySelective(LoanBO loanBO);

    int updateByPrimaryKey(LoanBO loanBO);

    LoanBO selectByLenderId(Integer lender_id);

    List<LoanMgtInfo> selectLoansByPage(LoanMgtInfoParm parm);
}