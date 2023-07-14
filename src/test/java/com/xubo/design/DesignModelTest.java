package com.xubo.design;

import com.xubo.design.service.impl.LoginService;
import org.junit.Test;

/**
 * @Author xubo
 * @Date 2023/7/14 11:05
 * @Description：
 * @Version 1.0
 */
public class DesignModelTest {

    @Test
    public void testChainDesignModel() {
        LoginService loginService = new LoginService();
        loginService.login("18627837596", "666");
    }
}
