package com.mszlu.xt.web.service.impl;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import com.mszlu.xt.web.domain.TopicDomain;
import com.mszlu.xt.web.domain.repository.TopicDomainRepository;
import com.mszlu.xt.web.model.params.TopicParam;
import com.mszlu.xt.web.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl extends AbstractService implements TopicService {

    @Autowired
    private TopicDomainRepository topicDomainRepository;

    @Override
    @Transactional
    public CallResult practice(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkBiz() {
                return topicDomain.checkPracticeBiz();
            }
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.practice();
            }
        });
    }

    @Override
    @Transactional
    public CallResult submit(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> checkBiz() {
                return topicDomain.checkSubmitBiz();
            }
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.submit();
            }
        });
    }

    @Override
    public CallResult jump(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.jump();
            }
        });
    }

    @Override
    public CallResult practiceHistory(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.practiceHistory();
            }
        });

    }

    @Override
    public CallResult userProblemSearch(TopicParam topicParam) {
        TopicDomain topicDomain = this.topicDomainRepository.createDomain(topicParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return topicDomain.userProblemSearch();
            }
        });

    }

}
