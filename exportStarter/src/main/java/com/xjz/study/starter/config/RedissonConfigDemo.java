package com.xjz.study.starter.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * User: Administrator
 * Date: 2021-01-27
 * Time: 10:51
 */
@Configuration
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonDemoProperties.class)
public class RedissonConfigDemo {


    @Bean
    public RedissonClient redissonClient(RedissonDemoProperties redissonDemoProperties){
        Config config = new Config();

        String prefix= "redis://";
        if (redissonDemoProperties.isSsl()){
            prefix= "rediss://";
        }

        config.useSingleServer().setAddress(prefix+redissonDemoProperties.getHost()+":"
                +redissonDemoProperties.getPort()).setConnectTimeout(redissonDemoProperties.getTimeout());
        return Redisson.create(config);
    }
}
