/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.alibaba.fastjson.JSON;
import com.zhixindu.apply.core.app.DatabaseConfig;
import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.core.apply.dao.ApplyLocationMapper;
import com.zhixindu.apply.facade.apply.bo.ApplyLocationBO;
import com.zhixindu.apply.facade.apply.bo.ApplyAddressBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.apply.bo.ApplyContactBO;
import com.zhixindu.apply.facade.applicant.business.DubboApplicantWechatBusiness;
import com.zhixindu.apply.facade.applicant.enums.WorkState;
import com.zhixindu.apply.facade.apply.business.DubboApplyWechatBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 03/15/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class, DatabaseConfig.class})
@WebAppConfiguration
public class ApplyApplicantWechatBusinessTest {

    @Inject
    private DubboApplicantWechatBusiness applicantWechatBusiness;
    @Inject
    private DubboApplyWechatBusiness applyWechatBusiness;
    @Inject
    private ApplyLocationMapper applyLocationMapper;

    @Test
    public void submitApplyAddressTest() {
        ApplyAddressBO applyAddressBO = new ApplyAddressBO();
        applyAddressBO.setAddress_id(2);
        applyAddressBO.setApplicant_id(20);
        applyAddressBO.setHome_address_code(110101);
        applyAddressBO.setHome_address("aa");
        applyAddressBO.setCompany_name("aaa");
        applyAddressBO.setCompany_address_code(110101);
        applyAddressBO.setCompany_address("xxx");
        applyAddressBO.setWork_state_value(3);
        applyAddressBO.setWork_state(WorkState.STUDENT); // TODO
        Integer addressId = applyWechatBusiness.submitApplyAddress(applyAddressBO);
        System.out.println(addressId);
    }

    @Test
    public void submitApplyContactTest() {
        ApplyContactBO applyContactBO = new ApplyContactBO();
        applyContactBO.setContact_id(1);
        applyContactBO.setApplicant_id(20);
        applyContactBO.setContact_name("张三");
        applyContactBO.setContact_mobile("13122931234");
        applyContactBO.setContact_relationship_value(2);

        ApplyContactBO applyContactBO2 = new ApplyContactBO();
        applyContactBO2.setContact_id(2);
        applyContactBO2.setApplicant_id(20);
        applyContactBO2.setContact_name("张三三");
        applyContactBO2.setContact_mobile("13122931235");
        applyContactBO2.setContact_relationship_value(3);
        List<ApplyContactBO> contactBOList = Arrays.asList(applyContactBO, applyContactBO2);
        List<Integer> contact = applyWechatBusiness.submitApplyContact(contactBOList);
        contact.forEach(System.out::println);
    }

    @Test
    public void testInsertApplyLocation(){
        ApplyLocationBO applyLocationBO = new ApplyLocationBO();
        applyLocationBO.setApply_id(1);
        applyLocationBO.setOpen_id("ozf1Kv_5BoOgKcRuDD2HtWV31bUU");
        applyLocationBO.setLatitude(new BigDecimal(32.12));
        applyLocationBO.setLongitude(new BigDecimal("114.23"));
        applyLocationBO.setPrecision(new BigDecimal(0.6));
        applyLocationMapper.insert(applyLocationBO);
    }

    @Test
    public void testFindApplicant(){
        ApplicantBO applicant = applicantWechatBusiness.findApplicant("201611221147978485279251");
        System.out.println(JSON.toJSONString(applicant));
        System.out.println("applicant.hasNotVerifiedItem():" + applicant.hasNotVerifiedItem());
    }
}
