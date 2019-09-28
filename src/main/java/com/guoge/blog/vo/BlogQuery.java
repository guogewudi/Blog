package com.guoge.blog.vo;

import lombok.Data;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/24
 * Description:
 */
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;
}
