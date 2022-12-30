package com.mszlu.xt.admin.service.impl;

import com.mszlu.xt.admin.domain.CourseDomain;
import com.mszlu.xt.admin.domain.repository.CourseDomainRepository;
import com.mszlu.xt.admin.params.CourseParam;
import com.mszlu.xt.admin.service.CourseService;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CourseServiceImpl extends AbstractService implements CourseService {

    @Autowired
    private CourseDomainRepository courseDomainRepository;

    @Override
    public CallResult saveCourse(CourseParam courseParam) {
        CourseDomain courseDomain = this.courseDomainRepository.createDomain(courseParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return courseDomain.saveCourse();
            }
        });
    }

    @Override
    public CallResult updateCourse(CourseParam courseParam) {
        CourseDomain courseDomain = this.courseDomainRepository.createDomain(courseParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return courseDomain.updateCourse();
            }
        });
    }

    @Override
    public CallResult findPage(CourseParam courseParam) {
        CourseDomain courseDomain = this.courseDomainRepository.createDomain(courseParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return courseDomain.findPage();
            }
        });
    }

    @Override
    public CallResult findCourseById(CourseParam courseParam) {
        CourseDomain courseDomain = this.courseDomainRepository.createDomain(courseParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return courseDomain.findCourseById();
            }
        });
    }

}
