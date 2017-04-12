package com.zhixindu.apply.core.applicant.business;

import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.service.ApplicantService;
import com.zhixindu.apply.core.constant.ApplyErrorCode;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtInfo;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtQueryParam;
import com.zhixindu.apply.facade.applicant.bo.ApplyResultBO;
import com.zhixindu.apply.facade.applicant.business.DubboApplicantMgtBusiness;
import com.zhixindu.commons.annotation.Business;
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
@Business("applicantMgtBusiness")
public class ApplicantMgtBusinessImpl implements DubboApplicantMgtBusiness {

    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplicantService applicantService;
    @Inject
    private PageRepository pageRepository;

    @Override
    public PageResult<ApplicantBO> findApplicantInfoByPage(ApplicantMgtQueryParam param) throws ServiceException {
        Parameters.requireNotNull(param.getPage(),"分页查询参数page不能为空");
        Parameters.requireNotNull(param.getCount(),"分页查询参数count不能为空");
        PageResult<ApplicantBO> pageResult = pageRepository.selectPaging(ApplicantMapper.class,"selectListForMgtByPage",param);
        if(pageResult == null){
            return new PageResult<>(new ArrayList<>(0), 0);
        }
        return pageResult;
    }

    @Override
    public ApplicantMgtInfo findApplicantInfo(Integer applicant_id) throws ServiceException {
        Parameters.requireNotNull(applicant_id,"findApplicantInfo applicant_id illegal_param !");
        ApplicantBO applicantBO = applicantMapper.selectByPrimaryKey(applicant_id);
        if(null == applicantBO){
            throw new ServiceException(ApplyErrorCode.NO_APPLY.getErrorCode(), ApplyErrorCode.NO_APPLY.getDesc());
        }
        ApplicantMgtInfo applicantMgtInfo = new ApplicantMgtInfo();
        BeanUtils.copyProperties(applicantBO, applicantMgtInfo);
        return applicantMgtInfo;
    }

    @Override
    public boolean updateApplyResult(ApplyResultBO applyResultBO) throws ServiceException {
        Parameters.requireAllPropertyNotNull(applyResultBO);
        return applicantService.updateApplyResult(applyResultBO) > 0;
    }
}
