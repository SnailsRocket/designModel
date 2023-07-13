package com.xubo.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.ActRuTask;
import com.xubo.design.service.StateHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xubo
 * @Date 2023/7/13 15:53
 * @Description：
 * @Version 1.0
 */
@RestController
@RequestMapping("/state")
public class StateHandlerController {

    @Autowired
    StateHandlerService stateHandlerService;

    @PostMapping("/handler")
    public JSONObject stateHandler(@RequestBody ActRuTask actRuTask) {
        return stateHandlerService.execute(actRuTask);
    }

}
