package com.xubo.design.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.ActRuTask;
import com.xubo.design.entity.enums.HandlerStateEnum;
import com.xubo.design.service.IStateHandlerService;
import com.xubo.design.service.StateHandlerService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

/**
 * @Author xubo
 * @Date 2023/7/13 15:57
 * @Description：
 * @Version 1.0
 */
@Service
public class StateHandlerServiceImpl implements StateHandlerService {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Redisson redisson;

    public IStateHandlerService getHandlerService(Integer handlerState) {
        HandlerStateEnum handlerStateEnum = Optional.ofNullable(HandlerStateEnum.e(handlerState))
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("获取类型处理失败， 原因：{0} 不存在", handlerState)));
        return Optional.ofNullable(applicationContext.getBean(handlerStateEnum.getCalssName(), IStateHandlerService.class))
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("获取类型处理失败， 原因：{0} 不存在", handlerState)));
    }


    @Override
    public JSONObject execute(ActRuTask actRuTask) {
        String taskIdStr = String.valueOf(actRuTask.getId());
        RLock lock = redisson.getLock(taskIdStr);
        if(lock.isLocked()) {
            return new JSONObject().fluentPut("error", "系统繁忙！");
        }
        IStateHandlerService handlerService;
        try {
            lock.lock();
            handlerService = getHandlerService(actRuTask.getId());
        } finally {
            lock.unlock();
        }
        return handlerService.handler(actRuTask);
    }
}
