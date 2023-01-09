package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mszlu.xt.common.wx.config.WxPayConfiguration;
import com.mszlu.xt.pojo.Order;
import com.mszlu.xt.web.dao.OrderMapper;
import com.mszlu.xt.web.domain.CouponDomain;
import com.mszlu.xt.web.domain.CourseDomain;
import com.mszlu.xt.web.domain.OrderDomain;
import com.mszlu.xt.web.domain.SubjectDomain;
import com.mszlu.xt.web.domain.mq.MqService;
import com.mszlu.xt.web.model.params.CouponParam;
import com.mszlu.xt.web.model.params.CourseParam;
import com.mszlu.xt.web.model.params.OrderParam;
import com.mszlu.xt.web.model.params.SubjectParam;
import org.apache.calcite.linq4j.Ord;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 4:02
 */
@SuppressWarnings({"all"})
@Component
public class OrderDomainRepository {

    @Autowired
    public WxPayConfiguration wxPayConfiguration;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CourseDomainRepository courseDomainRepository;

    @Autowired
    private CouponDomainRepository couponDomainRepository;

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

    @Autowired
    public MqService mqService;

    public OrderDomain createDomain(OrderParam orderParam) {
        return new OrderDomain(this,orderParam);
    }

    public CourseDomain createCourseDomain(CourseParam courseParam ) {
        return courseDomainRepository.createDomain(courseParam);
    }

    public CouponDomain createCouponDomain(CouponParam couponParam) {
        return couponDomainRepository.createDomain(couponParam);
    }

    public void saveOrder(Order order) {
        this.orderMapper.insert(order);
    }

    public SubjectDomain createSubjectDomain(SubjectParam subjectParam) {
        return subjectDomainRepository.createDomain(subjectParam);
    }

    public Order findOrderByOrderId(String orderId) {
        LambdaQueryWrapper<Order> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Order::getOrderId,orderId);
        return this.orderMapper.selectById(queryWrapper);
    }

    public void updateOrderStatus(int initCode, Order order) {
        LambdaUpdateWrapper<Order> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(Order::getId,order.getId());
        updateWrapper.set(Order::getPayOrderId,order.getPayOrderId());
        this.orderMapper.update(null, updateWrapper);
    }

    public void updatePayOrderId(Order order) {
        LambdaUpdateWrapper<Order> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(Order::getId,order.getId());
        updateWrapper.set(Order::getPayOrderId,order.getPayOrderId());
        this.orderMapper.update(null,updateWrapper);
    }

}
