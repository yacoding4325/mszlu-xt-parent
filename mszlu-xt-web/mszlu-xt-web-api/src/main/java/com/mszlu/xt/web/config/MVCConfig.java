package com.mszlu.xt.web.config;

import com.mszlu.xt.web.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://www.lzxtedu.com");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/topic/*")
                .addPathPatterns("/subject/*")
                .addPathPatterns("/course/*")
                .addPathPatterns("/order/*")
                .addPathPatterns("/user/*")
                .addPathPatterns("/i/*")
//                .excludePathPatterns("/course/courseList")
                .excludePathPatterns("/subject/listSubjectNew")
                .excludePathPatterns("/course/subjectInfo")
                .excludePathPatterns("/order/notify")
                .excludePathPatterns("/case/*")
                .excludePathPatterns("/wechat/*")
                .excludePathPatterns("/login/wxLoginCallBack")
                .excludePathPatterns("/i/u/*");
//                .excludePathPatterns("/course/courseList");;
    }
}
