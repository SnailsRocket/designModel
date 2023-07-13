package com.xubo.design.feign;


import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author xubo
 * @Date 2023/7/10 17:53
 * @Description：动态feign 模板
 * @Version 1.0
 */
public interface ActRuTaskFeignService {

    /**
     * 审批完成回调
     * @param student
     * @return
     */
    @PostMapping("/feign/operate/notifyTaskStatus")
    public JSONObject notifyTaskStatus(@RequestBody Student student);
}
