package com.xubo.design.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xubo.design.entity.domain.UserInfo;
import com.xubo.design.service.abs.Handler;
import org.springframework.stereotype.Service;

/**
 * @Author xubo
 * @Date 2023/7/14 10:52
 * @Description：
 * @Version 1.0
 */
public class CheckExistsHandler extends Handler {
    @Override
    public void doHandler(UserInfo userInfo) {
        if(ObjectUtil.isEmpty(userInfo)) {
            System.out.println("用户不存在！");
            return;
        }
        System.out.println("用户存在，继续执行。。。");
        userInfo.setRoleName("管理员");
        chain.doHandler(userInfo);
    }
}
