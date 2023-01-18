package com.mszlu.xt.common.service;


import com.mszlu.xt.common.model.CallResult;

public abstract class AbstractTemplateAction<T> implements TemplateAction<T> {
    @Override
    public CallResult<T> checkParam() {
        return CallResult.success();
    }

    @Override
    public CallResult<T> checkBiz() {
        return CallResult.success();
    }

    @Override
    public void finishUp(CallResult<T> callResult) {

    }
}
