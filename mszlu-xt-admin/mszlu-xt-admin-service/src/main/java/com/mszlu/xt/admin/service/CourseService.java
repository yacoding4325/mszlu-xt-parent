package com.mszlu.xt.admin.service;

import com.mszlu.xt.admin.params.CourseParam;
import com.mszlu.xt.common.model.CallResult;

/**
 * @Author yaCoding
 * @create 2022-12-30 下午 1:01
 */


public interface CourseService {

    CallResult saveCourse(CourseParam courseParam);

    CallResult updateCourse(CourseParam courseParam);

    CallResult findCourseById(CourseParam courseParam);

    CallResult findPage(CourseParam courseParam);

}
