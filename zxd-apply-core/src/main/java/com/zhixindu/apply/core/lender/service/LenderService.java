package com.zhixindu.apply.core.lender.service;


import com.zhixindu.apply.core.lender.po.AddressPO;
import com.zhixindu.apply.core.lender.po.BankCardPO;
import com.zhixindu.apply.core.lender.po.ContactPO;
import com.zhixindu.apply.core.lender.po.LenderPO;
import com.zhixindu.apply.facade.lender.bo.MobileBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface LenderService {

    int saveLenderBaseInfo(LenderPO lenderPO);

    int saveOrUpdateAddress(AddressPO addressPO);

    int saveOrUpdateContact(List<ContactPO> contactPOList);

    int saveOrUpdateBankCard(BankCardPO bankCardPO);

    int saveMobileVerify(MobileBO mobileBO);

}
