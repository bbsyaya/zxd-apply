package com.zhixindu.apply.core.system.cache;

import com.zhixindu.apply.core.system.dao.BankMapper;
import com.zhixindu.apply.facade.system.bo.BankBaseBO;
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
public class BankCacheManager {

    private ConcurrentMap<Integer, BankBaseBO> CACHE = new ConcurrentHashMap<>();

    @Inject
    private BankMapper bankMapper;

    @PostConstruct
    public void load(){
        CACHE.clear();
        List<BankBaseBO> bankBaseBOList = bankMapper.selectAll();
        bankBaseBOList.parallelStream().forEach(bankBaseBO -> CACHE.putIfAbsent(bankBaseBO.getBin(), bankBaseBO));
    }

    /**
     * 获取所有的行政区域数据
     * @return
     */
    public List<BankBaseBO> getAllBank(){
        return CACHE.values().parallelStream().collect(Collectors.toList());
    }

    /**
     * 根据bin获取银行名称
     * @param bin
     * @return
     */
    public Optional<BankBaseBO> getBank(Integer bin){
        if(CACHE.containsKey(bin)) {
            return Optional.of(CACHE.get(bin));
        }
        return Optional.empty();
    }

    @PreDestroy
    public void destory(){
        CACHE.clear();
        CACHE = null;
    }

}
