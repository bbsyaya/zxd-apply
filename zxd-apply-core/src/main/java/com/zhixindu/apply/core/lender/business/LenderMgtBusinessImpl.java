package com.zhixindu.apply.core.lender.business;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.domain.Lender;
import com.zhixindu.apply.core.lender.domain.LenderBankCard;
import com.zhixindu.apply.facade.lender.bo.LenderMgtBankCard;
import com.zhixindu.apply.facade.lender.bo.LenderMgtInfo;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.api.ServiceException;
import com.zhixindu.commons.utils.Parameters;
import org.springframework.beans.BeanUtils;

import javax.inject.Inject;

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
        Parameters.requireNotNull(customer_id,"getVerifyInfo customerId illegal_param !");
        Lender lender = lenderMapper.selectByCustomerId(customer_id);
        if(null == lender){
            return null;
        }
        LenderMgtInfo lenderMgtInfo = new LenderMgtInfo();
        LenderBankCard lenderBankCard = lenderBankCardMapper.selectByLenderId(lender.getLender_id());
        if(lenderBankCard != null){
            LenderMgtBankCard lenderMgtBankCard = new LenderMgtBankCard();
            BeanUtils.copyProperties(lenderMgtBankCard,lenderBankCard);
            lenderMgtInfo.setLenderMgtBankCard(lenderMgtBankCard);
        }
        return null;
    }

}
