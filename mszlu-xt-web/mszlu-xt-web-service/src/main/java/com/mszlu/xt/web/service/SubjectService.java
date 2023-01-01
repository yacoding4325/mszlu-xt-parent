package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;

public interface SubjectService {

    /**
     * 查询所有的科目信息，去重
     * @return
     */
    CallResult listSubject();

}
