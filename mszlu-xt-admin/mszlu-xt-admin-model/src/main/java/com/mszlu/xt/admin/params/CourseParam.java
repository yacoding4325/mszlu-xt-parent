package com.mszlu.xt.admin.params;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class CourseParam {

    private Long userId;

    private Long id;

    private String courseName;

    private String courseDesc;

    private String subjects;

    private BigDecimal coursePrice;

    private BigDecimal courseZhePrice;

    private Integer courseStatus;

    private List<Long> subjectIdList;

    private Integer orderTime;//订购时长

    private int page = 1;

    private int pageSize = 20;

    private String subjectName;

    private String subjectGrade;

    private String subjectTerm;

    private Long courseId;

    private String imageUrl;

}
