package com.zhixindu.apply.core.lender.service;


import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;

import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public interface LenderService {

    boolean existLender(String customerId);

    boolean existLenderAddress(Integer lenderId);

    boolean existLenderContact(Integer lenderId);

    boolean existLenderBankCard(Integer lenderId);

    boolean hasMobileVerified(Integer lenderId);

    boolean hasBankCardVerified(Integer lenderId);

    Integer saveLenderBaseInfo(LenderBaseInfoBO lenderBaseInfoBO);

    Integer saveOrUpdateAddress(LenderAddressBO lenderAddressBO);

    List<Integer> saveOrUpdateContact(List<LenderContactBO> lenderContactBOList);

    Integer saveOrUpdateBankCard(LenderBankCardBO lenderBankCardBO);

    int saveMobileVerify(LenderMobileVerifyBO lenderMobileVerifyBO);

}
