package com.mszlu.xt.web.config;

import com.mszlu.xt.common.cache.EnableCache;
import com.mszlu.xt.common.service.EnableService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.mszlu.xt.common.cache","com.mszlu.xt.common.service"})
@EnableCache
@EnableService
public class InitConfig {
}
