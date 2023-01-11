package com.mszlu.xt.admin.service;

import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.common.model.CallResult;

public interface AdminUserService {

    AdminUserModel findUserByUsername(String username);

    boolean auth(String requestURI, Long userId);

    CallResult findRolePage(AdminUserParam adminUserParam);

}
