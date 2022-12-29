package com.mszlu.xt.admin.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.xt.admin.dao.AdminUserMapper;
import com.mszlu.xt.admin.dao.NewsMapper;
import com.mszlu.xt.admin.dao.data.AdminUser;
import com.mszlu.xt.admin.domain.AdminUserDomain;
import com.mszlu.xt.admin.domain.NewsDomain;
import com.mszlu.xt.admin.domain.qiniu.QiniuConfig;
import com.mszlu.xt.admin.params.AdminUserParam;
import com.mszlu.xt.admin.params.NewsParam;
import com.mszlu.xt.pojo.News;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NewsDomainRepository {

    @Autowired
    public QiniuConfig qiniuConfig;

    @Resource
    private NewsMapper newsMapper;

    public NewsDomain createDomain(NewsParam newsParam) {
        return new NewsDomain(this,newsParam);
    }

    public Page<News> findNewsPageByCondition(int currentPage, int pageSize, String queryString) {
        Page<News> page = new Page<>(currentPage,pageSize);
        LambdaUpdateWrapper<News> queryWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(queryString)){
            queryWrapper.like(News::getTitle,queryString);
        }
        return newsMapper.selectPage(page, queryWrapper);
    }

    public void save(News news) {
        this.newsMapper.insert(news);
    }

    public News findNewsById(Long id) {
        return newsMapper.selectById(id);
    }

    public void update(News news) {
        this.newsMapper.updateById(news);
    }

}
