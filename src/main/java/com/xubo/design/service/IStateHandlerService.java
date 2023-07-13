package com.xubo.design.service;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.ActRuTask;

/**
 * @Author xubo
 * @Date 2023/7/13 14:53
 * @Description：状态模式
 * @Version 1.0
 */
public interface IStateHandlerService {

    JSONObject handler(ActRuTask actRuTask);
}
