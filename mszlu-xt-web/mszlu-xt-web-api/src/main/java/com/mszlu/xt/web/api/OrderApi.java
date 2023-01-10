package com.mszlu.xt.web.api;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.OrderParam;
import com.mszlu.xt.web.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 3:56
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @PostMapping("submitOrder")
    public CallResult submitOrder(@RequestBody OrderParam orderParam){
        return orderService.submitOrder(orderParam);
    }

    @PostMapping("wxPay")
    public CallResult wxPay(@RequestBody OrderParam orderParam) {
        return orderService.wxPay(orderParam);
    }

    @PostMapping("notify")
    public String notifyOrder(@RequestBody String xmlData){
        log.info("notify 数据：{}",xmlData);
        CallResult callResult = orderService.notifyOrder(xmlData);
        if (callResult.isSuccess()){
            return WxPayNotifyResponse.success("成功");
        }
        return WxPayNotifyResponse.fail("失败");
    }

    @PostMapping("findOrder")
    public CallResult findOrder(@RequestBody OrderParam orderParam){
        return orderService.findOrder(orderParam);
    }

    //订单列表
    @PostMapping(value = "orderList")
    public CallResult orderList(@RequestBody OrderParam orderParam){
        return orderService.orderList(orderParam);
    }

}
