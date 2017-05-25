package com.zhixindu.apply.core.apply.business;


import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.dao.ApplyStepMapper;
import com.zhixindu.apply.core.apply.po.ApplyBankCardPO;
import com.zhixindu.apply.core.apply.po.ApplyContactPO;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import com.zhixindu.apply.core.apply.po.ApplyStepPO;
import com.zhixindu.apply.core.constant.ApplyErrorCode;
import com.zhixindu.apply.core.system.service.SystemConfigService;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardBO;
import com.zhixindu.apply.facade.apply.bo.ApplyBankCardMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtDetailBO;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtInfo;
import com.zhixindu.apply.facade.apply.bo.ApplyMgtPageParam;
import com.zhixindu.apply.facade.apply.business.DubboApplyMgtBusiness;
import com.zhixindu.apply.facade.apply.enums.ProcessStep;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.repository.PageRepository;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("applyMgtBusiness")
public class ApplyMgtBusinessImpl implements DubboApplyMgtBusiness {

    @Inject
    private ApplyMapper applyMapper;
    @Inject
    private ApplyStepMapper applyStepMapper;
    @Inject
    private ApplyContactMapper applyContactMapper;
    @Inject
    private ApplyBankCardMapper applyBankCardMapper;
    @Inject
    private ApplyAddressMapper applyAddressMapper;
    @Inject
    private SystemConfigService systemConfigService;

    @Inject
    private PageRepository pageRepository;

    @Override
    public ApplyMgtInfo findApplyInfoByApplyId(Integer apply_id) throws ServiceException {
        Parameters.requireNotNull(apply_id,"findApplyInfoByApplyId apply_id illargm_param");
        ApplyPO applyPO = applyMapper.selectByPrimaryKey(apply_id);
        if(null == applyPO){
            throw new ServiceException(ApplyErrorCode.NO_APPLY.getErrorCode(), ApplyErrorCode.NO_APPLY.getDesc());
        }
        ApplyMgtInfo applyMgtInfo = new ApplyMgtInfo();
        BeanUtils.copyProperties(applyPO,applyMgtInfo);
        ApplyBankCardBO applyBankCardBO = applyBankCardMapper.selectByApplyId(applyPO.getApply_id());
        if(applyBankCardBO != null){
            applyMgtInfo.setApplyBankCardBO(applyBankCardBO);
        }
        List<ApplyContactPO> applyContactPOList = applyContactMapper.selectByApplyId(applyPO.getApply_id());
        if (CollectionUtils.isNotEmpty(applyContactPOList)) {
            applyMgtInfo.setApplyContactBOS(applyContactPOList.stream()
                    .map(applyContactPO -> {
                        ApplyContactBO applyContactBO = new ApplyContactBO();
                        BeanUtils.copyProperties(applyContactPO, applyContactBO);
                        return applyContactBO;
                    }).collect(Collectors.toList()));
        }
        ApplyAddressBO applyAddressBO = applyAddressMapper.selectByApplyId(applyPO.getApply_id());
        if(applyAddressBO != null){
            ApplyAddressMgtBO applyAddressMgtBO = new ApplyAddressMgtBO();
            BeanUtils.copyProperties(applyAddressBO,applyAddressMgtBO);
            if(null != applyAddressBO.getHome_address_code()){
                String homeAddressInfo = systemConfigService.getRegionFullName(applyAddressBO.getHome_address_code());
                applyAddressMgtBO.setHome_address_info(homeAddressInfo);
            }
            if(null != applyAddressBO.getCompany_address_code()) {
                String companyAddressInfo = systemConfigService.getRegionFullName(applyAddressBO.getCompany_address_code());
                applyAddressMgtBO.setCompany_address_info(companyAddressInfo);
            }
            applyMgtInfo.setApplyAddressMgtBO(applyAddressMgtBO);
        }
        return applyMgtInfo;
    }


    @Override
    public PageResult<ApplyMgtDetailBO> selectApplysByPage(ApplyMgtPageParam pageParam) throws ServiceException {
        Parameters.requireNotNull(pageParam.getPage(),"分页查询参数page不能为空");
        Parameters.requireNotNull(pageParam.getCount(),"分页查询参数count不能为空");
        PageResult<ApplyMgtBO> pageResult = pageRepository.selectPaging(ApplyMapper.class,"selectListForMgtByPage",pageParam);
        if(pageResult == null){
            return new PageResult<>(new ArrayList<>(0), 0);
        }
        PageResult<ApplyMgtDetailBO> detailBOPageResult = new PageResult<>();
        BeanUtils.copyProperties(pageResult,detailBOPageResult);
        List<ApplyMgtBO> applyMgtBOs = pageResult.getRows();
        List<ApplyMgtDetailBO> applyMgtDetailBOList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(applyMgtBOs)){
            applyMgtDetailBOList = applyMgtBOs.stream().map(applyMgtBO -> {
                ApplyMgtDetailBO applyMgtDetailBO = new ApplyMgtDetailBO();
                BeanUtils.copyProperties(applyMgtBO, applyMgtDetailBO);
                ApplyStepPO applyReviewStepBO = applyStepMapper.selectByApplyId(applyMgtBO.getApply_id(), ProcessStep.REVIEW.getValue());
                if (applyReviewStepBO == null) {
                    applyMgtDetailBO.setReview_time(null);
                } else {
                    applyMgtDetailBO.setReview_time(applyReviewStepBO.getProcess_time());
                }
                ApplyStepPO applyLoanStepBO = applyStepMapper.selectByApplyId(applyMgtBO.getApply_id(), ProcessStep.LOAN.getValue());
                if (applyLoanStepBO == null) {
                    applyMgtDetailBO.setLoan_time(null);
                } else {
                    applyMgtDetailBO.setLoan_time(applyLoanStepBO.getProcess_time());
                }

                return applyMgtDetailBO;
            }).collect(Collectors.toList());
        }
        detailBOPageResult.setRows(applyMgtDetailBOList);
        return detailBOPageResult;
    }
}
