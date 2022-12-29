package com.mszlu.xt.web.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jarno
 */
public enum TabEnum {
    /**
     * look name
     */
    TK(1,"题库"),
    SX(2,"升学"),
    OTHER(2,"其他");

    private static final Map<Integer, TabEnum> CODE_MAP = new HashMap<>(3);

    static{
        for(TabEnum status: values()){
            CODE_MAP.put(status.getCode(), status);
        }
    }

    /**
     * 根据code获取枚举值
     * @param code
     * @return
     */
    public static TabEnum valueOfCode(int code){
        return CODE_MAP.get(code);
    }

    private int code;
    private String msg;

    TabEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
