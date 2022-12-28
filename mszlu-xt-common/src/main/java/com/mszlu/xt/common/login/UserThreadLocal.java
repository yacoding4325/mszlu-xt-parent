package com.mszlu.xt.common.login;

public class UserThreadLocal {

    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();


    public static void put(Long userId){
        LOCAL.set(userId);
    }

    public static Long get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
