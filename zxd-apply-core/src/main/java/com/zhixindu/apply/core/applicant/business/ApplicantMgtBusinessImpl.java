package com.zhixindu.apply.core.applicant.business;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.system.service.SystemConfigService;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.applicant.bo.ApplyAddressMgtBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtInfo;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtQueryParam;
import com.zhixindu.apply.facade.applicant.business.DubboApplicantMgtBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("applicantMgtBusiness")
public class ApplicantMgtBusinessImpl implements DubboApplicantMgtBusiness {

    @Inject
    private ApplicantMapper applicantMapper;


    @Override
    public PageResult<ApplicantInfoBO> findApplicantInfoByPage(ApplicantMgtQueryParam param) throws ServiceException {
        return null;
    }

    @Override
    public ApplicantMgtInfo findApplicantInfo(Integer applicant_id) throws ServiceException {
        Parameters.requireNotNull(applicant_id,"findApplicantInfo applicant_id illegal_param !");
        ApplicantBO applicantBO = applicantMapper.selectByPrimaryKey(applicant_id);
        if(null == applicantBO){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询的申请信息无结果!!!");
        }
        ApplicantMgtInfo applicantMgtInfo = new ApplicantMgtInfo();
        BeanUtils.copyProperties(applicantBO, applicantMgtInfo);
        return applicantMgtInfo;
    }
}
