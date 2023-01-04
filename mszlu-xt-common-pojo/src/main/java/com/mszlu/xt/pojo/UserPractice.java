package com.mszlu.xt.pojo;

import lombok.Data;

@Data
public class UserPractice {

    private Long id;

    private Long historyId;

    private Long topicId;

    private Long userId;

    //0 是未回答 1 回答错误 2 回答正确
    private Integer pStatus;

    private String userAnswer;

}
