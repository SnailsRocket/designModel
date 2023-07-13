package com.xubo.design.entity.enums;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Author xubo
 * @Date 2023/7/13 15:03
 * @Description：
 * @Version 1.0
 */
@Getter
public enum HandlerStateEnum {

    APPROVE(1, "同意", "aproverStateHandlerServiceImpl"),
    PENDING(2, "挂起", "pendingStateHandlerServiceImpl"),
    REJECT(3, "拒绝", "rejectStateHandlerServiceImpl"),
    TERMINATE(4, "终止", "terminateStateHandlerServiceImpl");

    private Integer id;
    private String desc;
    private String calssName;

    HandlerStateEnum(Integer id, String desc, String calssName) {
        this.id = id;
        this.desc = desc;
        this.calssName = calssName;
    }

    public static HandlerStateEnum e(Integer id) {
        Optional<HandlerStateEnum> first = Arrays.stream(values()).filter(e -> ObjectUtil.equal(id, e.getId())).findFirst();
        return first.isPresent() ? first.get() : null;
    }

    public static String getClassNameById(Integer id) {
        Optional<HandlerStateEnum> first = Arrays.stream(values()).filter(e -> ObjectUtil.equal(id, e.getId())).findFirst();
        return first.isPresent() ? first.get().getCalssName() : null;
    }
}
