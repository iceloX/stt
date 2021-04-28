package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/27
 * @Descriptions 这个是一个用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {

    @TableId(type = IdType.ASSIGN_ID) // 雪花算法
    private Long id; // 编号
    private String nickname; // 昵称
    private String snumber; // 学号
    @TableField("open_ud")
    private String openId; // open_id
    private String phone; // 手机号
    private String cls; // 班级
    private String avatar; // 头像
    private Integer status; // 状态


    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 更新时间

    @Version
    private Integer version; // 乐观锁


}
