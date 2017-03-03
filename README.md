### Apply 申请模块

#### 介绍
  Apply相关接口

#### 编译打包方式
> 执行命令: `gradle clean build -Penv=test` 
> 若需要跳过测试加 `-x test`参数
> 若本地没有安装gradle，则使用gradlew（windows下为gradlew.bat）
> 编译通过生成的war或jar包在目录build/libs/下

#### 主要组件
 1. `com.zhixindu.apply.facade.business.DubboApplyBusiness` 申请业务接口

#### 版本历史

v0.1 初始版本
  1. 迁移聚信立、闪银等接口
  2. 对外提供查询报告、查询信息等接口
  3. 对接融360、算话、考拉等接口
