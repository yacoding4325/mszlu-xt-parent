package com.mszlu.xt.sso.service;

import com.mszlu.xt.common.model.CallResult;

public interface UserService {
    /**
     * 获取用户登录信息
     * @return
     */
    CallResult userInfo();
}
