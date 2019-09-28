package com.guoge.blog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/20
 * Description:
 */

@Entity
@Data
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
