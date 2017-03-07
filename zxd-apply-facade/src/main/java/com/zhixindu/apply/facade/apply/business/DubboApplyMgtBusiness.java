package com.zhixindu.apply.facade.apply.business;

import com.zhixindu.apply.facade.apply.bo.LoanMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.LoanMgtInfo;
import com.zhixindu.apply.facade.apply.bo.LoanMgtInfoParm;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

/**
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplyMgtBusiness {

    /**
     * 获取申请借款信息
     */

    LoanMgtInfo getLoanInfoByLenderId(Integer lender_id) throws ServiceException;

    /**
     * 获取申请借款列表
     * @throws ServiceException
     */
    PageResult<LoanMgtDetailBO> selectLoansByPage(LoanMgtInfoParm parm) throws ServiceException;
}
