package com.mszlu.xt.admin.params;

import lombok.Data;

import java.util.List;


@Data
public class SubjectParam {

    private Long id;

    private String subjectName;

    private String subjectGrade;

    private String subjectTerm;

    private List<Integer> subjectUnits;

    private Integer status;

    private int currentPage = 1;

    private int pageSize = 20;

    private String queryString;

}
