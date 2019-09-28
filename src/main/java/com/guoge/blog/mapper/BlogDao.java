package com.guoge.blog.mapper;

import com.guoge.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/24
 * Description:
 */
public interface BlogDao extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog> {
}
