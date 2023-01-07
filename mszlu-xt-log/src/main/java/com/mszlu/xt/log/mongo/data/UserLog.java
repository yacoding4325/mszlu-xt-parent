package com.mszlu.xt.log.mongo.data;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user_log")
public class UserLog {

    private ObjectId id;

    private Long userId;

    private boolean newer;

    private Long registerTime;

    private Long lastLoginTime;

    private Integer sex;

}
