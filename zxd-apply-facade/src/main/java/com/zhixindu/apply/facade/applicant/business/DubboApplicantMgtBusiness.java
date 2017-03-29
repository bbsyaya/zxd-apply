package com.zhixindu.apply.facade.applicant.business;

/**
 * Created by SteveGuo on 2017/3/3.
 */

import com.zhixindu.apply.facade.applicant.bo.ApplicantInfoBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtInfo;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMgtQueryParam;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;

/**
 * @author SteveGuo
 * @date 2017/3/3
 * @description
 */
public interface DubboApplicantMgtBusiness {

    /**
     * 申请人列表
     */
    PageResult<ApplicantInfoBO>  findApplicantInfoByPage(ApplicantMgtQueryParam param) throws ServiceException;

    /**
     * 通过applicant_id获取申请基本信息
     * @throws ServiceException
     */
    ApplicantMgtInfo findApplicantInfo(Integer applicant_id) throws ServiceException;


}
