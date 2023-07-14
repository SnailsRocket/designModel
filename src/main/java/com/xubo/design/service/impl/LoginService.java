package com.xubo.design.service.impl;

import com.xubo.design.entity.domain.UserInfo;
import com.xubo.design.service.abs.Handler;

/**
 * @Author xubo
 * @Date 2023/7/14 10:56
 * @Description：
 * @Version 1.0
 */
public class LoginService {

    public void login(String phoneNum, String code) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhoneNum(phoneNum);
        userInfo.setCode(code);
        CodeCheckHandler codeCheckHandler = new CodeCheckHandler();
        CheckExistsHandler checkExistsHandler = new CheckExistsHandler();
        AuthHandler authHandler = new AuthHandler();
        codeCheckHandler.next(checkExistsHandler);
        checkExistsHandler.next(authHandler);
        codeCheckHandler.doHandler(userInfo);
    }

    public void buildLogin(String phoneNum, String code) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhoneNum(phoneNum);
        userInfo.setCode(code);
        // 链式编程
        Handler.Builder<Object> builder = new Handler.Builder<>();
        builder.addHandler(new CodeCheckHandler())
                .addHandler(new CheckExistsHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(userInfo);
    }
}
