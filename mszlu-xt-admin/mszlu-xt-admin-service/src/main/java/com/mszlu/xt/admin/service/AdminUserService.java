package com.mszlu.xt.admin.service;

import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.common.model.CallResult;

public interface AdminUserService {

    AdminUserModel findUserByUsername(String username);

    boolean auth(String requestURI, Long userId);

    CallResult findRolePage(AdminUserParam adminUserParam);

    CallResult permissionAll();

    /**
     * //查询所有权限
     * @param adminUserParam
     * @return
     */
    CallResult findPermissionPage(AdminUserParam adminUserParam);

    /**
     * 更新权限
     * @param adminUserParam
     * @return
     */
    CallResult updatePermission(AdminUserParam adminUserParam);

}
