package com.mszlu.xt.admin.domain;

import com.mszlu.xt.admin.dao.data.AdminUser;
import com.mszlu.xt.admin.domain.repository.AdminUserDomainRepository;
import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import org.springframework.beans.BeanUtils;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 7:58
 */

public class AdminUserDomain {

    private AdminUserDomainRepository adminUserDomainRepository;
    private AdminUserParam adminUserParam;

    public AdminUserDomain(AdminUserDomainRepository adminUserDomainRepository, AdminUserParam adminUserParam) {
        this.adminUserDomainRepository = adminUserDomainRepository;
        this.adminUserParam = adminUserParam;
    }

    /**
     *
     findUserByUsername
     用户（按用户名）
     * @return
     */
    public AdminUserModel findUserByUsername() {
        AdminUser adminUser = adminUserDomainRepository.findUserByUsername(this.adminUserParam.getUsername());
        AdminUserModel adminUserModel = new AdminUserModel();
        BeanUtils.copyProperties(adminUser,adminUserModel);
        return adminUserModel;
    }
}
