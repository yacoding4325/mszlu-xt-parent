package com.mszlu.xt.sso.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//默认是扫 当前的包 以及子包

@SpringBootApplication
public class SSODubboApp {

    public static void main(String[] args) {
        SpringApplication.run(SSODubboApp.class,args);
    }

}
