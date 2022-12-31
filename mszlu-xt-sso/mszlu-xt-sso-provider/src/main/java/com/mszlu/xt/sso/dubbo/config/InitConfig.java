package com.mszlu.xt.sso.dubbo.config;

import com.mszlu.xt.sso.domain.repository.TokenDomainRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.mszlu.xt.common.service"})
@Import(TokenDomainRepository.class)
public class InitConfig {
}
