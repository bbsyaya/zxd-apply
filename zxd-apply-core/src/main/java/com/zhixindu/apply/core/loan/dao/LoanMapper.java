package com.zhixindu.apply.core.loan.dao;

import com.zhixindu.apply.core.loan.domain.Loan;

public interface LoanMapper {
    int deleteByPrimaryKey(Integer loan_id);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer loan_id);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);
}