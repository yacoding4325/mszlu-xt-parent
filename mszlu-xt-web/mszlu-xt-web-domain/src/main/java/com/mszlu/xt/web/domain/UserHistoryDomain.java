package com.mszlu.xt.web.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.pojo.UserHistory;
import com.mszlu.xt.web.domain.repository.UserHistoryDomainRepository;
import com.mszlu.xt.web.model.SubjectModel;
import com.mszlu.xt.web.model.params.UserHistoryParam;

import java.util.List;

/**
 * @Author yaCoding
 * @create 2023-01-02 下午 7:58
 */

public class UserHistoryDomain {

    private UserHistoryDomainRepository userHistoryDomainRepository;

    private UserHistoryParam userHistoryParam;

    public UserHistoryDomain(UserHistoryDomainRepository userHistoryDomainRepository, UserHistoryParam userHistoryParam) {
        this.userHistoryDomainRepository = userHistoryDomainRepository;
        this.userHistoryParam = userHistoryParam;
    }

    public UserHistory findUserHistory(Long userId, Long subjectId, int historyStatus) {
        return userHistoryDomainRepository.findUserHistory(userId,subjectId,historyStatus);
    }

    public UserHistory findUserHistoryById(Long id) {
        return userHistoryDomainRepository.findUserHistoryById(id);
    }

    public void saveUserHistory(UserHistory userHistory) {
        userHistoryDomainRepository.save(userHistory);
    }

    public void updateUserHistoryStatus(Long historyId, int historyStatus, long finishTime) {
        userHistoryDomainRepository.updateUserHistoryStatus(historyId,historyStatus,finishTime);
    }

    //用户历史记录（通过主题列表）
    public Integer countUserHistoryBySubjectList(Long userId, List<SubjectModel> subjectInfoByCourseId) {
        return userHistoryDomainRepository.countUserHistoryBySubjectList(userId,subjectInfoByCourseId);
    }

    public Page<UserHistory> findUserHistoryList(Long userId, Integer page, Integer pageSize) {
        return userHistoryDomainRepository.findUserHistoryList(userId,page,pageSize);
    }

}
