package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions 这个是一个管理员类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Long id; // 编号
    private String username; // 用户名
    private String phone; // 手机号
    private String email; // 邮箱
    private String password;// 密码
    private String salt; // 盐值
    private Integer status; // 状态

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Version
    private Integer version; // 乐观锁

}
