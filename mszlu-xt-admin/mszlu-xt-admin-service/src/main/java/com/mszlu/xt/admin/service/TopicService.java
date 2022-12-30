package com.mszlu.xt.admin.service;

import com.mszlu.xt.admin.model.TopicModel;
import com.mszlu.xt.admin.params.TopicParam;
import com.mszlu.xt.common.model.CallResult;

public interface TopicService {

    /**
     * 根据条件 进行对应的题目 分页查询
     * @param topicParam
     * @return
     */
    CallResult findTopicList(TopicParam topicParam);

    TopicModel findTopicByTitle(String topicTitle);

    CallResult updateTopic(TopicParam topicParam);

    CallResult saveTopic(TopicParam topicParam);

}
