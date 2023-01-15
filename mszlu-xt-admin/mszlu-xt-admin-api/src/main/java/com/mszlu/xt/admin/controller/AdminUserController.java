package com.mszlu.xt.admin.controller;

import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.service.AdminUserService;
import com.mszlu.xt.common.model.CallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2023-01-11 下午 11:04
 */
@RestController
@RequestMapping("user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "role/findRolePage")
    public CallResult findRolePage(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findRolePage(adminUserParam);
    }


    @RequestMapping(value = "permission/all")
    public CallResult permissionAll(){
        return adminUserService.permissionAll();
    }

    //角色添加
    @RequestMapping(value = "role/add")
    public CallResult roleAdd(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.add(adminUserParam);
    }

    @RequestMapping(value = "role/findRoleById")
    public CallResult findRoleById(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findRoleById(adminUserParam);
    }

    @RequestMapping(value = "role/update")
    public CallResult updateRole(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.updateRole(adminUserParam);
    }

    @RequestMapping(value = "permission/findPermissionPage")
    public CallResult findPermissionPage(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findPermissionPage(adminUserParam);
    }

    @RequestMapping(value = "permission/add")
    public CallResult addPermission(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.addPermission(adminUserParam);
    }

    @RequestMapping(value = "permission/findPermissionById")
    public CallResult findPermissionById(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findPermissionById(adminUserParam);
    }

    @RequestMapping(value = "permission/update")
    public CallResult updatePermission(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.updatePermission(adminUserParam);
    }

    //用户管理权限--查找页面
    @RequestMapping(value = "findPage")
    public CallResult findPage(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findPage(adminUserParam);
    }
    @RequestMapping(value = "role/all")
    public CallResult roleAll(){
        return adminUserService.roleAll();
    }
    @RequestMapping(value = "add")
    public CallResult add(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.addUser(adminUserParam);
    }

    //通过id查找用户
    @RequestMapping(value = "findUserById")
    public CallResult findUserById(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findUserById(adminUserParam);
    }

    @RequestMapping(value = "update")
    public CallResult update(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.update(adminUserParam);
    }

    @RequestMapping(value = "menu/findMenuPage")
    public CallResult findMenuPage(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findMenuPage(adminUserParam);
    }

    @RequestMapping(value = "menu/all")
    public CallResult menuAll(){
        return adminUserService.menuAll();
    }

    @RequestMapping(value = "menu/add")
    public CallResult saveMenu(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.saveMenu(adminUserParam);
    }

    @RequestMapping(value = "menu/findMenuById")
    public CallResult findMenuById(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.findMenuById(adminUserParam);
    }

    @RequestMapping(value = "menu/update")
    public CallResult updateMenu(@RequestBody AdminUserParam adminUserParam){
        return adminUserService.updateMenu(adminUserParam);
    }

    @RequestMapping(value = "userMenuList")
    public CallResult userMenuList(){
        return adminUserService.userMenuList(new AdminUserParam());
    }

}
