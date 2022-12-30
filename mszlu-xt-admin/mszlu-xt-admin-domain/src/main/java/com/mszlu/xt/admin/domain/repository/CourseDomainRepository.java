package com.mszlu.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.admin.dao.CourseMapper;
import com.mszlu.xt.admin.dao.CourseSubjectMapper;
import com.mszlu.xt.admin.domain.CourseDomain;
import com.mszlu.xt.admin.domain.SubjectDomain;
import com.mszlu.xt.admin.params.CourseParam;
import com.mszlu.xt.admin.params.SubjectParam;
import com.mszlu.xt.pojo.Course;
import com.mszlu.xt.pojo.CourseSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
public class CourseDomainRepository {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CourseSubjectMapper courseSubjectMapper;

    @Autowired
    private SubjectDomainRepository subjectDomainRepository;

    public void saveCourse(Course course) {
        courseMapper.insert(course);
    }

    public CourseDomain createDomain(CourseParam courseParam) {
        return new CourseDomain(courseParam,this);
    }

    public Course findCourse(Long id) {
        return courseMapper.selectById(id);
    }

    public void updateCurse(Course course) {
        this.courseMapper.updateById(course);
    }

    public SubjectDomain createSubjectDomain(SubjectParam subjectParam) {
        return subjectDomainRepository.createDomain(subjectParam);
    }

    public Page<Course> findCourseListPage(int currentPage,int pageSize) {
        Page<Course> page = new Page<>(currentPage,pageSize);
        return this.courseMapper.selectPage(page,new LambdaQueryWrapper<>());
    }

    public void saveCourseSubject(Long subjectId, Long courseId) {
        CourseSubject courseSubject = new CourseSubject();
        courseSubject.setCourseId(courseId);
        courseSubject.setSubjectId(subjectId);
        this.courseSubjectMapper.insert(courseSubject);
    }

    public void deleteCourseSubject(Long courseId) {
        LambdaQueryWrapper<CourseSubject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseSubject::getCourseId,courseId);
        this.courseSubjectMapper.delete(queryWrapper);
    }

}
