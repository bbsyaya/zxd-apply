package com.zhixindu.apply.core.loan.business;


import com.zhixindu.apply.core.loan.dao.LoanMapper;
import com.zhixindu.apply.facade.loan.bo.LoanBO;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfo;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfoParm;
import com.zhixindu.apply.facade.loan.business.DubboApplyLoanMgtBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("loanMgtBusiness")
public class LoanMgtBusinessImpl implements DubboApplyLoanMgtBusiness{

    @Inject
    private LoanMapper loanMapper;

    @Override
    public LoanMgtInfo getLoanInfoByLenderId(Integer lender_id) throws ServiceException {
        Parameters.requireNotNull(lender_id,"getLoanInfoByLenderId lender_id illargm_param");
        LoanBO loanBO = loanMapper.selectByLenderId(lender_id);
        if(null == loanBO){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询不到申请的借款信息!");
        }
        LoanMgtInfo loanMgtInfo = new LoanMgtInfo();
        BeanUtils.copyProperties(loanMgtInfo,loanBO);
        return loanMgtInfo;
    }

    @Override
    public PageResult<LoanMgtInfo> selectLoansByPage(LoanMgtInfoParm parm) throws ServiceException {
      return null;
    }
}
