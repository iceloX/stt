package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @JsonSerialize(using = ToStringSerializer.class) //  这个注解作用将Long类型转化为String类型，避免在前端的精度丢失问题
    private Long id;// 编号
    private String name; // 名称
    private String description;// 描述
    private Date begin; // 开始时间
    private Date end; // 结束时间
    private String cover; // 封面
    private String place;// 地点
    private Float score; // 分数
    private Integer status; // 状态 活动的状态：-1 未开始，0 进行中，1 已结束

    @TableField(exist = false)
    private List<User> users; // 参加活动人员

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 修改时间

    @Version
    private Integer version; // 乐观锁
}
