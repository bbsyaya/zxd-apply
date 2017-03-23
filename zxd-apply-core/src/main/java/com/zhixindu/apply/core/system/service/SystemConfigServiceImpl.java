package com.zhixindu.apply.core.system.service;

import com.zhixindu.apply.core.system.cache.RegionCacheManager;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import com.zhixindu.commons.api.ServiceCode;
import com.zhixindu.commons.api.ServiceException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by SteveGuo on 2017/3/16.
 */
@Service("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService {

    @Inject
    private RegionCacheManager regionCacheManager;

    @Override
    public String getRegionFullName(Integer code) {
        StringBuilder builder = new StringBuilder(16);
        RegionBaseBO regionBaseBO = regionCacheManager.getRegion(code);
        if(null == regionBaseBO) {
            throw new ServiceException(ServiceCode.NO_RESULT, String.format("无法找到code[%1$d]的行政区划数据", code));
        }
        if(null != regionBaseBO.getParent_code()) {
            builder.append(getRegionFullName(regionBaseBO.getParent_code()));
        }
        builder.append(regionBaseBO.getFull_name());
        return builder.toString();
    }

}
