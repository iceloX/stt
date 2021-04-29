package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activity")
public class Activity {

    @TableId(type = IdType.ASSIGN_ID) // 雪花算法
    private Long id;// 编号
    private String name; // 名称
    private String description;// 描述
    private Date begin; // 开始时间
    private Date end; // 结束时间
    private String cover; // 封面
    private String place;// 地点
    private Float score; // 分数
    private Integer status; // 状态

    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 修改时间

    @Version
    private Integer version; // 乐观锁
}
