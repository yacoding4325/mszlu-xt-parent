package com.mszlu.xt.admin.service.impl;

import com.mszlu.xt.admin.domain.SubjectDomain;
import com.mszlu.xt.admin.domain.repository.SubjectDomainRepository;
import com.mszlu.xt.admin.params.SubjectParam;
import com.mszlu.xt.admin.service.SubjectService;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubjectServiceImpl extends AbstractService implements SubjectService {

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

    @Override
    public CallResult findSubjectList(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.findSubjectList();
            }
        });
    }

    @Override
    @Transactional
    public CallResult saveSubject(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);

        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkParam() {
                return subjectDomain.checkSaveSubjectParam();
            }
            @Override
            public CallResult<Object> checkBiz() {
                return subjectDomain.checkSaveSubjectBiz();
            }
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.saveSubject();
            }
        });
    }

    @Override
    public CallResult findSubjectById(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.findSubjectById();
            }
        });
    }

    @Override
    public CallResult updateSubject(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);

        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkParam() {
                return subjectDomain.checkSaveSubjectParam();
            }
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.updateSubject();
            }
        });
    }

    @Override
    public CallResult allSubjectList(SubjectParam subjectParam) {
        SubjectDomain subjectDomain = this.subjectDomainRepository.createDomain(subjectParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return subjectDomain.allSubjectList();
            }
        });
    }
}
