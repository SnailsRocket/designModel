package com.xubo.design.service.stateHandler;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.ActRuTask;
import com.xubo.design.service.IStateHandlerService;
import org.springframework.stereotype.Service;

/**
 * @Author xubo
 * @Date 2023/7/13 14:57
 * @Description：
 * @Version 1.0
 */
@Service
public class AproverStateHandlerServiceImpl implements IStateHandlerService {

    @Override
    public JSONObject handler(ActRuTask actRuTask) {
        return new JSONObject().fluentPut("success", "审批通过！");
    }
}
