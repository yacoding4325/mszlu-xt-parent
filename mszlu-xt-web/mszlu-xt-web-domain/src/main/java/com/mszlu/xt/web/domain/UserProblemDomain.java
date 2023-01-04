package com.mszlu.xt.web.domain;

import com.mszlu.xt.pojo.UserProblem;
import com.mszlu.xt.web.domain.repository.UserProblemDomainRepository;
import com.mszlu.xt.web.model.params.UserProblemParam;

public class UserProblemDomain {

    private UserProblemDomainRepository userProblemDomainRepository;

    private UserProblemParam userProblemParam;

    public UserProblemDomain(UserProblemDomainRepository userProblemDomainRepository, UserProblemParam userProblemParam) {
        this.userProblemDomainRepository = userProblemDomainRepository;
        this.userProblemParam = userProblemParam;
    }

    public UserProblem getUserProblem(Long userId, Long topicId) {
        return userProblemDomainRepository.getUserProblem(userId,topicId);
    }

    public void saveUserProblem(UserProblem userProblem) {
        userProblemDomainRepository.save(userProblem);
    }

    public void updateUserProblemErrorCount(Long userId, Long topicId, String answer) {
        userProblemDomainRepository.updateUserProblemErrorCount(userId,topicId,answer);
    }

}
