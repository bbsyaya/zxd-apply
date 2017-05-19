package com.zhixindu.apply.core.test;

import com.alibaba.fastjson.JSON;
import com.zhixindu.apply.core.app.ApplicationContextConfig;
import com.zhixindu.apply.core.applicant.dao.ApplicantMapper;
import com.zhixindu.apply.core.applicant.po.ApplicantBaseInfoPO;
import com.zhixindu.apply.core.applicant.po.ApplyResultPO;
import com.zhixindu.apply.core.applicant.service.ApplicantService;
import com.zhixindu.apply.core.apply.dao.ApplyContactMapper;
import com.zhixindu.apply.facade.applicant.bo.ApplicantBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMobileVerifyBO;
import com.zhixindu.apply.facade.applicant.bo.ApplicantMoveBO;
import com.zhixindu.apply.facade.applicant.business.DubboApplicantWechatBusiness;
import com.zhixindu.apply.facade.applicant.enums.ApplyResult;
import com.zhixindu.apply.facade.applicant.enums.LoanFillStep;
import com.zhixindu.apply.facade.applicant.enums.MobileVerify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class ApplicantWechatBusinessTest {

    @Inject
    private ApplicantMapper applicantMapper;
    @Inject
    private ApplicantService applicantService;
    @Inject
    private ApplyContactMapper applyContactMapper;
    @Inject
    private DubboApplicantWechatBusiness applicantWechatBusiness;

    @Test
    public void testUpdateMobileVerify(){
        ApplicantMobileVerifyBO applicantMobileVerifyBO = new ApplicantMobileVerifyBO();
        applicantMobileVerifyBO.setApplicant_id(1);
        applicantMobileVerifyBO.setMobile("17091918167");
        applicantMobileVerifyBO.setMobile_verify(MobileVerify.VERIFIED);
    }

    @Test
    public void testSelectByCustomerId(){
        System.out.println(applicantMapper.selectByCustomerId("123"));
    }

    @Test
    public void testInserBaseInfo(){
        ApplicantBaseInfoPO applicantBaseInfoPO = new ApplicantBaseInfoPO();
        applicantBaseInfoPO.setCustomer_id("1298765");
        applicantBaseInfoPO.setMobile("18766223455");
        applicantBaseInfoPO.setId_card("3565778765431");
        applicantBaseInfoPO.setName("abc2");
        applicantBaseInfoPO.setLoan_fill_step(LoanFillStep.BASIC_INFO);
        System.out.println(applicantService.saveApplicantBaseInfo(applicantBaseInfoPO));
        System.out.println(applicantBaseInfoPO.getApplicant_id());
    }

    @Test
    public void testSelectPrimaryKeyByApplyId(){
        System.out.println(applyContactMapper.selectPrimaryKeyByApplyId(30));
    }

    @Test
    public void testResetMobileVerify(){
        System.out.println(applicantMapper.resetMobileVerify(83, "18765434567"));
    }

    @Test
    public void testUpdateApplyResult(){
        ApplyResultPO applyResultPO = new ApplyResultPO();
        applyResultPO.setApplicant_id(43);
        applyResultPO.setApply_result(ApplyResult.REJECT);
        applyResultPO.setReject_time(new Date());
        applicantMapper.updateApplyResult(applyResultPO);
    }

    @Test
    public void testFindApplicant(){
        ApplicantBO applicant = applicantWechatBusiness.findApplicant("201611221147978485279251");
        System.out.println(JSON.toJSONString(applicant));
        System.out.println("applicant.hasNotVerifiedItem():" + applicant.hasNotVerifiedItem());
    }

    @Test
    public void testFindNoCertificationList(){
        List<ApplicantMoveBO> applicantBOList = applicantWechatBusiness.findNoCertificationList();
        for(ApplicantMoveBO applicantBO :applicantBOList){
            System.out.println("safd:"+JSON.toJSONString(applicantBO.getApply_id()));
        }
    }
}
