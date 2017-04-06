package com.zhixindu.apply.core.test;

import com.zhixindu.apply.core.app.WebAppConfig;
import com.zhixindu.apply.core.system.dao.BankMapper;
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
public class BankBusinessTest {

    @Inject
    private BankMapper bankMapper;

    @Test
    public void testSelectBankNameByBin(){
    }

}