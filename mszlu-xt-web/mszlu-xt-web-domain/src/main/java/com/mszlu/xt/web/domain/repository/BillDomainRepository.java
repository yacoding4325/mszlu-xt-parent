package com.mszlu.xt.web.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mszlu.xt.pojo.Bill;
import com.mszlu.xt.web.dao.BillMapper;
import com.mszlu.xt.web.domain.BillDomain;
import com.mszlu.xt.web.model.enums.DeleteStatus;
import com.mszlu.xt.web.model.params.BillParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yaCoding
 * @create 2023-01-10 上午 11:13
 */
@Component
public class BillDomainRepository {

    @Value("${invite.url}")
    public String inviteUrl;

    public BillDomain createDomain(BillParam billParam) {
        return new BillDomain(this,billParam);
    }

    @Resource
    private BillMapper billMapper;

    public List<Bill> findAll() {
        LambdaQueryWrapper<Bill> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Bill::getDeleteStatus, DeleteStatus.NORMAL.getCode());
        return billMapper.selectList(queryWrapper);
    }

    public Bill findBill(Long id) {
        return billMapper.selectById(id);
    }
}
