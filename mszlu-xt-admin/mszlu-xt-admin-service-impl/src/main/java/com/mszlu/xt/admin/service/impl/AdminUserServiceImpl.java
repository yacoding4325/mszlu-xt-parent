package com.mszlu.xt.admin.service.impl;

import com.mszlu.xt.admin.domain.AdminUserDomain;
import com.mszlu.xt.admin.domain.repository.AdminUserDomainRepository;
import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.service.AdminUserService;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.service.AbstractTemplateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl  extends  AbstractService implements AdminUserService {

    @Autowired
    private AdminUserDomainRepository adminUserDomainRepository;

    @Override
    public AdminUserModel findUserByUsername(String username) {
        AdminUserParam adminUserParam = new AdminUserParam();
        adminUserParam.setUsername(username);
        AdminUserDomain adminUserDomain  = adminUserDomainRepository.createDomain(adminUserParam);
        return adminUserDomain.findUserByUsername();
    }

}
