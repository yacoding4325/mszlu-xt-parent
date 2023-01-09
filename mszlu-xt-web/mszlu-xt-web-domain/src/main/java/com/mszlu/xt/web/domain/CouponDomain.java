package com.mszlu.xt.web.domain;

import com.mszlu.xt.pojo.Coupon;
import com.mszlu.xt.pojo.UserCoupon;
import com.mszlu.xt.web.domain.repository.CouponDomainRepository;
import com.mszlu.xt.web.model.params.CouponParam;

import java.util.List;

public class CouponDomain {

    private CouponDomainRepository couponDomainRepository;

    private CouponParam couponParam;

    public CouponDomain(CouponDomainRepository couponDomainRepository, CouponParam couponParam) {
        this.couponDomainRepository = couponDomainRepository;
        this.couponParam = couponParam;
    }

    public Coupon findCouponById(Long couponId) {
        return couponDomainRepository.findCouponById(couponId);
    }

    public List<UserCoupon> findUserCouponByUserId(Long userId) {
        return couponDomainRepository.findUserCouponByUserId(userId);
    }

    public UserCoupon findUserCouponByUserId(Long userId,Long couponId) {
        return couponDomainRepository.findUserCouponByUserId(userId,couponId);
    }

    public void updateCouponStatus(UserCoupon userCoupon) {
        couponDomainRepository.updateCouponStatus(userCoupon);
    }
}
