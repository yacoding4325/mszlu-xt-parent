package com.mszlu.xt.admin.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseModel {

    private String id;

    private String courseName;

    private String courseDesc;

    private String subjects;

    private BigDecimal coursePrice;

    private BigDecimal courseZhePrice;

    private Integer courseStatus;//正常，下架

    private Integer orderTime;

    private List<Long> subjectIdList;

    private List<SubjectModel> subjectList;

    private String imageUrl;

}
