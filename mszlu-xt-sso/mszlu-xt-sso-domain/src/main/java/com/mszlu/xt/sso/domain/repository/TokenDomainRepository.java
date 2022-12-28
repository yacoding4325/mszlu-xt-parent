package com.mszlu.xt.sso.domain.repository;

import com.mszlu.xt.sso.domain.TokenDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenDomainRepository {

    @Autowired
    public StringRedisTemplate redisTemplate;

    public TokenDomain createDomain() {
        return new TokenDomain(this);
    }
}
