### Apply 申请模块

#### 介绍
  贷前申请相关接口

#### 编译打包方式
> 执行命令: `gradle clean build -Penv=test` 
> 若需要跳过测试加 `-x test`参数
> 若本地没有安装gradle，则使用gradlew（windows下为gradlew.bat）
> 编译通过生成的war或jar包在目录build/libs/下

#### 主要组件
 1. `com.zhixindu.apply.facade.lender.business.DubboApplyApplicantWechatBusiness` 申请人Wechat业务接口
 2. `com.zhixindu.apply.facade.lender.business.DubboApplyApplicantMgtBusiness` 申请人Mgt业务接口
 3. `com.zhixindu.apply.facade.loan.business.DubboApplyLoanWechatBusiness` 贷款申请Wechat业务接口
 4. `com.zhixindu.apply.facade.loan.business.DubboApplyLoanMgtBusiness` 贷款申请Mgt业务接口
 5. `com.zhixindu.apply.facade.system.business.DubboApplySystemConfigBusiness` 系统配置业务接口

#### 版本历史

v0.1 初始版本
  1. 提供提交贷前申请、查询，提交贷款申请、查询，行政区域查询业务接口
