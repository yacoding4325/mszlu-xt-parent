package com.mszlu.xt.admin.params;

import lombok.Data;

@Data
public class NewsParam {

    private int currentPage = 1;

    private int pageSize = 20;

    private Long id;

    private Integer tab;

    private String title;

    private String summary;

    private String imageUrl;

    private String content;

    private Long createTime;

    private String author;
    /**
     * 0 正常 1 删除
     */
    private Integer status;

    /**
     * 查询条件
     */
    private String queryString;
}
