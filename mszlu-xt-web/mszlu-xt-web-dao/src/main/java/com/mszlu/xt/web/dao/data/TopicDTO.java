package com.mszlu.xt.web.dao.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;



@Data
public class TopicDTO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String addAdmin;

    private String topicTitle;

    private Integer topicType;

    private String topicImg;

    private String topicChoice;

    private Integer topicStar;

    private String topicAreaPro;

    private String topicAreaCity;

    private String topicAnswer;

    private String topicAnalyze;

    private Long topicSubject;

    private Long createTime;

    private Long lastUpdateTime;

    private Integer subjectUnit;

    private Integer pStatus;

    private String userAnswer;

}
