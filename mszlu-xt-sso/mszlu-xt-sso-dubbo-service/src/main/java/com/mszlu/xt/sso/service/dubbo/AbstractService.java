package com.mszlu.xt.sso.service.dubbo;

import com.mszlu.xt.common.service.ServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//抽象服务
public abstract class AbstractService {

    @Autowired
    protected ServiceTemplate serviceTemplate;

}
