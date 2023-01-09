package com.mszlu.xt.pojo;

import lombok.Data;

@Data
public class OrderTrade {

    private Long id;

    private String orderId;

    private String transactionId;

    private Integer payType;

    private Long userId;

    private String payInfo;

}
