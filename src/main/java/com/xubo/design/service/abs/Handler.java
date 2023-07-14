package com.xubo.design.service.abs;


import cn.hutool.core.util.ObjectUtil;
import com.xubo.design.entity.domain.UserInfo;

/**
 * @Author xubo
 * @Date 2023/7/14 10:46
 * @Description：责任链模式
 * @Version 1.0
 */
public abstract class Handler<E> {

    protected Handler chain;

    public void next(Handler handler) {
        this.chain = handler;
    }

    public abstract void doHandler(UserInfo userInfo);

    public static class Builder<E> {
        private Handler<E> head;
        private Handler<E> tail;
        public Builder<E> addHandler(Handler<E> handler) {
            if(ObjectUtil.isNull(this.head)) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }
        public Handler<E> build() {
            return this.head;
        }
    }
}
