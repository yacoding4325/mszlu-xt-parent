package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.TopicParam;

public interface TopicService {

    /**
     * 开始练习
     * @param topicParam
     * @return
     */
    CallResult practice(TopicParam topicParam);

    CallResult submit(TopicParam topicParam);

    CallResult jump(TopicParam topicParam);

    /**
     * 学习历史记录
     * @param topicParam
     * @return
     */
    CallResult practiceHistory(TopicParam topicParam);

    /**
     * 用户问题搜索
     * @param topicParam
     * @return
     */
    CallResult userProblemSearch(TopicParam topicParam);

}
