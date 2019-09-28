package com.guoge.blog.mapper;

import com.guoge.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);


}
