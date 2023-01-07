package com.mszlu.xt.log.consumer;

import com.mszlu.xt.log.mongo.data.UserLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "xt_log_sso_login",consumerGroup = "sso_consumer_group")
@Slf4j
public class SSOLogConsumer implements RocketMQListener<UserLog> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onMessage(UserLog message) {
        log.info("消息消费:{}",message);
        mongoTemplate.save(message);
    }

}
