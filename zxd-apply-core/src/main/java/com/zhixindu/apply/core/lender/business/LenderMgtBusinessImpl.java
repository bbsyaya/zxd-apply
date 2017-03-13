package com.zhixindu.apply.core.lender.business;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.system.business.SystemConfigBusinessImpl;
import com.zhixindu.apply.core.system.dao.RegionMapper;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderAddressMgtBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.apply.facade.lender.bo.LenderMgtQueryParm;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderMgtBusiness;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
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
@Business("lenderMgtBusiness")
public class LenderMgtBusinessImpl implements DubboApplyLenderMgtBusiness {

    @Inject
    private LenderMapper lenderMapper;

    @Inject
    private LenderContactMapper lenderContactMapper;

    @Inject
    private LenderBankCardMapper lenderBankCardMapper;

    @Inject
    private LenderAddressMapper lenderAddressMapper;

    @Inject
    private SystemConfigBusinessImpl systemConfigBusiness;

    @Override
    public PageResult<LenderInfoBO> findLenderInfoByPage(LenderMgtQueryParm param) throws ServiceException {
        return null;
    }

    @Override
    public LenderMgtInfo findLenderInfo(Integer lender_id) throws ServiceException {
        Parameters.requireNotNull(lender_id,"findLenderInfo lender_id illegal_param !");
        LenderBO lender = lenderMapper.selectByPrimaryKey(lender_id);
        if(null == lender){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询的申请信息无结果!!!");
        }
        LenderMgtInfo lenderMgtInfo = new LenderMgtInfo();
        BeanUtils.copyProperties(lender,lenderMgtInfo);
        LenderBankCardBO lenderBankCardBO = lenderBankCardMapper.selectByLenderId(lender.getLender_id());
        if(lenderBankCardBO != null){
            lenderMgtInfo.setLenderBankCardBO(lenderBankCardBO);
        }

        List<LenderContactBO> lenderContactBOList = lenderContactMapper.selectByLenderId(lender.getLender_id());
        if(CollectionUtils.isNotEmpty(lenderContactBOList)){
            lenderMgtInfo.setLenderContactBOS(lenderContactBOList);
        }
        LenderAddressBO lenderAddressBO = lenderAddressMapper.selectByLenderId(lender.getLender_id());
        if(lenderAddressBO != null){
            LenderAddressMgtBO lenderAddressMgtBO = new LenderAddressMgtBO();
            BeanUtils.copyProperties(lenderAddressBO,lenderAddressMgtBO);
            if(null != lenderAddressBO.getHome_address_code()){
                String homeAddressInfo = systemConfigBusiness.getRegionFullName(lenderAddressBO.getHome_address_code());
                lenderAddressMgtBO.setHome_address_info(homeAddressInfo);
            }
            if(null != lenderAddressBO.getCompany_address_code()) {
                String companyAddressInfo = systemConfigBusiness.getRegionFullName(lenderAddressBO.getCompany_address_code());
                lenderAddressMgtBO.setCompany_address_info(companyAddressInfo);
            }
            lenderMgtInfo.setLenderAddressMgtBO(lenderAddressMgtBO);
        }
        return lenderMgtInfo;
    }
}
