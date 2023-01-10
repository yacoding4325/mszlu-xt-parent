package com.mszlu.xt.admin.service;

import com.mszlu.xt.admin.model.AdminUserModel;

public interface AdminUserService {

    AdminUserModel findUserByUsername(String username);

    boolean auth(String requestURI, Long userId);

}
