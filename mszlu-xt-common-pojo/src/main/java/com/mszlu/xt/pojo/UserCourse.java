package com.mszlu.xt.pojo;

import lombok.Data;

@Data
public class UserCourse {

    private Long id;

    private Long userId;

    private Long courseId;

    private Long createTime;

    private Long expireTime;

    private Integer studyCount;

}
