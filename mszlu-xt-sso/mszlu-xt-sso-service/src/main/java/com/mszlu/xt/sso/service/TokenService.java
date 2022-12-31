package com.mszlu.xt.sso.service;

public interface TokenService {

    /**
     * token认证
     * @param token
     * @return
     */
    Long checkToken(String token);
}
