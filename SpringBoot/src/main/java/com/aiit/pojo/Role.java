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
public class Role {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("name")
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 修改时间

    @Version
    private Integer version; // 乐观锁


}
