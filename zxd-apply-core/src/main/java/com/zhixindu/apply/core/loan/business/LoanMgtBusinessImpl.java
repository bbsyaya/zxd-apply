package com.zhixindu.apply.core.loan.business;


import com.zhixindu.apply.core.loan.dao.LoanMapper;
import com.zhixindu.apply.core.loan.domain.Loan;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfo;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfoParm;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("loanMgtBusiness")
public class LoanMgtBusinessImpl implements LoanMgtBusiness{

    @Inject
    private LoanMapper loanMapper;

    @Override
    public LoanMgtInfo getLoanInfoByLenderId(Integer lender_id) throws ServiceException {
        Parameters.requireNotNull(lender_id,"getLoanInfoByLenderId lender_id illargm_param");
        Loan loan = loanMapper.selectByLenderId(lender_id);
        if(null == loan){
            return null;
        }
        LoanMgtInfo loanMgtInfo = new LoanMgtInfo();
        BeanUtils.copyProperties(loanMgtInfo,loan);
        return loanMgtInfo;
    }

    @Override
    public PageResult<LoanMgtInfo> selectLoansByPage(LoanMgtInfoParm parm) throws ServiceException {
      return null;
    }
}
