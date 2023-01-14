package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.pojo.UserProblem;
import com.mszlu.xt.web.dao.UserProblemMapper;
import com.mszlu.xt.web.domain.UserProblemDomain;
import com.mszlu.xt.web.model.params.UserProblemParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProblemDomainRepository {

    @Resource
    private UserProblemMapper userProblemMapper;

    public UserProblemDomain createDomain(UserProblemParam userProblemParam) {
        return new UserProblemDomain(this,userProblemParam);
    }

    public UserProblem getUserProblem(Long userId, Long topicId) {
        LambdaQueryWrapper<UserProblem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserProblem::getTopicId,topicId);
        queryWrapper.eq(UserProblem::getUserId,userId);
        queryWrapper.last("limit 1");
        return userProblemMapper.selectOne(queryWrapper);
    }

    public void save(UserProblem userProblem) {
        this.userProblemMapper.insert(userProblem);
    }

    public void updateUserProblemErrorCount(Long userId, Long topicId, String answer) {
        UpdateWrapper<UserProblem> update = Wrappers.update();
        update.eq("user_id",userId);
        update.eq("topic_id",topicId);
        update.set("error_count","error_count+1");
        update.set("answer",answer);
        //加锁操作 没有别的操作 会影响
        //update table set error_count=error_count+1 where user_id=111 and topic_id=222
        userProblemMapper.update(null, update);
    }

    public Page<UserProblem> findUserProblemList(Long userId, int errorStatus, int page, int pageSize) {
        LambdaQueryWrapper<UserProblem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserProblem::getUserId,userId);
        queryWrapper.eq(UserProblem::getErrorStatus,errorStatus);
        return userProblemMapper.selectPage(new Page<>(page,pageSize),queryWrapper);
    }

    public Page<UserProblem> findUserProblemListBySubjectId(Long searchSubjectId, Long userId, int errorStatus, int page, int pageSize) {
        LambdaQueryWrapper<UserProblem> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserProblem::getUserId,userId);
        queryWrapper.eq(UserProblem::getErrorStatus,errorStatus);
        queryWrapper.eq(UserProblem::getSubjectId,searchSubjectId);
        return userProblemMapper.selectPage(new Page<>(page,pageSize), queryWrapper);
    }

}
