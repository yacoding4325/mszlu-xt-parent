package com.mszlu.xt.common.cache;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
//上述的注解使用@Enable开头的注解代替
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CacheAspect.class)
public @interface EnableCache {
}
