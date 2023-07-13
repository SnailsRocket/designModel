package com.xubo.design.service;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.ActRuTask;

/**
 * @Author xubo
 * @Date 2023/7/13 15:57
 * @Description：
 * @Version 1.0
 */
public interface StateHandlerService {

    JSONObject execute(ActRuTask actRuTask);

}
