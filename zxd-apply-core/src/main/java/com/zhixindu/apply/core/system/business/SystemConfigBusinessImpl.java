package com.zhixindu.apply.core.system.business;

import com.zhixindu.apply.core.system.cache.BankCacheManager;
import com.zhixindu.apply.core.system.cache.IdCardAttributionCacheManager;
import com.zhixindu.apply.core.system.cache.RegionCacheManager;
import com.zhixindu.apply.core.system.enums.BinLength;
import com.zhixindu.apply.core.system.exception.UnSupportedBankException;
import com.zhixindu.apply.core.system.service.SystemConfigService;
import com.zhixindu.apply.facade.system.bo.BankBaseBO;
import com.zhixindu.apply.facade.system.bo.IdCardAttributionBO;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import com.zhixindu.apply.facade.system.business.DubboSystemConfigBusiness;
import com.zhixindu.commons.annotation.Business;
import com.zhixindu.commons.utils.Parameters;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("systemConfigBusiness")
public class SystemConfigBusinessImpl implements DubboSystemConfigBusiness {

    @Inject
    private RegionCacheManager regionCacheManager;
    @Inject
    private BankCacheManager bankCacheManager;
    @Inject
    private IdCardAttributionCacheManager idCardAttributionCacheManager;
    @Inject
    private SystemConfigService systemConfigService;

    @Override
    public List<RegionBaseBO> getAllRegion() {
       return regionCacheManager.getAllRegion();
    }

    @Override
    public List<RegionBaseBO> getProvinceList() {
        return regionCacheManager.getProvinceList();
    }

    @Override
    public List<RegionBaseBO> getRegionList(Integer parentCode) {
        Parameters.requireNotNull(parentCode, "parentCode不能为空");
        return regionCacheManager.getRegionList(parentCode);
    }

    @Override
    public RegionBaseBO getRegion(Integer code) {
        Parameters.requireNotNull(code, "code不能为空");
        return regionCacheManager.getRegion(code);
    }

    @Override
    public String getRegionFullName(Integer code) {
        Parameters.requireNotNull(code, "code不能为空");
        return systemConfigService.getRegionFullName(code);
    }

    @Override
    public BankBaseBO getBank(String bankCardNumber) {
        Parameters.requireNotNull(bankCardNumber, "bankCardNumber不能为空");
        for(BinLength binLength : BinLength.values()) {
            Integer bin = Integer.valueOf(bankCardNumber.substring(0, binLength.getValue()));
            Optional<BankBaseBO> optional = bankCacheManager.getBank(bin);
            if(optional.isPresent()) {
                return optional.get();
            }
        }
        throw new UnSupportedBankException();
    }

    @Override
    public String getAttributionCity(String idCardNumber) {
        Parameters.requireNotNull(idCardNumber, "idCardNumber不能为空");
        Integer regionCode = Integer.valueOf(idCardNumber.substring(0, 6));
        Optional<IdCardAttributionBO> optional = idCardAttributionCacheManager.getIdCardAttribution(regionCode);
        if(optional.isPresent()) {
            return optional.get().getRegion_name();
        }
        return getRegionFullName(Integer.valueOf(idCardNumber.substring(0, 4)));
    }

}
