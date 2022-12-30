package com.mszlu.xt.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jarno
 */
public enum TopicType {
    /**
     * look name
     */
    FILL_BLANK(0,"fill blank"),
    RADIO(1,"radio"),
    MUL_CHOICE(2,"mul choice"),
    QA(3,"question or answer"),
    JUDGE(4,"judge");

    private static final Map<Integer, TopicType> CODE_MAP = new HashMap<>(3);

    static{
        for(TopicType topicType: values()){
            CODE_MAP.put(topicType.getCode(), topicType);
        }
    }

    /**
     * 根据code获取枚举值
     * @param code
     * @return
     */
    public static TopicType valueOfCode(int code){
        return CODE_MAP.get(code);
    }

    private int code;
    private String msg;

    TopicType(int code, String msg) {
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
