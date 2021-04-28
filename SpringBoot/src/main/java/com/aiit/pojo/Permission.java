package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions
 */
public class Permission {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;// 编号
    private String name;  // 名字

    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;  // 更新时间
    @Version
    private Integer version; // 乐观锁
}
