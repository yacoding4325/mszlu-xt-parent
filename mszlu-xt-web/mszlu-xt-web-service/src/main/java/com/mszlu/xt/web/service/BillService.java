package com.mszlu.xt.web.service;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.BillParam;

/**
 * @Author yaCoding
 * @create 2023-01-10 上午 11:09
 */

public interface BillService {

    /**
     * 查询所有的海报列表
     * @return
     */
    CallResult all(BillParam billParam);

    /**
     * 生成推广链接(海报)
     * @param billParam
     * @return
     */
    CallResult gen(BillParam billParam);

}
