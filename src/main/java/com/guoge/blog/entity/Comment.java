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
@Entity
@Table(name = "t_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    private Blog blog;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComment = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;
}
