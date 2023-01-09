package com.mszlu.xt.web.service.impl;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import com.mszlu.xt.web.domain.OrderDomain;
import com.mszlu.xt.web.domain.repository.OrderDomainRepository;
import com.mszlu.xt.web.model.params.OrderParam;
import com.mszlu.xt.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 3:59
 */

@Service
@Transactional
public class OrderServiceImpl extends AbstractService implements OrderService {

    @Autowired
    private OrderDomainRepository orderDomainRepository;

    //&**
    @Override
    public CallResult submitOrder(OrderParam orderParam) {
        OrderDomain orderDomain = orderDomainRepository.createDomain(orderParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return orderDomain.submitOrder();
            }
        });

    }

    @Override
    public CallResult wxPay(OrderParam orderParam) {
        OrderDomain orderDomain = orderDomainRepository.createDomain(orderParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return orderDomain.wxPay();
            }
        });
    }

}
