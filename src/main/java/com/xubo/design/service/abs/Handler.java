package com.xubo.design.service.abs;


import com.xubo.design.entity.domain.UserInfo;

/**
 * @Author xubo
 * @Date 2023/7/14 10:46
 * @Description：责任链模式
 * @Version 1.0
 */
public abstract class Handler {

    protected Handler chain;

    public void next(Handler handler) {
        this.chain = handler;
    }

    public abstract void doHandler(UserInfo userInfo);
}
