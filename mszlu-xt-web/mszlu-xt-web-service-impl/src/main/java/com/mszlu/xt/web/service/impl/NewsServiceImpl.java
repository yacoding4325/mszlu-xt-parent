package com.mszlu.xt.web.service.impl;


import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import com.mszlu.xt.web.domain.NewsDomain;
import com.mszlu.xt.web.domain.repository.NewsDomainRepository;
import com.mszlu.xt.web.model.params.NewsParam;
import com.mszlu.xt.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 3:02
 */
@Service
public class NewsServiceImpl extends AbstractService implements NewsService {

    @Autowired
    private NewsDomainRepository newsDomainRepository;

    @Override
    public CallResult newsList(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkParam() {
                //参数检测
                return newsDomain.checkNewsListParam();
            }
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.newsList();
            }
        });
    }

    @Override
    public CallResult findNewsById(NewsParam newsParam) {
        NewsDomain newsDomain = newsDomainRepository.createDomain(newsParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return newsDomain.findNewsById();
            }
        });
    }
}
