//登录参数，放入model模块
package com.mszlu.xt.sso.model.params;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
public class LoginParam {
    private String username;
    private String password;
    //wx回调的传参
    private String code;
    private String state;
    private HttpServletResponse response;
    private HttpServletRequest request;
	
    private String cookieUserId;

}
