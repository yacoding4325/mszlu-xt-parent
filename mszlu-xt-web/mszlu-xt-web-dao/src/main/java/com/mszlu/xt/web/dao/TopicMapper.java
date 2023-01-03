package com.mszlu.xt.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.xt.pojo.Topic;
import com.mszlu.xt.web.dao.data.TopicDTO;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper extends BaseMapper<Topic> {

    TopicDTO findTopicAnswer(@Param("topicId") Long topicId,
                             @Param("userId") Long userId,
                             @Param("userHistoryId")Long userHistoryId);

}
