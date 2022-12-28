package com.mszlu.xt.sso.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.sso.model.params.LoginParam;

public interface LoginService {
    /**
     * 获取微信扫码的二维码链接地址
     * @return
     */
    CallResult getQRCodeUrl();

    /**
     * 当用户扫码授权之后，进行的登录回调操作
     * @param loginParam
     * @return
     */
    CallResult wxLoginCallBack(LoginParam loginParam);

    /**
     * 公众号授权的路径
     * @return
     */
    String authorize();
    /**
     * 公众号进行授权后，进行的登录回调操作
     * @param loginParam
     * @return
     */
    CallResult wxGzhLoginCallBack(LoginParam loginParam);
}
