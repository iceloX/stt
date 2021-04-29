package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions 社团类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name; // 名称
    private String description; // 描述
    private String logo; // logo图片
    private String head; // 负责人的名字
    private Integer status; // 状态
    private Float score; // 分数
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 更新时间
    @Version
    private Integer version;

}
