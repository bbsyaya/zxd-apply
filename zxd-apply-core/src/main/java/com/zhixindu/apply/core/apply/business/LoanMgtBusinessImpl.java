package com.zhixindu.apply.core.apply.business;


import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.LoanMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.LoanMgtInfo;
import com.zhixindu.apply.facade.apply.bo.LoanMgtInfoParm;
import com.zhixindu.apply.facade.apply.business.DubboApplyMgtBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.repository.PageRepository;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("loanMgtBusiness")
public class LoanMgtBusinessImpl implements DubboApplyMgtBusiness {

    @Inject
    private ApplyMapper applyMapper;

    @Inject
    private PageRepository pageRepository;

    @Override
    public LoanMgtInfo getLoanInfoByLenderId(Integer lender_id) throws ServiceException {
        Parameters.requireNotNull(lender_id,"getLoanInfoByLenderId lender_id illargm_param");
        ApplyBO applyBO = applyMapper.selectByLenderId(lender_id);
        if(null == applyBO){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询不到申请的借款信息!");
        }
        LoanMgtInfo loanMgtInfo = new LoanMgtInfo();
        BeanUtils.copyProperties(loanMgtInfo,applyBO);
        return loanMgtInfo;
    }

    @Override
    public PageResult<LoanMgtDetailBO> selectLoansByPage(LoanMgtInfoParm parm) throws ServiceException {
        if(parm == null){
            return new PageResult<LoanMgtDetailBO>(new ArrayList<LoanMgtDetailBO>(0), 0);
        }
        PageResult<LoanMgtDetailBO> pageResult = pageRepository.selectPaging(ApplyMapper.class,"selectLoansByPage",parm);
        if(pageResult == null){
            return new PageResult<LoanMgtDetailBO>(new ArrayList<LoanMgtDetailBO>(0), 0);
        }
        return pageResult;
    }
}
