package com.zhixindu.apply.core.apply.business;


import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfo;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfoParm;
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
public class ApplyMgtBusinessImpl implements DubboApplyMgtBusiness {

    @Inject
    private ApplyMapper applyMapper;

    @Inject
    private PageRepository pageRepository;

    @Override
    public ApplyMgtInfo getApplyInfoByLenderId(Integer lender_id) throws ServiceException {
        Parameters.requireNotNull(lender_id,"getApplyInfoByLenderId lender_id illargm_param");
        ApplyBO applyBO = applyMapper.selectByLenderId(lender_id);
        if(null == applyBO){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询不到申请的借款信息!");
        }
        ApplyMgtInfo applyMgtInfo = new ApplyMgtInfo();
        BeanUtils.copyProperties(applyMgtInfo,applyBO);
        return applyMgtInfo;
    }

    @Override
    public PageResult<ApplyMgtDetailBO> selectApplysByPage(ApplyMgtInfoParm parm) throws ServiceException {
        if(parm == null){
            return new PageResult<ApplyMgtDetailBO>(new ArrayList<ApplyMgtDetailBO>(0), 0);
        }
        PageResult<ApplyMgtDetailBO> pageResult = pageRepository.selectPaging(ApplyMapper.class,"selectLoansByPage",parm);
        if(pageResult == null){
            return new PageResult<ApplyMgtDetailBO>(new ArrayList<ApplyMgtDetailBO>(0), 0);
        }
        return pageResult;
    }
}
