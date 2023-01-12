package com.mszlu.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.admin.dao.*;
import com.mszlu.xt.admin.dao.data.*;
import com.mszlu.xt.admin.domain.AdminUserDomain;
import com.mszlu.xt.admin.params.AdminUserParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 7:59
 */
@Component
public class AdminUserDomainRepository {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Resource
    private AdminUserRoleMapper adminUserRoleMapper;

    @Resource
    private AdminRolePermissionMapper adminRolePermissionMapper;

    @Resource
    private AdminPermissionMapper adminPermissionMapper;


    public AdminUserDomain createDomain(AdminUserParam adminUserParam) {
        return new AdminUserDomain(this,adminUserParam);
    }

    public AdminUser findUserByUsername(String username) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        //limit 1优化sql 防止进行全表查询
        queryWrapper.eq(AdminUser::getUsername,username).last("limit 1");
        return adminUserMapper.selectOne(queryWrapper);
    }

    public List<Integer> findRoleIdListByUserId(Long userId) {
        LambdaQueryWrapper<AdminUserRole> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminUserRole::getUserId,userId);
        List<AdminUserRole> adminUserRoleList = adminUserRoleMapper.selectList(queryWrapper);
        return adminUserRoleList.stream().map(AdminUserRole::getRoleId).collect(Collectors.toList());
    }


    public List<Integer> findPermissionIdListByRoleIds(List<Integer> roleIdList) {
        LambdaQueryWrapper<AdminRolePermission> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(AdminRolePermission::getRoleId,roleIdList);
        List<AdminRolePermission> adminRolePermissions = this.adminRolePermissionMapper.selectList(queryWrapper);
        return adminRolePermissions.stream().map(AdminRolePermission::getPermissionId).collect(Collectors.toList());
    }

    public List<AdminPermission> findPermissionByIds(List<Integer> permissionIdList) {
        LambdaQueryWrapper<AdminPermission> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(AdminPermission::getId,permissionIdList);
        return adminPermissionMapper.selectList(queryWrapper);
    }

    public Page<AdminRole> findRoleList(int page, int pageSize) {
        return adminRoleMapper.selectPage(new Page<>(page,pageSize),Wrappers.lambdaQuery());
    }

    public List<AdminPermission> findAllPermission() {
        return adminPermissionMapper.selectList(Wrappers.lambdaQuery());
    }

    public Page<AdminPermission> findPermissionList(int page, int pageSize) {
        return adminPermissionMapper.selectPage(new Page<>(page,pageSize),Wrappers.lambdaQuery());
    }

    public void updatePermission(AdminPermission adminPermission) {
        adminPermissionMapper.updateById(adminPermission);
    }
}
