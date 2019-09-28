package com.guoge.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/20
 * Description:
 */
@Data
@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    //赞赏功能
    private boolean appreciation;
    private boolean shareStatement;
//是否评论
    private boolean comment;
    //是否发布
    private boolean published;
//是否推荐
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;


    public Blog(){}

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
}
