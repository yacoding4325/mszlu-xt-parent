package com.mszlu.xt.common.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WxPayConfiguration {

    @Value("${wx.pay.appId}")
    public String payAppId;

    @Value("${wx.pay.mchId}")
    public String mchId;

    @Value("${wx.pay.mchKey}")
    public String mchKey;

    @Value("${wx.notify.url}")
    public String wxNotifyUrl;

}
