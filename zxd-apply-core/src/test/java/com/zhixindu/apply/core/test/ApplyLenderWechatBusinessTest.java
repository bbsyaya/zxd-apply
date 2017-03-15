/*
 * Copyright (C) 2016 YuWei. All rights reserved.
 * You can get our information at http://www.zhixindu.com
 * Anyone can't use this file without our permission.
 */
package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.DatabaseConfig;
import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.facade.lender.bo.LenderAddressBO;
import com.zhixindu.apply.facade.lender.bo.LenderContactBO;
import com.zhixindu.apply.facade.lender.business.DubboApplyLenderWechatBusiness;
import com.zhixindu.apply.facade.lender.enums.WorkState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 03/15/2017
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class, DatabaseConfig.class})
@WebAppConfiguration
public class ApplyLenderWechatBusinessTest {

    @Inject
    private DubboApplyLenderWechatBusiness lenderWechatBusiness;

    @Test
    public void submitLenderAddressTest() {
        LenderAddressBO lenderAddressBO = new LenderAddressBO();
        lenderAddressBO.setAddress_id(2);
        lenderAddressBO.setLender_id(20);
        lenderAddressBO.setHome_address_code(110101);
        lenderAddressBO.setHome_address("aa");
        lenderAddressBO.setCompany_name("aaa");
        lenderAddressBO.setCompany_address_code(110101);
        lenderAddressBO.setCompany_address("xxx");
        lenderAddressBO.setWork_state_value(3);
        lenderAddressBO.setWork_state(WorkState.STUDENT); // TODO
        Integer addressId = lenderWechatBusiness.submitLenderAddress(lenderAddressBO);
        System.out.println(addressId);
    }

    @Test
    public void submitLenderContactTest() {
        LenderContactBO lenderContactBO = new LenderContactBO();
        lenderContactBO.setLender_id(20);
        lenderContactBO.setContact_name("张三");
        lenderContactBO.setContact_mobile("13122931234");
        lenderContactBO.setRelationship_value(2);

        LenderContactBO lenderContactBO2 = new LenderContactBO();
        lenderContactBO2.setLender_id(20);
        lenderContactBO2.setContact_name("张三三");
        lenderContactBO2.setContact_mobile("13122931235");
        lenderContactBO2.setRelationship_value(3);
        List<Integer> contact = lenderWechatBusiness.submitLenderContact(Arrays.asList(lenderContactBO, lenderContactBO2));
        contact.forEach(System.out::println);
    }

}
