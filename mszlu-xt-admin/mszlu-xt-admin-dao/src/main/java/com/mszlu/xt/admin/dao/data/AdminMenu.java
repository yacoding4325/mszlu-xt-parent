package com.mszlu.xt.admin.dao.data;

import lombok.Data;

@Data
public class AdminMenu {

    private Integer id;

    private String menuName;

    private String menuDesc;

    private Integer parentId;

    private Integer level;

    private String menuLink;

    private String menuKeywords;

    private Integer menuSeq;

}
