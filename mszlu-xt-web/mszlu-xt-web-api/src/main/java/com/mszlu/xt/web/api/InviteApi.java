package com.mszlu.xt.web.api;

import com.mszlu.xt.common.model.CallResult;
import com.mszlu.xt.web.model.params.BillParam;
import com.mszlu.xt.web.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2023-01-10 上午 11:05
 */
@Controller
@RequestMapping("i")
public class InviteApi {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "all")
    @ResponseBody
    public CallResult all(){
        return billService.all(new BillParam());
    }

    @RequestMapping("gen")
    @ResponseBody
    public CallResult gen(@RequestBody BillParam billParam){
        return billService.gen(billParam);
    }

}
