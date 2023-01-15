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

    /**
     * 查找用户管理页面
     * @param adminUserParam
     * @return
     */
    CallResult findPage(AdminUserParam adminUserParam);

    /**
     * 添加用户管理页面
     * @param adminUserParam
     * @return
     */
    CallResult addUser(AdminUserParam adminUserParam);

    /**
     * 通过id查找用户
     * @param adminUserParam
     * @return
     */
    CallResult findUserById(AdminUserParam adminUserParam);

    /**
     * 编辑
     * @param adminUserParam
     * @return
     */
    CallResult update(AdminUserParam adminUserParam);

    /**
     * 菜单分页查询
     * @param adminUserParam
     * @return
     */
    CallResult findMenuPage(AdminUserParam adminUserParam);

    /**
     *
     * @return
     */
    CallResult menuAll();

    /**
     * 保存菜单
     * @param adminUserParam
     * @return
     */
    CallResult saveMenu(AdminUserParam adminUserParam);

    /**
     * 通过id查找到菜单
     * @param adminUserParam
     * @return
     */
    CallResult findMenuById(AdminUserParam adminUserParam);

    /**
     * 更新菜单
     * @param adminUserParam
     * @return
     */
    CallResult updateMenu(AdminUserParam adminUserParam);

    //获取菜单列表
    CallResult userMenuList(AdminUserParam adminUserParam);

    /**
     * 角色添加
     * @param adminUserParam
     * @return
     */
    CallResult add(AdminUserParam adminUserParam);


    /**
     * 查到角色
     * @param adminUserParam
     * @return
     */
    CallResult findRoleById(AdminUserParam adminUserParam);

    /**
     * 编辑
     * @param adminUserParam
     * @return
     */
    CallResult updateRole(AdminUserParam adminUserParam);

    /**
     * 增加权限
     * @param adminUserParam
     * @return
     */
    CallResult addPermission(AdminUserParam adminUserParam);

    /**
     *
     * @param adminUserParam
     * @return
     */
    CallResult findPermissionById(AdminUserParam adminUserParam);

    CallResult roleAll();

}
