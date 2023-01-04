package com.mszlu.xt.pojo;

import lombok.Data;

@Data
public class UserProblem {

    private Long id;

    private Long userId;

    private Long subjectId;

    private Long topicId;

    private Integer errorCount;

    private Integer errorStatus;

    private String errorAnswer;

    private Long errorTime;

}
