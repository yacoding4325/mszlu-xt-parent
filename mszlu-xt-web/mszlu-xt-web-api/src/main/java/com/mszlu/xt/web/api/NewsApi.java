package com.mszlu.xt.web.api;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.cache.Cache;
import com.mszlu.xt.web.model.params.NewsParam;
import com.mszlu.xt.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 1:42
 */
@RestController
@RequestMapping("news")
public class NewsApi {

    @Autowired
    private NewsService newsService;

    @PostMapping("newsList")
    @Cache(name = "newsList",time = 2*60)
    public CallResult newsList(@RequestBody NewsParam newsParam){
        return newsService.newsList(newsParam);
    }

    @PostMapping("detail")
    @Cache(name = "newsDetail",time = 30)
    public CallResult news(@RequestBody NewsParam newsParam){
        return newsService.findNewsById(newsParam);
    }

//    @PostMapping("newsDetailList")
//    @Cache(expire = 30 * 1000,name = "News")
//    public CallResult newsDetailList(@RequestBody NewsParam newsParam){
//        return newsService.newsDetailList(newsParam);
//    }

}
