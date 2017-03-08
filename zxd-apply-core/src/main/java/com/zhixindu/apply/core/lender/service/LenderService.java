package com.zhixindu.apply.core.lender.service;


import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface LenderService {

    int saveLenderBaseInfo(LenderBO lenderBO);

    int saveOrUpdateAddress(AddressBO addressBO);

    int saveOrUpdateContact(List<ContactBO> contactBOList);

    int saveOrUpdateBankCard(BankCardBO bankCardBO);

    int saveMobileVerify(MobileVerifyBO mobileVerifyBO);

    int saveApplyResult(ApplyResultBO applyResultBO);

}
