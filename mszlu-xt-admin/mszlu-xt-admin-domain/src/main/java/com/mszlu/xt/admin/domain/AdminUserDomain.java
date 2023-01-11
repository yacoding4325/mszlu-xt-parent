package com.mszlu.xt.admin.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.admin.dao.data.AdminMenu;
import com.mszlu.xt.admin.dao.data.AdminPermission;
import com.mszlu.xt.admin.dao.data.AdminRole;
import com.mszlu.xt.admin.dao.data.AdminUser;
import com.mszlu.xt.admin.domain.repository.AdminUserDomainRepository;
import com.mszlu.xt.admin.model.AdminMenuModel;
import com.mszlu.xt.admin.model.AdminUserModel;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.common.login.UserThreadLocal;
import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.common.model.ListModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CallResult<Object> findRolePage() {

        int page = this.adminUserParam.getPage();
        int pageSize = this.adminUserParam.getPageSize();
        Page<AdminRole> adminRolePage = this.adminUserDomainRepository.findRoleList(page,pageSize);
        ListModel listModel = new ListModel();
        listModel.setTotal((int) adminRolePage.getTotal());
        List<AdminRole> result = adminRolePage.getRecords();
        listModel.setList(result);
        return CallResult.success(listModel);
    }

}
