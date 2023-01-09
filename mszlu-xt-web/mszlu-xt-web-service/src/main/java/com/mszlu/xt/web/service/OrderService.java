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

}
