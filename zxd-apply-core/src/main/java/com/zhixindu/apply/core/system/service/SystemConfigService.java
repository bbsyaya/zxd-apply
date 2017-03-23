package com.zhixindu.apply.core.system.service;

/**
 * Created by SteveGuo on 2017/3/16.
 */
public interface SystemConfigService {

    /**
     * 获取省市区的全称
     * @param code
     * @return
     */
    String getRegionFullName(Integer code);

}
