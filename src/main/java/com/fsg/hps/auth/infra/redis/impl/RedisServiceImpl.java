package com.fsg.hps.auth.infra.redis.impl;

import com.fsg.hps.auth.infra.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public void delete(Collection<String> keys) {
        try {
            redisTemplate.delete(keys);
        } catch (Exception e) {
            log.error("RedisService :delete error occurs when remove keys from redis {}", e.getMessage());
        }
    }

    @Override
    public Optional<Object> getObject(Object key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    @SuppressWarnings("unchecked")
    public Boolean putObject(String key, Object value, long expire) {
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (ifAbsent != null && ifAbsent) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return ifAbsent;
    }



}
