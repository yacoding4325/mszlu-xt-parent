package com.mszlu.xt.common.wx.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 9:09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(WxPayConfiguration.class)
public @interface EnableWxPay {

}
