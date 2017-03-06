package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.AddressPO;
import com.zhixindu.apply.core.lender.po.BankCardPO;
import com.zhixindu.apply.core.lender.po.ContactPO;
import com.zhixindu.apply.core.lender.po.LenderPO;
import com.zhixindu.apply.facade.lender.bo.MobileBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/6.
 */
@Service("lenderService")
public class LenderServiceImpl implements LenderService {

    @Inject
    private LenderMapper lenderMapper;
    @Inject
    private LenderAddressMapper lenderAddressMapper;
    @Inject
    private LenderContactMapper lenderContactMapper;
    @Inject
    private LenderBankCardMapper lenderBankCardMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveLenderBaseInfo(LenderPO lenderPO) {
        return lenderMapper.insertSelective(lenderPO);
    }

    @Override
    public int saveOrUpdateAddress(AddressPO addressPO) {
        return 0;
    }

    @Override
    public int saveOrUpdateContact(List<ContactPO> contactPOList) {
        return 0;
    }

    @Override
    public int saveOrUpdateBankCard(BankCardPO bankCardPO) {
        return 0;
    }

    @Override
    public int saveMobileVerify(MobileBO mobileBO) {
        return 0;
    }


}
