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
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    public boolean auth(String requestURI, Long userId) {
        AdminUserDomain adminUserDomain  = adminUserDomainRepository.createDomain(new AdminUserParam());
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Boolean>() {
            @Override
            public CallResult<Boolean> doAction() {
                return adminUserDomain.auth(requestURI,userId);
            }
        }).getResult();
    }

    @Override
    public CallResult findRolePage(AdminUserParam adminUserParam) {
        AdminUserDomain adminUserDomain = adminUserDomainRepository.createDomain(adminUserParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return adminUserDomain.findRolePage();
            }
        });
    }

    @Override
    public CallResult permissionAll() {
        AdminUserDomain adminUserDomain = this.adminUserDomainRepository.createDomain(null);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return adminUserDomain.permissionAll();
            }
        });
    }

    @Override
    public CallResult findPermissionPage(AdminUserParam adminUserParam) {
        AdminUserDomain adminUserDomain = this.adminUserDomainRepository.createDomain(adminUserParam);
        return this.serviceTemplate.executeQuery(new AbstractTemplateAction<Object>() {
            @Override
            public CallResult<Object> doAction() {
                return adminUserDomain.findPermissionPage();
            }
        });
    }

    @Override
    public CallResult updatePermission(AdminUserParam adminUserParam) {
        AdminUserDomain adminUserDomain = this.adminUserDomainRepository.createDomain(adminUserParam);
        return this.serviceTemplate.execute(new AbstractTemplateAction<Object>() {
            //            @Override
//            public CallResult<Object> checkParam() {
//                return super.checkParam();
//            }
            @Override
            public CallResult<Object> doAction() {
                return adminUserDomain.updatePermission();
            }
        });
    }

}
