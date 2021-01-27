package com.xjz.study.starter.controller;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * User: Administrator
 * Date: 2021-01-27
 * Time: 11:11
 */
@RestController
@RequestMapping(value = "/redisson/start")
public class RedissonStartController {

    @Autowired
    private RedissonClient redissonClient;

    private Redisson redisson;
    @GetMapping(value = "/test")
    public String startDemo(){
        RBucket<String> bucket = redissonClient.getBucket("name");
        if (bucket.get() ==null){
            bucket.set("com.xjz.redisson");
        }

        return bucket.get();
    }
}
