package com.mszlu.xt.web.service.impl;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import com.mszlu.xt.web.domain.CourseDomain;
import com.mszlu.xt.web.domain.repository.CourseDomainRepository;
import com.mszlu.xt.web.model.params.CourseParam;
import com.mszlu.xt.web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yaCoding
 * @create 2023-01-01 下午 6:42
 */

@Service
public class CourseServiceImpl extends AbstractService implements CourseService {

    @Autowired
    private CourseDomainRepository courseDomainRepository;

    @Override
    public CallResult courseList(CourseParam courseParam) {
        CourseDomain courseDomain = this.courseDomainRepository.createDomain(courseParam);
        
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return courseDomain.courseList();
            }
        });
    }

}
