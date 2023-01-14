package com.mszlu.xt.web.model;

import lombok.Data;

@Data
public class UserCourseModel {

    private String courseName;

    /**
     * 1 有效
     * 2，已过期
     */
    private Integer status;

    private String buyTime;

    private String expireTime;

    private Integer studyCount;

    private Long courseId;
    
}