package com.mszlu.xt.sso.api;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private UserService userService;

    // user/userInfo

    @PostMapping("userInfo")
    public CallResult userInfo(){
        return userService.userInfo();
    }
}
