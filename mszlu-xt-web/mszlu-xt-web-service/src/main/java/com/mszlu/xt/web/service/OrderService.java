package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.OrderParam;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 3:58
 */

public interface OrderService {

    /**
     * 提交订单
     * @param orderParam
     * @return
     */
    CallResult submitOrder(OrderParam orderParam);

    /**
     * 根据订单id和支付类型 生成支付二维码
     * @param orderParam
     * @return
     */
    CallResult wxPay(OrderParam orderParam);

    /**
     * 微信支付回调 在此接口 处理订单支付成功的相关操作
     * @param xmlData
     * @return
     */
    CallResult notifyOrder(String xmlData);

    /**
     * 根据订单id 查询订单的详情
     * @param orderParam
     * @return
     */
    CallResult findOrder(OrderParam orderParam);

}
