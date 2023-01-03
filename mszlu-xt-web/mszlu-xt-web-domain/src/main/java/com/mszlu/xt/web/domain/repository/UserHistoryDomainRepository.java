package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mszlu.xt.pojo.UserHistory;
import com.mszlu.xt.web.dao.UserHistoryMapper;
import com.mszlu.xt.web.domain.UserHistoryDomain;
import com.mszlu.xt.web.model.params.UserHistoryParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author yaCoding
 * @create 2023-01-02 下午 7:59
 */
@Component
public class UserHistoryDomainRepository {

    @Resource
    private UserHistoryMapper userHistoryMapper;

    public UserHistoryDomain createDomain(UserHistoryParam userHistoryParam) {
        return new UserHistoryDomain(this,userHistoryParam);
    }

    public UserHistory findUserHistory(Long userId, Long subjectId, int historyStatus) {
        LambdaQueryWrapper<UserHistory> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserHistory::getUserId,userId);
        queryWrapper.eq(UserHistory::getSubjectId,subjectId);
        queryWrapper.eq(UserHistory::getHistoryStatus,historyStatus);
        queryWrapper.last("limit 1");
        return userHistoryMapper.selectOne(queryWrapper);
    }

}
