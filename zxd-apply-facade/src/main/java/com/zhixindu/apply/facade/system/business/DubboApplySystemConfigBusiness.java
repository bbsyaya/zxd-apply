package com.zhixindu.apply.facade.system.business;

import com.zhixindu.apply.facade.system.bo.RegionBaseBO;

import java.util.List;

/**
 * 系统配置类都会默认先从缓存Redis里面查找，如果找不到再去数据库找
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboApplySystemConfigBusiness {

    /**
     * 获取所有的行政区域数据
     * @return
     */
    List<RegionBaseBO> getAllRegion();

    /**
     * 获取所有省份列表
     * @return
     */
    List<RegionBaseBO> getProvinceList();

    /**
     * 根据父代码获取行政区划
     * @param parentCode
     * @return
     */
    List<RegionBaseBO> getRegionList(Integer parentCode);

    /**
     * 根据行政区划代码获取行政区划
     * @param code
     * @return
     */
    RegionBaseBO getRegion(Integer code);

    /**
     * 根据银行卡号获取银行名称
     * @param bankCardNumber
     * @return
     */
    String getBankName(Integer bankCardNumber);


}
