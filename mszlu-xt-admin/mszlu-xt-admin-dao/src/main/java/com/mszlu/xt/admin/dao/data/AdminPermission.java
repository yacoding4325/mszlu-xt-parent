package com.mszlu.xt.admin.dao.data;

import lombok.Data;

@Data
public class AdminPermission {

    private Integer id;

    private String permissionName;

    private String permissionDesc;

    private String permissionPath;

    private String permissionKeywords;

}
