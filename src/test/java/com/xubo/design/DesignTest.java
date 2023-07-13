package com.xubo.design;

import com.alibaba.fastjson.JSONObject;
import com.xubo.design.entity.domain.Student;
import com.xubo.design.feign.ActRuTaskFeignService;
import com.xubo.design.utils.FeignClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author xubo
 * @Date 2023/7/13 15:48
 * @Description：
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesignTest.class)
public class DesignTest {

    /**
     * 动态传入serverName
     */
    @Test
    public void testDynamicFeign() {
        ActRuTaskFeignService feignService = FeignClientUtils.build("serverName", ActRuTaskFeignService.class);
        Student student = new Student();
        JSONObject jsonObject = feignService.notifyTaskStatus(student);
        System.out.println("jsonObject = " + jsonObject);
    }

}
