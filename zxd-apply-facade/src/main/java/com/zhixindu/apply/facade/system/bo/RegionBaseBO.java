package com.zhixindu.apply.facade.system.bo;

import java.io.Serializable;

/**
 * Created by SteveGuo on 2017/3/8.
 */
public class RegionBaseBO implements Serializable {

    private static final long serialVersionUID = -5055181672798579134L;

    /** 区划代码 */
    private Integer code;
    /** 全名 */
    private String full_name;
    /** 上一级代码 */
    private Integer parent_code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getParent_code() {
        return parent_code;
    }

    public void setParent_code(Integer parent_code) {
        this.parent_code = parent_code;
    }
}
