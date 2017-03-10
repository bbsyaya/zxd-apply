package com.zhixindu.apply.core.lender.service;

import com.zhixindu.apply.core.lender.dao.LenderAddressMapper;
import com.zhixindu.apply.core.lender.dao.LenderBankCardMapper;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.ApplyResultBO;
import com.zhixindu.apply.facade.lender.bo.LenderBankCardBO;
import com.zhixindu.apply.facade.lender.bo.BankCardVerifyBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
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

    @Override
    public boolean isExistLender(String customerId) {
        return lenderMapper.countByCustomerId(customerId) > 0;
    }

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
    public int saveOrUpdateAddress(LenderAddressBO lenderAddressBO) {
        int rows;
        if(null != lenderAddressBO.getAddress_id()) {
            rows = lenderAddressMapper.updateByPrimaryKey(lenderAddressBO);
        } else {
            rows = lenderAddressMapper.insert(lenderAddressBO);
        }
        if(rows > 0) {
            FillStepBO fillStepBO = new FillStepBO(lenderAddressBO.getLender_id(), FillStep.CONTACT_INFO);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateContact(List<LenderContactBO> lenderContactBOList) {
        int rows;
        rows = lenderContactBOList.stream().mapToInt(contactBO -> {
            if(null != contactBO.getContact_id()) {
                return lenderContactMapper.updateByPrimaryKey(contactBO);
            } else {
                return lenderContactMapper.insert(contactBO);
            }
        }).reduce(Integer::sum).orElse(0);
        if(rows > 0) {
            Integer lenderId = lenderContactBOList.stream().map(LenderContactBO::getLender_id).distinct().findAny().get();
            FillStepBO fillStepBO = new FillStepBO(lenderId, FillStep.CERTIFICATION_INFO);
            rows += lenderMapper.updateFillStep(fillStepBO);
        }
        return rows;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveOrUpdateBankCard(LenderBankCardBO lenderBankCardBO) {
        int rows;
        if(null != lenderBankCardBO.getBank_id()) {
            rows = lenderBankCardMapper.updateByPrimaryKey(lenderBankCardBO);
        } else {
            rows = lenderBankCardMapper.insert(lenderBankCardBO);
        }
        if(rows > 0) {
            BankCardVerifyBO bankCardVerifyBO = new BankCardVerifyBO();
            bankCardVerifyBO.setLender_id(lenderBankCardBO.getLender_id());
            bankCardVerifyBO.setBank_card_verify(lenderBankCardBO.getBank_card_verify());
            rows += lenderMapper.updateBankCardVerify(bankCardVerifyBO);

            FillStepBO fillStepBO = new FillStepBO(lenderBankCardBO.getLender_id(), FillStep.SUBMIT);
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
