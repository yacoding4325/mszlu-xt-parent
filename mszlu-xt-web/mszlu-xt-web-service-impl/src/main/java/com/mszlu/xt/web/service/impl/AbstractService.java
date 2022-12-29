package com.mszlu.xt.web.service.impl;

import com.mszlu.xt.common.service.ServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 3:02
 */

public abstract class AbstractService {

    @Autowired
    protected ServiceTemplate serviceTemplate;

}
