package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.NewsParam;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 1:49
 */

public interface  NewsService {

    /**
     * 分页查询 新闻列表
     * @param newsParam
     * @return
     */
    CallResult newsList(NewsParam newsParam);

    CallResult findNewsById(NewsParam newsParam);

}
