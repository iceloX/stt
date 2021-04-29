package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;// 编号
    private String name;  // 名字

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;  // 更新时间
    @Version
    private Integer version; // 乐观锁
}
