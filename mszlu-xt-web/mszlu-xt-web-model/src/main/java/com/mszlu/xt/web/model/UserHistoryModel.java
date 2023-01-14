package com.mszlu.xt.web.model;

import lombok.Data;

import java.util.List;

@Data
public class UserHistoryModel {

    private Long id;

    private String createTime;

    private List<Integer> subjectUnitList;

    private String subjectName;

    private Long subjectId;

    private String finishTime;

    private String useTime;

    //1 未完成 2 已完成 3 已取消
    private Integer historyStatus;

    //0 正常 1 已过期
    private Integer status;

}