package com.mszlu.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class Subject {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String subjectName;

    private String subjectGrade;

    private String subjectTerm;//学期

    private Integer status;//状态

}
