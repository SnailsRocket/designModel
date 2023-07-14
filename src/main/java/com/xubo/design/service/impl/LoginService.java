package com.xubo.design.service.impl;

import com.xubo.design.entity.domain.UserInfo;
import org.springframework.stereotype.Service;

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
}
