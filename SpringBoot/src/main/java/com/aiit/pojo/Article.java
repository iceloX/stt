package com.aiit.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author icelo
 * @Date 2021/4/28
 * @Descriptions 这个是一个文章类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id; // 编号
    private String name; // 名字
    private String content; // 内容
    private String cover; // 封面
    private String describe; // 描述
    private String author;// 作者
    private Integer status; // 文章状态
    private String category;// 文章的分类
    private Integer views; // 文章的访问量

    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 更新时间

    @Version
    private Integer version; // 乐观锁
}
