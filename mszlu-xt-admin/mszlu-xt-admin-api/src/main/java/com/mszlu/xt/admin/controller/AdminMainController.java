package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.service.AdminUserService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("xt")
public class AdminMainController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("index")
    public ModelAndView mainPage(){

        ModelAndView modelAndView = new ModelAndView();
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            modelAndView.addObject("username",userDetails.getUsername());
        }
        CallResult callResult = adminUserService.userMenuList(new AdminUserParam());
        modelAndView.addObject("menuList",callResult.getResult());
        modelAndView.setViewName("main");
        return modelAndView;
    }


    @RequestMapping("test")
    public ModelAndView test(Integer flag,String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("flag",flag);
        modelAndView.addObject("user",name);
        modelAndView.addObject("date",new Date());
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
