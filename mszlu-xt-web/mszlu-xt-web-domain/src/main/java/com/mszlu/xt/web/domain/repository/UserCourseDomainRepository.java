package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mszlu.xt.pojo.UserCourse;
import com.mszlu.xt.web.dao.UserCourseMapper;
import com.mszlu.xt.web.domain.UserCourseDomain;
import com.mszlu.xt.web.model.params.UserCourseParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserCourseDomainRepository {

    @Resource
    private UserCourseMapper userCourseMapper;

    public UserCourseDomain createDomain(UserCourseParam userCourseParam) {
        return new UserCourseDomain(this,userCourseParam);
    }

    public UserCourse findUserCourse(Long userId, Long courseId, long currentTime) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getCourseId,courseId);
        queryWrapper.eq(UserCourse::getUserId,userId);
        queryWrapper.ge(UserCourse::getExpireTime,currentTime);
        return userCourseMapper.selectOne(queryWrapper);
    }

    public long countUserCourseByCourseId(Long courseId) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getCourseId,courseId);
        return userCourseMapper.selectCount(queryWrapper);
    }

    public Integer countUserCourseInCourseIdList(Long userId, List<Long> courseIdList, long currentTimeMillis) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getUserId,userId);
        queryWrapper.in(UserCourse::getCourseId,courseIdList);
        queryWrapper.ge(UserCourse::getExpireTime,currentTimeMillis);
        return userCourseMapper.selectCount(queryWrapper);
    }

    public UserCourse findUserCourse(Long userId, Long courseId) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getCourseId,courseId);
        queryWrapper.eq(UserCourse::getUserId,userId);
        queryWrapper.last("limit 1");
        return userCourseMapper.selectOne(queryWrapper);
    }

    public void saveUserCourse(UserCourse course) {
        userCourseMapper.insert(course);
    }

    public void updateUserCourse(UserCourse course) {
        LambdaUpdateWrapper<UserCourse> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(UserCourse::getId,course.getId());
        updateWrapper.set(UserCourse::getExpireTime,course.getExpireTime());
        userCourseMapper.update(null, updateWrapper);
    }

    public List<UserCourse> findUserCourseList(Long userId) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getUserId,userId);
        return userCourseMapper.selectList(queryWrapper);
    }

}
