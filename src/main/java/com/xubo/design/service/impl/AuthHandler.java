package com.xubo.design.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xubo.design.entity.domain.UserInfo;
import com.xubo.design.service.abs.Handler;
import org.springframework.stereotype.Service;

/**
 * @Author xubo
 * @Date 2023/7/14 10:54
 * @Description：
 * @Version 1.0
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandler(UserInfo userInfo) {
        if(ObjectUtil.notEqual("管理员", userInfo.getRoleName())) {
            System.out.println("用户不是管理员，没有操作权限！");
            return;
        }
        System.out.println("有操作权限。");
    }
}
