package com.zhixindu.apply.facade.loan.business;

import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfo;
import com.zhixindu.apply.facade.loan.bo.mgt.LoanMgtInfoParm;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyLoanMgtBusiness {

    /**
     * 获取申请借款信息
     */

    LoanMgtInfo getLoanInfoByLenderId(Integer lender_id) throws ServiceException;

    /**
     * 获取申请借款列表
     * @throws ServiceException
     */
    PageResult<LoanMgtInfo> selectLoansByPage(LoanMgtInfoParm parm) throws ServiceException;
}
