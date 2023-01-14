package com.mszlu.xt.web.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public Page<UserProblem> findUserProblemList(Long userId, int errorStatus, int page, int pageSize) {
        return userProblemDomainRepository.findUserProblemList(userId,errorStatus,page,pageSize);
    }

    //通过课程id  查找到用户问题列表
    public Page<UserProblem> findUserProblemListBySubjectId(Long searchSubjectId, Long userId, int errorStatus, int page, int pageSize) {
        return userProblemDomainRepository.findUserProblemListBySubjectId(searchSubjectId,userId,errorStatus,page,pageSize);
    }

}
