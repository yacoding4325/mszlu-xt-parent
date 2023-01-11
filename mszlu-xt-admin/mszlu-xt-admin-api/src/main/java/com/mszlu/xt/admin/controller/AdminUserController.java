package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.service.AdminUserService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2023-01-11 下午 11:04
 */
@RestController
@RequestMapping("user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "role/findRolePage")
    public CallResult findRolePage(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findRolePage(adminUserParam);
    }

}
