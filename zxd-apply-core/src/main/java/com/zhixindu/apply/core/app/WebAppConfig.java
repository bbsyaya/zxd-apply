package com.zhixindu.apply.core.app;

import com.zhixindu.commons.client.JedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author SteveGuo
 * @version 1.0
 * @date 2017/3/3
 * @description
 */
@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
@ComponentScan(basePackages = {"com.zhixindu.apply.core"})
@PropertySource(value = {"classpath:/apply.properties"})
@ImportResource({"classpath:/spring-dubbo.xml"})
public class WebAppConfig {

    public final static Logger LOGGER = LoggerFactory.getLogger(WebAppConfig.class);

    @Value("${redis.hostName}")
    private String redisHostName;
    @Value("${redis.port}")
    private int redisPort;
    @Value("${redis.timeout}")
    private int redisTimeout;
    @Value("${redis.password}")
    private String redisPassword;
    @Value("${redis.database}")
    private int redisDatabase;

    @Value("${redis.pool.maxIdle}")
    private int redisMaxIdle;
    @Value("${redis.pool.minIdle}")
    private int redisMinIdle;
    @Value("${redis.pool.maxTotal}")
    private int redisMaxTotal;
    @Value("${redis.pool.maxWaitMillis}")
    private int redisMaxWaitMillis;

    @Bean
    public JedisClient jedisClient() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisMaxIdle);
        jedisPoolConfig.setMinIdle(redisMinIdle);
        jedisPoolConfig.setMaxTotal(redisMaxTotal);
        jedisPoolConfig.setMaxWaitMillis(redisMaxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisHostName,redisPort,redisTimeout,redisPassword,redisDatabase);
        JedisClient jedisClient = new JedisClient();
        jedisClient.setJedisPool(jedisPool);
        return jedisClient;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
