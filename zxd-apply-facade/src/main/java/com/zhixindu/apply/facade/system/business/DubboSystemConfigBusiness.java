package com.zhixindu.apply.facade.system.business;

import com.zhixindu.apply.facade.system.bo.BankBaseBO;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import com.zhixindu.commons.api.ServiceException;

import java.util.List;

/**
 * 系统配置类都会默认先从缓存Redis里面查找，如果找不到再去数据库找
 * Created by SteveGuo on 2017/3/3.
 */
public interface DubboSystemConfigBusiness {

    /**
     * 获取所有的行政区域数据
     * @return
     */
    List<RegionBaseBO> getAllRegion() throws ServiceException;

    /**
     * 获取所有省份列表
     * @return
     */
    List<RegionBaseBO> getProvinceList() throws ServiceException;

    /**
     * 根据父代码获取行政区划
     * @param parentCode
     * @return
     */
    List<RegionBaseBO> getRegionList(Integer parentCode) throws ServiceException;

    /**
     * 根据行政区划代码获取行政区划
     * @param code
     * @return
     */
    RegionBaseBO getRegion(Integer code) throws ServiceException;

    /**
     * 获取行政区域拼接的全称
     * e.g: 320281 -> 江苏省无锡市江阴市
     *      3202 -> 江苏省无锡市
     *      32 -> 江苏省
     * @param code
     * @return
     */
    String getRegionFullName(Integer code) throws ServiceException;

    /**
     * 根据银行卡号获取银行信息
     * @param bankCardNumber
     * @return
     */
    BankBaseBO getBank(String bankCardNumber) throws ServiceException;

    /**
     * 根据行身份证号码获取归属地城市
     * @param idCardNumber
     * @return
     */
    String getAttributionCity(String idCardNumber) throws ServiceException;

}
