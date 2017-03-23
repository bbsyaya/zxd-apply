package com.zhixindu.apply.facade.system.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class BankBaseBO implements Serializable {

    private static final long serialVersionUID = 6951825101275435014L;
    /** 银行ID */
    private Integer bank_id;
    /** 发卡行识别码（银行卡bin号） */
    private Integer bin;
    /** 银行名称 */
    private String bank_name;

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
