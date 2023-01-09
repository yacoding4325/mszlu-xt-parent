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

}
