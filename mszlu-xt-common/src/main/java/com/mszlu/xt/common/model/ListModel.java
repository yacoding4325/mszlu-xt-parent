package com.mszlu.xt.common.model;

import lombok.Data;

import java.util.List;

@Data
public class ListModel<T> {

    private Integer total;

    private List<T> list;

}
