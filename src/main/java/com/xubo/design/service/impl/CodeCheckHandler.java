package com.xubo.design.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xubo.design.entity.domain.UserInfo;
import com.xubo.design.service.abs.Handler;
import org.springframework.stereotype.Service;

/**
 * @Author xubo
 * @Date 2023/7/14 10:50
 * @Description：
 * @Version 1.0
 */
public class CodeCheckHandler extends Handler {
    @Override
    public void doHandler(UserInfo userInfo) {
        if(ObjectUtil.notEqual(userInfo.getCode(), "666")) {
            System.out.println("手机验证码不正确！");
            return;
        }
        System.out.println("手机验证码没问题，继续执行。。。");
        chain.doHandler(userInfo);
    }
}
