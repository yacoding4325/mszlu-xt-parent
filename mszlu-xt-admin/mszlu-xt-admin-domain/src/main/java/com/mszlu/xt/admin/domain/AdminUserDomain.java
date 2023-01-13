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
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
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

    public CallResult<Object> permissionAll() {
        List<AdminPermission> allPermission = this.adminUserDomainRepository.findAllPermission();
        return CallResult.success(allPermission);
    }

    public CallResult<Object> findPermissionPage() {
        int page = this.adminUserParam.getPage();
        int pageSize = this.adminUserParam.getPageSize();
        Page<AdminPermission> adminPermissionPage = this.adminUserDomainRepository.findPermissionList(page,pageSize);
        ListModel listModel = new ListModel();
        listModel.setTotal((int) adminPermissionPage.getTotal());
        List<AdminPermission> result = adminPermissionPage.getRecords();
        listModel.setList(result);
        return CallResult.success(listModel);
    }

    public CallResult<Object> updatePermission() {
        AdminPermission adminPermission = new AdminPermission();
        BeanUtils.copyProperties(adminUserParam,adminPermission);
        adminPermission.setId(adminUserParam.getPermissionId());
        this.adminUserDomainRepository.updatePermission(adminPermission);
        return CallResult.success();
    }

    public CallResult<Object> findPage() {
        int page = this.adminUserParam.getPage();
        int pageSize = this.adminUserParam.getPageSize();
        Page<AdminUser> adminUserPage = this.adminUserDomainRepository.findUserList(page,pageSize);
        ListModel listModel = new ListModel();
        listModel.setTotal((int) adminUserPage.getTotal());
        List<AdminUser> result = adminUserPage.getRecords();
        listModel.setList(result);
        return CallResult.success(listModel);
    }

    public CallResult<Object> addUser() {
        /**
         * 1. 密码需要加密
         * 2. 角色存入关联表
         */
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(this.adminUserParam.getUsername());
        adminUser.setPassword(new BCryptPasswordEncoder().encode(this.adminUserParam.getPassword()));
        this.adminUserDomainRepository.saveUser(adminUser);
        List<Integer> roleIdList = this.adminUserParam.getRoleIdList();
        for (Integer roleId : roleIdList) {
            this.adminUserDomainRepository.saveUserRole(adminUser.getId(),roleId);
        }
        return CallResult.success();

    }

    public CallResult<Object> findUserById() {
        AdminUser adminUser = this.adminUserDomainRepository.findUserById(this.adminUserParam.getId());
        List<Integer> adminRoleIdListByUserId = this.adminUserDomainRepository.findAdminRoleIdListByUserId(this.adminUserParam.getId());
        Map<String,Object> result = new HashMap<>();
        result.put("user",adminUser);
        result.put("roleIdList",adminRoleIdListByUserId);
        return CallResult.success(result);
    }

    //编辑
    public CallResult<Object> update() {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(this.adminUserParam.getUsername());
        String newPassword = this.adminUserParam.getNewPassword();
        if (StringUtils.isNotBlank(newPassword)) {
            adminUser.setPassword(new BCryptPasswordEncoder().encode(this.adminUserParam.getNewPassword()));
        }
        adminUser.setId(this.adminUserParam.getId());
        this.adminUserDomainRepository.updateUser(adminUser);
        this.adminUserDomainRepository.deleteUserRoleByUserId(adminUser.getId());
        List<Integer> roleIdList = this.adminUserParam.getRoleIdList();
        for (Integer roleId : roleIdList) {
            this.adminUserDomainRepository.saveUserRole(adminUser.getId(),roleId);
        }
        return CallResult.success();
    }

    public CallResult<Object> findMenuPage() {
        int page = this.adminUserParam.getPage();
        int pageSize = this.adminUserParam.getPageSize();
        Page<AdminMenu> adminMenuPage = this.adminUserDomainRepository.findMenuPage(page,pageSize);
        ListModel listModel = new ListModel();
        listModel.setTotal((int) adminMenuPage.getTotal());
        List<AdminMenu> result = adminMenuPage.getRecords();
        listModel.setList(result);
        return CallResult.success(listModel);
    }

    public CallResult<Object> menuAll() {
        List<AdminMenu> menuAll = this.adminUserDomainRepository.findMenuAll();
        AdminMenu parent = new AdminMenu();
        parent.setId(0);
        parent.setLevel(0);
        parent.setMenuName("无父菜单");
        menuAll.add(parent);
        return CallResult.success(menuAll);
    }

    public CallResult<Object> saveMenu() {
        AdminMenu menu = new AdminMenu();
        BeanUtils.copyProperties(this.adminUserParam,menu);
        this.adminUserDomainRepository.saveMenu(menu);
        return CallResult.success();
    }

    public CallResult<Object> findMenuById() {
        AdminMenu menu = this.adminUserDomainRepository.findMenuById(this.adminUserParam.getMenuId());
        return CallResult.success(menu);
    }

    public CallResult<Object> updateMenu() {
        AdminMenu menu = new AdminMenu();
        BeanUtils.copyProperties(this.adminUserParam,menu);
        menu.setId(this.adminUserParam.getMenuId());
        this.adminUserDomainRepository.updateMenu(menu);
        return CallResult.success();
    }
}
