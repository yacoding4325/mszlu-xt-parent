package com.mszlu.xt.web.domain;

import com.mszlu.xt.pojo.Order;
import com.mszlu.xt.pojo.UserCourse;
import com.mszlu.xt.web.domain.repository.UserCourseDomainRepository;
import com.mszlu.xt.web.model.params.UserCourseParam;

import java.util.List;

public class UserCourseDomain {

    private UserCourseDomainRepository userCourseDomainRepository;

    private UserCourseParam userCourseParam;

    public UserCourseDomain(UserCourseDomainRepository userCourseDomainRepository, UserCourseParam userCourseParam) {
        this.userCourseDomainRepository = userCourseDomainRepository;
        this.userCourseParam = userCourseParam;
    }

    public UserCourse findUserCourse(Long userId, Long courseId,long currentTime) {
        return userCourseDomainRepository.findUserCourse(userId,courseId,currentTime);
    }

    public long countUserCourseByCourseId(Long courseId) {
        return userCourseDomainRepository.countUserCourseByCourseId(courseId);
    }

    public Integer countUserCourseInCourseIdList(Long userId, List<Long> courseIdList, long currentTimeMillis) {
        return userCourseDomainRepository.countUserCourseInCourseIdList(userId,courseIdList,currentTimeMillis);
    }

    public void saveUserCourse(Order order) {
        Long courseId = order.getCourseId();
        Long userId = order.getUserId();
        UserCourse course = this.userCourseDomainRepository.findUserCourse(userId, courseId);
        if (course == null) {
            course = new UserCourse();
            course.setCourseId(courseId);
            course.setUserId(userId);
            course.setCreateTime(System.currentTimeMillis());
            course.setExpireTime(System.currentTimeMillis() + order.getExpireTime() * 24 * 60 * 60 * 1000L);
            course.setStudyCount(0);
            this.userCourseDomainRepository.saveUserCourse(course);
        } else {
            Long expireTime = course.getExpireTime();
            long currentTimeMillis = System.currentTimeMillis();
            //用户可能课程已经过期很久了
            if (currentTimeMillis >= expireTime) {
                expireTime = currentTimeMillis;
            }
            course.setExpireTime(expireTime + order.getExpireTime() * 24 * 60 * 60 * 1000L);
            this.userCourseDomainRepository.updateUserCourse(course);
        }

    }

    public List<UserCourse> findUserCourseList(Long userId) {
        return userCourseDomainRepository.findUserCourseList(userId);
    }

}
