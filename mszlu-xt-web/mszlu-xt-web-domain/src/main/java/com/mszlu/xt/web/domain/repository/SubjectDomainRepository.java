package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.common.enums.Status;
import com.mszlu.xt.pojo.Subject;
import com.mszlu.xt.pojo.SubjectUnit;
import com.mszlu.xt.web.dao.SubjectMapper;
import com.mszlu.xt.web.dao.SubjectUnitMapper;
import com.mszlu.xt.web.domain.SubjectDomain;
import com.mszlu.xt.web.model.params.SubjectParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectDomainRepository {

    @Resource
    private SubjectMapper subjectMapper;

    public SubjectDomain createDomain(SubjectParam subjectParam) {
        return new SubjectDomain(this,subjectParam);
    }

    public List<Subject> findSubjectList() {
        LambdaQueryWrapper<Subject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Subject::getStatus, Status.NORMAL.getCode());
        return subjectMapper.selectList(queryWrapper);
    }

    public List<Subject> findSubjectListByCourseId(Long courseId) {
        return subjectMapper.findSubjectListByCourseId(courseId);
    }

    @Resource
    private SubjectUnitMapper subjectUnitMapper;

    public List<SubjectUnit> findUnitBySubjectId(Long subjectId) {
        LambdaQueryWrapper<SubjectUnit> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SubjectUnit::getSubjectId,subjectId);
        return subjectUnitMapper.selectList(queryWrapper);
    }

    public Subject findSubjectById(Long subjectId) {
        return subjectMapper.selectById(subjectId);
    }

}
