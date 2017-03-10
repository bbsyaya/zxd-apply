package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.facade.lender.bo.AddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.BankCardBO;
import com.zhixindu.apply.facade.lender.bo.BankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.ContactBO;
import com.zhixindu.apply.facade.lender.bo.FillStepBO;
import com.zhixindu.apply.facade.lender.bo.LenderBaseInfoBO;
import com.zhixindu.apply.facade.lender.bo.MobileVerifyBO;
import com.zhixindu.apply.facade.lender.enums.ApplyResult;
import com.zhixindu.apply.facade.lender.enums.FillStep;
import org.springframework.beans.BeanUtils;
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
        LenderBaseInfoPO lenderBaseInfoPO = new LenderBaseInfoPO();
        BeanUtils.copyProperties(lenderBaseInfoBO, lenderBaseInfoPO);
        lenderBaseInfoPO.setFill_step(FillStep.BASIC_INFO);
        int rows = lenderMapper.insertBaseInfo(lenderBaseInfoPO);
        lenderBaseInfoBO.setLender_id(lenderBaseInfoPO.getLender_id());
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateAddress(AddressBO addressBO) {
        int rows;
        if(null != addressBO.getAddress_id()) {
            rows = lenderAddressMapper.updateByPrimaryKey(addressBO);
        } else {
            rows = lenderAddressMapper.insert(addressBO);
        }
        if(rows > 0) {
            FillStepBO fillStepBO = new FillStepBO(addressBO.getLender_id(), FillStep.CONTACT_INFO);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateContact(List<ContactBO> contactBOList) {
        int rows;
        rows = contactBOList.stream().mapToInt(contactBO -> {
            if(null != contactBO.getContact_id()) {
                return lenderContactMapper.updateByPrimaryKey(contactBO);
            } else {
                return lenderContactMapper.insert(contactBO);
            }
        }).reduce(Integer::sum).orElse(0);
        if(rows > 0) {
            Integer lenderId = contactBOList.stream().map(ContactBO::getLender_id).distinct().findAny().get();
            FillStepBO fillStepBO = new FillStepBO(lenderId, FillStep.CERTIFICATION_INFO);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateBankCard(BankCardBO bankCardBO) {
        int rows;
        if(null != bankCardBO.getBank_id()) {
            rows = lenderBankCardMapper.updateByPrimaryKey(bankCardBO);
        } else {
            rows = lenderBankCardMapper.insert(bankCardBO);
        }
        if(rows > 0) {
            BankCardVerifyBO bankCardVerifyBO = new BankCardVerifyBO();
            bankCardVerifyBO.setLender_id(bankCardBO.getLender_id());
            bankCardVerifyBO.setBank_card_verify(bankCardBO.getBank_card_verify());
            rows += lenderMapper.updateBankCardVerify(bankCardVerifyBO);

            FillStepBO fillStepBO = new FillStepBO(bankCardBO.getLender_id(), FillStep.SUBMIT);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveMobileVerify(MobileVerifyBO mobileVerifyBO) {
        int rows = lenderMapper.updateMobileVerify(mobileVerifyBO);
        if(rows > 0) {
            FillStepBO fillStepBO = new FillStepBO(mobileVerifyBO.getLender_id(), FillStep.SUBMIT);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveApplyResult(ApplyResultBO applyResultBO) {
        if(ApplyResult.APPROVED.matches(applyResultBO.getApply_result())) {
            applyResultBO.setReject_time(null);
        }
        return lenderMapper.updateApplyResult(applyResultBO);
    }

}
