package com.mszlu.xt.admin.model;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class TopicModel {

    private Long id;

    private String addAdmin;

    private String topicTitle;

    private String topicTypeStr;

    private Integer topicType;

    private String topicImg;

    private String topicChoice;

    private Integer topicStar;

    private String topicAreaPro;

    private String topicAreaCity;

    private String topicAnswer;

    private String topicAnalyze;

    private String subjectStr;

    private Long subject;

    private String createTime;

    private String lastUpdateTime;

}
