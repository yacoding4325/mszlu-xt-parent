package com.mszlu.xt.common.annontation;

import java.lang.annotation.*;

//注解的意义，需要登录信息，但是如果未登录，不进行拦截
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuth {
}
