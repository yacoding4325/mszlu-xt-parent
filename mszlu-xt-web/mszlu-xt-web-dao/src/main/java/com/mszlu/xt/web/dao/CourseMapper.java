package com.mszlu.xt.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.pojo.Course;

public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据年级 进行课程的列表查询
     *
     * @param page
     * @param subjectGrade
     * @return
     */
    Page<Course> findCourseByGrade(Page<Course> page, String subjectGrade);
}
