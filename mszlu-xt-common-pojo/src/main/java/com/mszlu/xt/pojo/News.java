package com.mszlu.xt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 新闻
 */
@Data
public class News {

    private Long id;

    private String title;

    private String summary;

    private String imageUrl;

    private String content;

    /**
     * 1 题库 2 升学 3 其他
     */
    private Integer tab;

    private Long createTime;

    private String author;

    /**
     * 0 正常 1 删除
     */
    @TableField("n_status")
    private Integer status;
}
