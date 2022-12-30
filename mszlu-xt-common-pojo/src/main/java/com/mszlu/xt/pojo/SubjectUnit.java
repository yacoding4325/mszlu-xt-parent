package com.mszlu.xt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *
 */
@Data
public class SubjectUnit {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long subjectId;

    private Integer subjectUnit;

}
