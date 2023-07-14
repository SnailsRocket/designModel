package com.xubo.design.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xubo
 * @Date 2023/7/14 10:48
 * @Description：
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String userName;
    private String roleName;
    private String phoneNum;
    private String code;

}
