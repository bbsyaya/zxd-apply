package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.core.lender.dao.LenderContactMapper;
import com.zhixindu.apply.core.lender.dao.LenderMapper;
import com.zhixindu.apply.core.lender.po.LenderBaseInfoPO;
import com.zhixindu.apply.core.lender.service.LenderService;
import com.zhixindu.apply.facade.lender.bo.LenderMobileVerifyBO;
import com.zhixindu.apply.facade.lender.enums.LoanFillStep;
import com.zhixindu.apply.facade.lender.enums.MobileVerify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class LenderWechatBusinessTest {

    @Inject
    private LenderMapper lenderMapper;
    @Inject
    private LenderService lenderService;
    @Inject
    private LenderContactMapper lenderContactMapper;

    @Test
    public void testUpdateMobileVerify(){
        LenderMobileVerifyBO lenderMobileVerifyBO = new LenderMobileVerifyBO();
        lenderMobileVerifyBO.setLender_id(1);
        lenderMobileVerifyBO.setMobile("17091918167");
        lenderMobileVerifyBO.setMobile_verify(MobileVerify.VERIFIED);
        //System.out.println(lenderMapper.updateMobileVerify(lenderMobileVerifyBO));
    }

    @Test
    public void testSelectByCustomerId(){
        System.out.println(lenderMapper.selectByCustomerId("123"));
    }

    @Test
    public void testInserBaseInfo(){
        LenderBaseInfoPO lenderBaseInfoPO = new LenderBaseInfoPO();
        lenderBaseInfoPO.setCustomer_id("1298765");
        lenderBaseInfoPO.setMobile("18766223455");
        lenderBaseInfoPO.setId_card("3565778765431");
        lenderBaseInfoPO.setName("abc2");
        lenderBaseInfoPO.setLoan_fill_step(LoanFillStep.BASIC_INFO);
        System.out.println(lenderService.saveLenderBaseInfo(lenderBaseInfoPO));
        System.out.println(lenderBaseInfoPO.getLender_id());
    }

    @Test
    public void testSelectPrimaryKeyByLenderId(){
        System.out.println(lenderContactMapper.selectPrimaryKeyByLenderId(30));
    }

    @Test
    public void testResetMobileVerify(){
        System.out.println(lenderMapper.resetMobileVerify(83, "18765434567"));
    }
}
