package com.guoge.blog.service;

import com.guoge.blog.entity.Blog;
import com.guoge.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/24
 * Description:
 */
public interface BlogService {
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable,BlogQuery blog);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id ,Blog blog);
    void deleteBlog(Long id);
}

