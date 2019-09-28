package com.guoge.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/20
 * Description:
 */
@Entity
@Table(name = "t_tag")
@Data
public class Tag {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
