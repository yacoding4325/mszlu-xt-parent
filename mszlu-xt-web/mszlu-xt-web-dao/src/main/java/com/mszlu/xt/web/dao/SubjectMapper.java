package com.mszlu.xt.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.xt.pojo.Subject;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {

    //select * from t_subject where id in (SELECT subject_id FROM `t_course_subject` where course_id=9)
    List<Subject> findSubjectListByCourseId(Long courseId);

}
