package com.mszlu.xt.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.xt.pojo.Subject;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> findSubjectListByCourseId(Long courseId);

}
