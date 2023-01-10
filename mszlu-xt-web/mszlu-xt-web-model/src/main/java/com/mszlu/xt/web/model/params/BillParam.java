package com.mszlu.xt.web.model.params;


import lombok.Data;

/**
 * @Author yaCoding
 * @create 2023-01-10 上午 11:10
 */

@Data
public class BillParam {

    private Integer page = 1;

    private Integer pageSize = 10;

    private Long id;

    private String name;

    private String billDesc;

    private String billType;

    /**
     * 0 正常 1 删除
     */
    private Integer status;

    private Long userId;

}
