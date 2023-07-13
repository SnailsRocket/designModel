package com.xubo.design.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author xubo
 * @Date 2023/7/13 15:49
 * @Description：
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActRuTask implements Serializable {

    private Integer id;

    private String taskCode;

    private String taskName;

    private Date createTime;

    private Integer createId;

}
