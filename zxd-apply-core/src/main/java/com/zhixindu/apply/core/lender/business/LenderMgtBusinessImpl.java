package com.zhixindu.apply.core.lender.business;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.apply.facade.lender.bo.LenderMgtQueryParm;
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
public class LenderMgtBusinessImpl implements LenderMgtBusiness {

    @Inject
    private LenderMapper lenderMapper;

    @Inject
    private LenderContactMapper lenderContactMapper;

    @Inject
    private LenderBankCardMapper lenderBankCardMapper;

    @Inject
    private LenderAddressMapper lenderAddressMapper;

    @Override
    public PageResult<LenderInfoBO> findLenderInfoByPage(LenderMgtQueryParm param) throws ServiceException {
        return null;
    }

    @Override
    public LenderMgtInfo getLenderInfo(String customer_id) throws ServiceException {
        Parameters.requireNotNull(customer_id,"getLenderInfo customerId illegal_param !");
        LenderBO lender = lenderMapper.selectByCustomerId(customer_id);
        if(null == lender){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询的申请信息无结果!!!");
        }
        LenderMgtInfo lenderMgtInfo = new LenderMgtInfo();
        BeanUtils.copyProperties(lenderMgtInfo,lender);
        BankCardBO bankCardBO = lenderBankCardMapper.selectByLenderId(lender.getLender_id());
        if(bankCardBO != null){
            lenderMgtInfo.setBankCardBO(bankCardBO);
        }

        List<ContactBO> contactBOList = lenderContactMapper.selectByLenderId(lender.getLender_id());
        if(CollectionUtils.isNotEmpty(contactBOList)){
            lenderMgtInfo.setContactBOs(contactBOList);
        }
        AddressBO addressBO = lenderAddressMapper.selectByLenderId(lender.getLender_id());
        if(addressBO != null){
            lenderMgtInfo.setAddressBO(addressBO);
        }
        return lenderMgtInfo;
    }
}
