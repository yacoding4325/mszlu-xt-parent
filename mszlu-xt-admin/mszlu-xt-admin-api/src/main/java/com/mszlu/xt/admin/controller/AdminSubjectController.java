package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.SubjectParam;
import com.mszlu.xt.admin.service.SubjectService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subject")
public class AdminSubjectController {

    @Autowired
    private SubjectService subjectService;


    /**
     * 分页查询
     * @param subjectParam
     * @return
     */
    @PostMapping(value = "findPage")
    public CallResult findPage(@RequestBody SubjectParam subjectParam){
        return  subjectService.findSubjectList(subjectParam);
    }

    /**
     * 新增学科
     * @param subjectParam
     * @return
     */
    @PostMapping(value = "saveSubject")
    public CallResult saveSubject(@RequestBody SubjectParam subjectParam){
        return  subjectService.saveSubject(subjectParam);
    }

    /**
     * 根据id查询subject
     * @param subjectParam
     * @return
     */
    @PostMapping(value = "findSubjectById")
    public CallResult findSubjectById(@RequestBody SubjectParam subjectParam){
        return  subjectService.findSubjectById(subjectParam);
    }

    /**
     * 编辑学科信息
     * @param subjectParam
     * @return
     */
    @PostMapping(value = "updateSubject")
    public CallResult updateSubject(@RequestBody SubjectParam subjectParam){
        return  subjectService.updateSubject(subjectParam);
    }

    /**
     * 查询所有的学科信息
     * @param subjectParam
     * @return
     */
    @PostMapping(value = "allSubjectList")
    public CallResult allSubjectList(@RequestBody SubjectParam subjectParam){
        return  subjectService.allSubjectList(subjectParam);
    }

}
