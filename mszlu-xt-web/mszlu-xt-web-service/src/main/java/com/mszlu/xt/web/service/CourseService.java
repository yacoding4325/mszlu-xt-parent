package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.CourseParam;

public interface CourseService {

    /**
     * 进入学习，课程列表
     * @param courseParam
     * @return
     */
    CallResult courseList(CourseParam courseParam);

    /**
     * 根据课程id查询学科详细信息
     * @param courseParam
     * @return
     */
    CallResult subjectInfo(CourseParam courseParam);

    /**
     * 根据课程id，将课程的信息展示出来，供用户查看
     * @param courseParam
     * @return
     */
    CallResult courseDetail(CourseParam courseParam);

}
