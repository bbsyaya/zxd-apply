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
import java.util.stream.Collectors;

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
    public Integer saveLenderBaseInfo(LenderBaseInfoBO lenderBaseInfoBO) {
        LenderBaseInfoPO lenderBaseInfoPO = new LenderBaseInfoPO();
        BeanUtils.copyProperties(lenderBaseInfoBO, lenderBaseInfoPO);
        lenderBaseInfoPO.setFill_step(FillStep.BASIC_INFO);
        lenderMapper.insertBaseInfo(lenderBaseInfoPO);
        lenderBaseInfoBO.setLender_id(lenderBaseInfoPO.getLender_id());
        return lenderBaseInfoPO.getLender_id();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateAddress(LenderAddressBO lenderAddressBO) {
        if(null != lenderAddressBO.getAddress_id()) {
            lenderAddressMapper.updateByPrimaryKey(lenderAddressBO);
        } else {
            lenderAddressMapper.insert(lenderAddressBO);
        }
        FillStepBO fillStepBO = new FillStepBO(lenderAddressBO.getLender_id(), FillStep.CONTACT_INFO);
        lenderMapper.updateFillStep(fillStepBO);
        return lenderAddressBO.getAddress_id();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> saveOrUpdateContact(List<LenderContactBO> lenderContactBOList) {
        List<Integer> contactIdList = lenderContactBOList.stream().map(contactBO -> {
            if (null != contactBO.getContact_id()) {
                lenderContactMapper.updateByPrimaryKey(contactBO);
            } else {
                lenderContactMapper.insert(contactBO);
            }
            return contactBO.getContact_id();
        }).collect(Collectors.toList());
        Integer lenderId = lenderContactBOList.stream().map(LenderContactBO::getLender_id).distinct().findAny().get();
        FillStepBO fillStepBO = new FillStepBO(lenderId, FillStep.CERTIFICATION_INFO);
        lenderMapper.updateFillStep(fillStepBO);
        return contactIdList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveOrUpdateBankCard(LenderBankCardBO lenderBankCardBO) {
        if(null != lenderBankCardBO.getBank_id()) {
            lenderBankCardMapper.updateByPrimaryKey(lenderBankCardBO);
        } else {
            lenderBankCardMapper.insert(lenderBankCardBO);
        }
        BankCardVerifyBO bankCardVerifyBO = new BankCardVerifyBO();
        bankCardVerifyBO.setLender_id(lenderBankCardBO.getLender_id());
        bankCardVerifyBO.setBank_card_verify(lenderBankCardBO.getBank_card_verify());
        lenderMapper.updateBankCardVerify(bankCardVerifyBO);

        FillStepBO fillStepBO = new FillStepBO(lenderBankCardBO.getLender_id(), FillStep.SUBMIT);
        lenderMapper.updateFillStep(fillStepBO);
        return lenderBankCardBO.getBank_id();
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
