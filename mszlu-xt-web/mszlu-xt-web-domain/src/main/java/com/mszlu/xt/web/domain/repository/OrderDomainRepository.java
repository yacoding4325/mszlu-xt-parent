package com.mszlu.xt.web.domain.repository;

import com.mszlu.xt.pojo.Order;
import com.mszlu.xt.web.dao.OrderMapper;
import com.mszlu.xt.web.domain.CouponDomain;
import com.mszlu.xt.web.domain.CourseDomain;
import com.mszlu.xt.web.domain.OrderDomain;
import com.mszlu.xt.web.domain.SubjectDomain;
import com.mszlu.xt.web.model.params.CouponParam;
import com.mszlu.xt.web.model.params.CourseParam;
import com.mszlu.xt.web.model.params.OrderParam;
import com.mszlu.xt.web.model.params.SubjectParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author yaCoding
 * @create 2023-01-09 下午 4:02
 */
@Component
public class OrderDomainRepository {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CourseDomainRepository courseDomainRepository;

    @Autowired
    private CouponDomainRepository couponDomainRepository;

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

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

}
