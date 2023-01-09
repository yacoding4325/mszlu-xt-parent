package com.mszlu.xt.pojo;

import lombok.Data;

@Data
public class UserCoupon {

    private Long id;

    private Long userId;

    private Long couponId;

    // 0 未使用 1 已使用 2过期 4 已使用 未消费
    private Integer status;

    private Long startTime;

    private Long expireTime;

    //使用时间
    private Long useTime;

    //来源
    private String source;

}
