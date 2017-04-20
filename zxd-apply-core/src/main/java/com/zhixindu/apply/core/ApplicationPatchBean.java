package com.zhixindu.apply.core;

import com.zhixindu.apply.core.apply.dao.ApplyAddressMapper;
import com.zhixindu.apply.core.apply.dao.ApplyBankCardMapper;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.core.apply.dao.ApplyMapper;
import com.zhixindu.apply.core.apply.po.ApplyAddressPO;
import com.zhixindu.apply.core.apply.po.ApplyBankCardPO;
import com.zhixindu.apply.core.apply.po.ApplyContactPO;
import com.zhixindu.apply.core.apply.po.ApplyPO;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by SteveGuo on 2017/4/14.
 */
@Component
public class ApplicationPatchBean implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationPatchBean.class);

    private static final Date PATCH_DATA_TIME = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
                                                    .parseDateTime("2017-04-20 23:59:59")
                                                    .toDate();
    //private static final Date PATCH_DATA_TIME = new Date();

    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private ApplyAddressMapper applyAddressMapper;
    @Autowired
    private ApplyContactMapper applyContactMapper;
    @Autowired
    private ApplyBankCardMapper applyBankCardMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<ApplyPO> applyPOList = applyMapper.selectByApplyTime(PATCH_DATA_TIME);
        if(CollectionUtils.isNotEmpty(applyPOList)) {
        LOGGER.info("开始迁移数据");
            Map<Integer, Long> applicantCountMap = applyPOList.stream().collect(Collectors.groupingBy(ApplyPO::getApplicant_id, Collectors.counting()));
            // 先补全数据
            applicantCountMap.entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .forEach(entry -> {
                        Integer applicantId = entry.getKey();
                        Long count = entry.getValue() - 1;
                        LOGGER.info("补全申请人ID：{}的申请地址信息数据：{}条", applicantId, count);
                        ApplyAddressPO applyAddressPO = applyAddressMapper.selectLatestByApplicantId(applicantId);
                        for(int i=0;i<count;i++) {
                            applyAddressMapper.insert(applyAddressPO);
                        }
                        LOGGER.info("补全申请人ID：{}的联系人信息数据：{}条", applicantId, count * 2);
                        List<ApplyContactPO> applyContactPOList = applyContactMapper.selectByApplicantId(applicantId);
                        for(int i=0;i<count;i++) {
                            applyContactPOList.stream().forEach(applyContactPO -> applyContactMapper.insert(applyContactPO));
                        }
                        LOGGER.info("补全申请人ID：{}的银行卡信息数据：{}条", applicantId, count);
                        ApplyBankCardPO applyBankCardPO = applyBankCardMapper.selectLatestByApplicantId(applicantId);
                        for(int i=0;i<count;i++) {
                            applyBankCardMapper.insert(applyBankCardPO);
                        }
                    });
            // 更新数据
            IntStream.range(0, applyPOList.size())
                    .forEach(index -> {
                        ApplyPO applyPO = applyPOList.get(index);
                        Integer applyId = applyPO.getApply_id();
                        Integer applicantId = applyPO.getApplicant_id();
                        Date applyTime = applyPO.getApply_time();
                        Date updateTime = new Date();

                        List<ApplyAddressPO> applyAddressPOList = applyAddressMapper.selectByApplicantId(applicantId);
                        if(CollectionUtils.isNotEmpty(applyAddressPOList)) {
                            ApplyAddressPO applyAddressPO = applyAddressPOList.get(0);
                            applyAddressPO.setApply_id(applyId);
                            applyAddressPO.setCreate_time(applyTime);
                            applyAddressPO.setUpdate_time(updateTime);
                            applyAddressMapper.updateByPrimaryKeySelective(applyAddressPO);
                            LOGGER.info("更新申请地址信息（address_id：{}）的applyId：{}，create_time：{}，update_time：{}",
                                    applyAddressPO.getAddress_id(), applyId, applyTime, updateTime);
                        }

                        List<ApplyContactPO> applyContactPOList = applyContactMapper.selectByApplicantId(applicantId);
                        if(CollectionUtils.isNotEmpty(applyContactPOList)) {
                            ApplyContactPO applyContactPO = applyContactPOList.get(0);
                            applyContactPO.setApply_id(applyId);
                            applyContactPO.setCreate_time(applyTime);
                            applyContactPO.setUpdate_time(updateTime);
                            applyContactMapper.updateByPrimaryKeySelective(applyContactPO);
                            LOGGER.info("更新申请联系人信息（contact_id：{}）的applyId：{}，create_time：{}，update_time：{}",
                                    applyContactPO.getContact_id(), applyId, applyTime, updateTime);
                            applyContactPO = applyContactPOList.get(1);
                            applyContactPO.setApply_id(applyId);
                            applyContactPO.setCreate_time(applyTime);
                            applyContactPO.setUpdate_time(updateTime);
                            applyContactMapper.updateByPrimaryKeySelective(applyContactPO);
                            LOGGER.info("更新申请联系人信息（contact_id：{}）的applyId：{}，create_time：{}，update_time：{}",
                                    applyContactPO.getContact_id(), applyId, applyTime, updateTime);
                        }

                        List<ApplyBankCardPO> applyBankCardPOList = applyBankCardMapper.selectByApplicantId(applicantId);
                        if(CollectionUtils.isNotEmpty(applyBankCardPOList)) {
                            ApplyBankCardPO applyBankCardPO = applyBankCardPOList.get(0);
                            applyBankCardPO.setApply_id(applyId);
                            applyBankCardPO.setCreate_time(applyTime);
                            applyBankCardPO.setUpdate_time(updateTime);
                            applyBankCardMapper.updateByPrimaryKeySelective(applyBankCardPO);
                            LOGGER.info("更新申请银行卡信息（bank_card_id：{}）的applyId：{}，create_time：{}，update_time：{}",
                                    applyBankCardPO.getBank_card_id(), applyId, applyTime, updateTime);
                        }
                    });
            LOGGER.info("结束迁移数据");
            LOGGER.info("开始校对数据");
            applicantCountMap.entrySet().stream()
                    .forEach(entry -> {
                        Integer applicantId = entry.getKey();
                        Long applicantCount = entry.getValue();
                        int addressCount = applyAddressMapper.countByApplicantId(applicantId);
                        int contactCount = applyContactMapper.countByApplicantId(applicantId);
                        int bankCardCount = applyBankCardMapper.countByApplicantId(applicantId);
                        LOGGER.info("applicantId：{}在申请表的数据有{}条，在申请地址表有{}条，在申请联系人表有{}条，在申请银行卡表有{}条",
                                applicantId, applicantCount, addressCount, contactCount, bankCardCount);
                    });
            LOGGER.info("结束校对数据");
        }
    }

}
