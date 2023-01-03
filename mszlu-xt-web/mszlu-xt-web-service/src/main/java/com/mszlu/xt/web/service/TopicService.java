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

}
