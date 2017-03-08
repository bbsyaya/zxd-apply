package com.zhixindu.apply.core.system.exception;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class UnSupportedBankException extends RuntimeException{
    private static final long serialVersionUID = -6164806397581581037L;

    public UnSupportedBankException(){
        super("不支持该银行");
    }

}
