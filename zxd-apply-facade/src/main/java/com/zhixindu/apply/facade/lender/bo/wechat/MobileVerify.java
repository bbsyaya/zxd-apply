package com.zhixindu.apply.facade.lender.bo.wechat;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/6.
 */
public class MobileVerify implements Serializable{

    private static final long serialVersionUID = 7938297459259413833L;

    /** 借款人ID */
    private Integer lender_id;
    /** 手机号 */
    private String mobile;
    /** 服务密码 */
    private String service_password;

}
