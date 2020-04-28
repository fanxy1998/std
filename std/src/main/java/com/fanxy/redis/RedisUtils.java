package com.fanxy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author fanxy
 */
@Component
public class RedisUtils {

    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    public RedisUtils(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 读取缓存
     */
    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写缓存
     */
    public boolean set(String key,String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key,value, 60L * 10L, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     */
    public boolean delete(String key){
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
