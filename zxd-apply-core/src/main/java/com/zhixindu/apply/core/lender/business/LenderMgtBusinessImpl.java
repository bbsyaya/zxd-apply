package com.zhixindu.apply.core.lender.business;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.AddressPO;
import com.zhixindu.apply.core.lender.po.BankCardPO;
import com.zhixindu.apply.core.lender.po.ContactPO;
import com.zhixindu.apply.core.lender.po.LenderPO;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.apply.facade.lender.bo.LenderMgtQueryParm;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.page.PageResult;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;
import java.util.ArrayList;
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
    public PageResult<LenderBO> findLenderInfoByPage(LenderMgtQueryParm param) throws ServiceException {
        return null;
    }

    @Override
    public LenderMgtInfo getLenderInfo(String customer_id) throws ServiceException {
        Parameters.requireNotNull(customer_id,"getLenderInfo customerId illegal_param !");
        LenderPO lender = lenderMapper.selectByCustomerId(customer_id);
        if(null == lender){
            throw new ServiceException(ServiceCode.NO_RESULT,"查询的申请信息无结果!!!");
        }
        LenderMgtInfo lenderMgtInfo = new LenderMgtInfo();
        BeanUtils.copyProperties(lenderMgtInfo,lender);
        BankCardPO bankCardPO = lenderBankCardMapper.selectByLenderId(lender.getLender_id());
        if(bankCardPO != null){
            BankCardBO bankCardBO = new BankCardBO();
            BeanUtils.copyProperties(bankCardBO,bankCardPO);
            lenderMgtInfo.setBankCardBO(bankCardBO);
        }

        List<ContactPO> lenderContacts = lenderContactMapper.selectByLenderId(lender.getLender_id());
        if(CollectionUtils.isNotEmpty(lenderContacts)){
            List<ContactBO> contactBOs = new ArrayList<>();
            BeanUtils.copyProperties(lenderContacts,contactBOs);
            lenderMgtInfo.setContactBOs(contactBOs);
        }
        AddressPO lenderAddress = lenderAddressMapper.selectByLenderId(lender.getLender_id());
        if(lenderAddress != null){
            AddressBO addressBO = new AddressBO();
            BeanUtils.copyProperties(addressBO,lenderAddress);
            lenderMgtInfo.setAddressBO(addressBO);
        }
        return lenderMgtInfo;
    }
}
