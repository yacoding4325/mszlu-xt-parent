package com.mszlu.xt.admin.dao.data;

import lombok.Data;

@Data
public class AdminRolePermission {

    private Long id;

    private Integer roleId;

    private Integer permissionId;

}
