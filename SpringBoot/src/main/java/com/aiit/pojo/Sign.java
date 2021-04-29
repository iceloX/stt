package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
public class Sign {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;  // 名字
    private Date begin; // 开始时间
    private Date end; // 结束时间
    private BigDecimal jd; // 经度
    private BigDecimal wd; // 纬度
    private Integer range; // 范围
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 修改时间
    @Version
    private Integer version; // 乐观锁


}
