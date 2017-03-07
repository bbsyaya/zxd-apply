package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.LenderBO;
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
    public int saveLenderBaseInfo(LenderBO lenderBO) {
        return lenderMapper.insertSelective(lenderBO);
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
            result = lenderMapper.updateBankCardVerify(bankCardBO.getLender_id(), bankCardBO.getBank_card_verify());
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(MobileBO mobileBO) {
        return lenderMapper.updateMobileVerify(mobileBO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveCreditSituation(Integer lenderId, String creditSituation) {
        return lenderMapper.updateCreditSituation(lenderId, creditSituation);
    }

}
