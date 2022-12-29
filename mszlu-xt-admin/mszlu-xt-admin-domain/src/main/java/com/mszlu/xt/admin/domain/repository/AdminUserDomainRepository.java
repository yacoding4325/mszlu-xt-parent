package com.mszlu.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mszlu.xt.admin.dao.AdminUserMapper;
import com.mszlu.xt.admin.dao.data.AdminUser;
import com.mszlu.xt.admin.domain.AdminUserDomain;
import com.mszlu.xt.admin.params.AdminUserParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author yaCoding
 * @create 2022-12-29 下午 7:59
 */
@Component
public class AdminUserDomainRepository {

    @Resource
    private AdminUserMapper adminUserMapper;

    public AdminUserDomain createDomain(AdminUserParam adminUserParam) {
        return new AdminUserDomain(this,adminUserParam);
    }

    public AdminUser findUserByUsername(String username) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        //limit 1优化sql 防止进行全表查询
        queryWrapper.eq(AdminUser::getUsername,username).last("limit 1");
        return adminUserMapper.selectOne(queryWrapper);
    }

}
