package com.zhixindu.apply.core.system.cache;

import com.zhixindu.apply.core.system.dao.IdCardAttributionMapper;
import com.zhixindu.apply.facade.system.bo.IdCardAttributionBO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by SteveGuo on 2017/3/8.
 */
@Component
public class IdCardAttributionCacheManager {

    private ConcurrentMap<Integer, IdCardAttributionBO> CACHE = new ConcurrentHashMap<>();

    @Inject
    private IdCardAttributionMapper idCardAttributionMapper;

    @PostConstruct
    public void load(){
        CACHE.clear();
        List<IdCardAttributionBO> idCardAttributionBOList = idCardAttributionMapper.selectAll();
        idCardAttributionBOList.parallelStream()
                .forEach(idCardAttributionBO -> CACHE.putIfAbsent(idCardAttributionBO.getRegion_code(), idCardAttributionBO));
    }

    /**
     * 获取所有的行政区域数据
     * @return
     */
    public List<IdCardAttributionBO> getAllIdCardAttribution(){
        return CACHE.values().parallelStream().collect(Collectors.toList());
    }

    /**
     * 根据regionCode获取归属地信息
     * @param regionCode
     * @return
     */
    public Optional<IdCardAttributionBO> getIdCardAttribution(Integer regionCode){
        if(CACHE.containsKey(regionCode)) {
            return Optional.of(CACHE.get(regionCode));
        }
        return Optional.empty();
    }

    @PreDestroy
    public void destory(){
        CACHE.clear();
        CACHE = null;
    }

}
