package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.BankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;
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
    public int saveLenderBaseInfo(LenderBaseInfoBO lenderBaseInfoBO) {
        return lenderMapper.insertBaseInfo(lenderBaseInfoBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateAddress(AddressBO addressBO) {
        if(null != addressBO.getAddress_id()) {
            return lenderAddressMapper.updateByPrimaryKey(addressBO);
        } else {
            return lenderAddressMapper.insert(addressBO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateContact(List<ContactBO> contactBOList) {
       return contactBOList.stream().mapToInt(contactBO -> {
            if(null != contactBO.getContact_id()) {
                return lenderContactMapper.updateByPrimaryKey(contactBO);
            } else {
                return lenderContactMapper.insert(contactBO);
            }
        }).reduce(Integer::sum).orElse(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateBankCard(BankCardBO bankCardBO) {
        int result;
        if(null != bankCardBO.getBank_id()) {
            result = lenderBankCardMapper.updateByPrimaryKey(bankCardBO);
        } else {
            result = lenderBankCardMapper.insert(bankCardBO);
        }
        if(result > 0) {
            BankCardVerifyBO bankCardVerifyBO = new BankCardVerifyBO();
            bankCardVerifyBO.setLender_id(bankCardBO.getLender_id());
            bankCardVerifyBO.setBank_card_verify(bankCardBO.getBank_card_verify());
            result = lenderMapper.updateBankCardVerify(bankCardVerifyBO);
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(MobileVerifyBO mobileVerifyBO) {
        return lenderMapper.updateMobileVerify(mobileVerifyBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveApplyResult(ApplyResultBO applyResultBO) {
        return lenderMapper.updateApplyResult(applyResultBO);
    }

}
