package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.CourseParam;
import com.mszlu.xt.admin.service.CourseService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "saveCourse")
    public CallResult saveCourse(@RequestBody CourseParam courseParam){
        return courseService.saveCourse(courseParam);
    }

    @RequestMapping(value = "updateCourse")
    public CallResult updateCourse(@RequestBody CourseParam courseParam){
        return courseService.updateCourse(courseParam);
    }

    @RequestMapping(value = "findCourseById")
    public CallResult findSubjectById(@RequestBody CourseParam courseParam){
        return courseService.findCourseById(courseParam);
    }

    @RequestMapping(value = "findPage")
    public CallResult findPage(@RequestBody CourseParam courseParam){
        return courseService.findPage(courseParam);
    }

}
