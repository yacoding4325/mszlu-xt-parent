package com.mszlu.xt.web.domain;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszlu.xt.pojo.UserPractice;
import com.mszlu.xt.web.dao.UserPracticeMapper;
import com.mszlu.xt.web.domain.repository.UserPracticeDomainRepository;
import com.mszlu.xt.web.model.params.UserPracticeParam;

import java.util.List;
import java.util.Map;

public class UserPracticeDomain {

    private UserPracticeDomainRepository userPracticeDomainRepository;

    private UserPracticeParam userPracticeParam;

    public UserPracticeDomain(UserPracticeDomainRepository userPracticeDomainRepository, UserPracticeParam userPracticeParam) {
        this.userPracticeDomainRepository = userPracticeDomainRepository;
        this.userPracticeParam = userPracticeParam;
    }

    public void saveUserPractice(UserPractice userPractice) {
        userPracticeDomainRepository.save(userPractice);
    }

    public int countUserPracticeTrueNum(Long userId,Long userHistoryId) {
        return userPracticeDomainRepository.countUserPracticeNumByStatus(userId,userHistoryId,2);
    }

    public int countUserPracticeWrongNum(Long userId,Long userHistoryId) {
        //1 错误答案
        return userPracticeDomainRepository.countUserPracticeNumByStatus(userId,userHistoryId,1);
    }

    public List<Map<String, Object>> findUserPracticeAll(Long userId, Long userHistoryId) {
        return userPracticeDomainRepository.findUserPracticeAnswerMap(userId,userHistoryId);
    }

    public Long findUserPractice(Long userId, Long userHistoryId, Integer progress) {
        return userPracticeDomainRepository.findUserPracticeTopic(userId,userHistoryId,progress);
    }

    public UserPractice findUserPracticeByTopicId(Long userId, Long topicId, Long userHistoryId) {
        return userPracticeDomainRepository.findUserPracticeByTopicId(userId, topicId, userHistoryId);
    }

    public void updateUserPractice(Long userHistoryId, Long topicId, Long userId, String answer, int pStatus) {
        userPracticeDomainRepository.updateUserPractice(userHistoryId,topicId,userId,answer,pStatus);
    }

}
