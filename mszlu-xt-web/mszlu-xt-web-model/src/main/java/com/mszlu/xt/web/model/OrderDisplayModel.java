package com.mszlu.xt.web.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDisplayModel {

    private String orderId;

    private String subject;

    private String courseName;

    private BigDecimal amount;

}
