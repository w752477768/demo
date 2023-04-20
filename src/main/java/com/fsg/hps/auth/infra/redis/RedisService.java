package com.fsg.hps.auth.infra.redis;

import java.util.Collection;
import java.util.Optional;

public interface RedisService {


    void delete(Collection<String> keys);

    Optional<Object> getObject(Object key);

    Boolean putObject(String key,Object value, long expire);

}
