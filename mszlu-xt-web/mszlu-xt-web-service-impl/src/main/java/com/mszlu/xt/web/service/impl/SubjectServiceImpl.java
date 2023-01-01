package com.mszlu.xt.web.service.impl;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import com.mszlu.xt.web.domain.SubjectDomain;
import com.mszlu.xt.web.domain.repository.SubjectDomainRepository;
import com.mszlu.xt.web.model.params.SubjectParam;
import com.mszlu.xt.web.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends AbstractService implements SubjectService {

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

    @Override
    public CallResult listSubject() {
        SubjectDomain subjectDomain = subjectDomainRepository.createDomain(new SubjectParam());
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.listSubject();
            }
        });
    }

}
