package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.service.AdminUserService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author yaCoding
 * @create 2023-01-14 上午 9:53
 */

@Controller
@RequestMapping("xt")
public class AdminMainController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("index")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        //菜单
        CallResult callResult = adminUserService.userMenuList(new AdminUserParam());
        modelAndView.addObject("menuResult",callResult);
        //登录用户
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            modelAndView.addObject("username",userDetails.getUsername());
        }
        modelAndView.setViewName("main");
        return modelAndView;
    }

}
