package com.mszlu.xt.admin.domain;

import com.mszlu.xt.admin.dao.data.AdminPermission;
import com.mszlu.xt.admin.dao.data.AdminUser;
import com.mszlu.xt.admin.domain.repository.AdminUserDomainRepository;
import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.BeanUtils;
import org.springframework.util.AntPathMatcher;

import java.util.List;

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
    public CallResult<Boolean> auth(String requestURI, Long userId) {
        //用户和角色关联表 直接通过关联表 查询角色id列表
        List<Integer> roleIdList = adminUserDomainRepository.findRoleIdListByUserId(userId);
        if (roleIdList.isEmpty()) {
            return CallResult.fail(false);
        }
        //角色和权限的关联表 查询到权限id列表
        List<Integer> permissionIdList = adminUserDomainRepository.findPermissionIdListByRoleIds(roleIdList);
        if (permissionIdList.isEmpty()){
            return CallResult.fail(false);
        }
        List<AdminPermission> permissionList = adminUserDomainRepository.findPermissionByIds(permissionIdList);
        for (AdminPermission adminPermission : permissionList) {
            // /course/**
            String permissionPath = adminPermission.getPermissionPath();
            if (new AntPathMatcher().match(permissionPath,requestURI)){
                return CallResult.success(true);
            }
        }
        return CallResult.fail(false);
    }

}
