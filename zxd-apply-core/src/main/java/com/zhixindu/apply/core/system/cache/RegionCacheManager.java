package com.zhixindu.apply.core.system.cache;

import com.zhixindu.apply.core.system.dao.RegionMapper;
import com.zhixindu.apply.facade.system.bo.RegionBaseBO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/8.
 */
@Component
public class RegionCacheManager {

    private ConcurrentMap<Integer, RegionBaseBO> CACHE = new ConcurrentHashMap<>();

    @Inject
    private RegionMapper regionMapper;

    @PostConstruct
    public void load(){
        CACHE.clear();
        List<RegionBaseBO> regionBaseBOList = regionMapper.selectAll();
        regionBaseBOList.parallelStream().forEach(regionBaseBO -> CACHE.putIfAbsent(regionBaseBO.getCode(), regionBaseBO));
    }

    /**
     * 获取所有的行政区域数据
     * @return
     */
    public List<RegionBaseBO> getAllRegion(){
        return CACHE.values().parallelStream().collect(Collectors.toList());
    }

    /**
     * 获取所有的省份列表
     * @return
     */
    public List<RegionBaseBO> getProvinceList(){
        return getAllRegion().parallelStream()
                .filter(regionBaseBO -> regionBaseBO.getParent_code() == null)
                .collect(Collectors.toList());
    }

    /**
     * 根据附代码获取行政区域
     * @param parentCode
     * @return
     */
    public List<RegionBaseBO> getRegionList(Integer parentCode){
        return getAllRegion().parallelStream()
                .filter(regionBaseBO -> parentCode.intValue() == regionBaseBO.getParent_code()
                ).collect(Collectors.toList());
    }

    /**
     *
     * @param code
     * @return
     */
    public RegionBaseBO getRegion(Integer code){
        return CACHE.get(code);
    }

    @PreDestroy
    public void destory(){
        CACHE.clear();
        CACHE = null;
    }

}
