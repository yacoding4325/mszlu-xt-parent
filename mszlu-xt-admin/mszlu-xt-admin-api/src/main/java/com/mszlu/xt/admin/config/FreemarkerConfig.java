package com.mszlu.xt.admin.config;

import com.mszlu.xt.admin.template.StringTemplate;
import com.mszlu.xt.admin.template.TimeAgoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author yaCoding
 * @create 2023-01-14 上午 10:43
 */

@Configuration
public class FreemarkerConfig {

    @Autowired
    private StringTemplate stringTemplate;

    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void init(){
        configuration.setSharedVariable(stringTemplate.getName(),stringTemplate);
        configuration.setSharedVariable("timeAgo",new TimeAgoMethod());
    }

}
