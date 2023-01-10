package com.mszlu.xt.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yaCoding
 * @create 2023-01-10 上午 11:26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillModel {

    private Long id;

    private String name;

    private String billDesc;

    private String billType;

}
