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
import com.zhixindu.apply.facade.lender.bo.LenderMgtAddress;
import com.zhixindu.apply.facade.lender.bo.LenderMgtBankCard;
import com.zhixindu.apply.facade.lender.bo.LenderMgtContact;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceException;
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
    public LenderMgtInfo getLenderInfo(String customer_id) throws ServiceException {
        Parameters.requireNotNull(customer_id,"getLenderInfo customerId illegal_param !");
        LenderPO lender = lenderMapper.selectByCustomerId(customer_id);
        if(null == lender){
            return null;
        }
        LenderMgtInfo lenderMgtInfo = new LenderMgtInfo();
        BeanUtils.copyProperties(lenderMgtInfo,lender);
        BankCardPO lenderBankCard = lenderBankCardMapper.selectByLenderId(lender.getLender_id());
        if(lenderBankCard != null){
            LenderMgtBankCard lenderMgtBankCard = new LenderMgtBankCard();
            BeanUtils.copyProperties(lenderMgtBankCard,lenderBankCard);
            lenderMgtInfo.setLenderMgtBankCard(lenderMgtBankCard);
        }

        List<ContactPO> lenderContacts = lenderContactMapper.selectByLenderId(lender.getLender_id());
        if(CollectionUtils.isNotEmpty(lenderContacts)){
            List<LenderMgtContact> lenderMgtContacts = new ArrayList<>();
            BeanUtils.copyProperties(lenderContacts,lenderMgtContacts);
            lenderMgtInfo.setLenderMgtContacts(lenderMgtContacts);
        }
        AddressPO lenderAddress = lenderAddressMapper.selectByLenderId(lender.getLender_id());
        if(lenderAddress != null){
            LenderMgtAddress lenderMgtAddress = new LenderMgtAddress();
            BeanUtils.copyProperties(lenderMgtAddress,lenderAddress);
            lenderMgtInfo.setLenderMgtAddress(lenderMgtAddress);
        }
        return lenderMgtInfo;
    }
}
