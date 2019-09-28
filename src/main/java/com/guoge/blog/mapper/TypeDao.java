package com.guoge.blog.mapper;

import com.guoge.blog.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
public interface TypeDao extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
