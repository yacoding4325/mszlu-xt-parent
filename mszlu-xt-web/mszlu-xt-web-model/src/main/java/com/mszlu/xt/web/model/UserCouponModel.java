package com.mszlu.xt.web.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserCouponModel {//用户优惠券模型

    private String name;

    private BigDecimal amount;

    private Long couponId;

}
