package com.mszlu.xt.common.service;


import com.mszlu.xt.common.model.CallResult;

/**
 * @author Jarno
 */
public interface ServiceTemplate {//服务模板


    /**
     * run in  datasource and execute Transaction --在数据源中运行并执行事务
     * @param action
     * @param <T>
     * @return
     */
    <T> CallResult<T> execute(TemplateAction<T> action);

    /**
     * run in  datasource and not execute Transaction --在数据源中运行不执行事务
     * @param action
     * @param <T>
     * @return
     */
    <T> CallResult<T> executeQuery(TemplateAction<T> action);
}
