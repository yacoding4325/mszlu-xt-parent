package com.mszlu.xt.sso.dao.mongo.data;

import lombok.Data;

@Data
public class UserLog {

    private Long userId;

    private boolean newer;

    private Long registerTime;

    private Long lastLoginTime;

    private Integer sex;

}
