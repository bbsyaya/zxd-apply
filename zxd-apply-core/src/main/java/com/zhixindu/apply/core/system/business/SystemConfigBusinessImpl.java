package com.zhixindu.apply.core.system.business;

import com.zhixindu.apply.core.system.cache.BankCacheManager;
import com.zhixindu.apply.core.system.cache.RegionCacheManager;
import com.zhixindu.apply.core.system.enums.BinLength;
import com.zhixindu.apply.core.system.exception.UnSupportedBankException;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import com.zhixindu.apply.facade.system.business.DubboApplySystemConfigBusiness;
import com.zhixindu.commons.annotation.Business;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SteveGuo on 2017/3/3.
 */
@Business("systemConfigBusiness")
public class SystemConfigBusinessImpl implements DubboApplySystemConfigBusiness {

    @Inject
    private RegionCacheManager regionCacheManager;
    @Inject
    private BankCacheManager bankCacheManager;

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
        return regionCacheManager.getRegionList(parentCode);
    }

    @Override
    public RegionBaseBO getRegion(Integer code) {
        return regionCacheManager.getRegion(code);
    }

    @Override
    public String getRegionFullName(Integer code) {
        StringBuilder builder = new StringBuilder(16);
        RegionBaseBO regionBaseBO = regionCacheManager.getRegion(code);
        if(null != regionBaseBO.getParent_code()) {
            builder.append(getRegionFullName(regionBaseBO.getParent_code()));
        }
        builder.append(regionBaseBO.getFull_name());
        return builder.toString();
    }

    @Override
    public String getBankName(String bankCardNumber) {
        for(BinLength binLength : BinLength.values()) {
            Integer bin = Integer.valueOf(bankCardNumber.substring(0, binLength.getValue()));
            String bankName = bankCacheManager.getBankNameByBin(bin);
            if(StringUtils.isNotBlank(bankName)) {
                return bankName;
            }
        }
        throw new UnSupportedBankException();
    }



}
