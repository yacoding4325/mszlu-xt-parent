package com.mszlu.xt.sso.domain;

import com.mszlu.xt.common.constants.RedisKey;
import com.mszlu.xt.common.utils.JwtUtil;
import com.mszlu.xt.sso.domain.repository.TokenDomainRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class TokenDomain {

    private TokenDomainRepository tokenDomainRepository;

    public TokenDomain(TokenDomainRepository tokenDomainRepository) {
        this.tokenDomainRepository = tokenDomainRepository;
    }

    public Long checkToken(String token) {
        /**
         * 1. 检测token字符串是否合法
         * 2. 检测redis是否有此token
         */
        try {
            JwtUtil.parseJWT(token,LoginDomain.secretKey);
            String userIdStr = tokenDomainRepository.redisTemplate.opsForValue().get(RedisKey.TOKEN + token);
            if (StringUtils.isBlank(userIdStr)){
                return null;
            }
            return Long.parseLong(userIdStr);
        }catch (Exception e){
            e.printStackTrace();
            log.error("checkToken error:{}",e.getMessage(),e);
            return null;
        }
    }
}
