package com.guoge.blog.service;

import com.guoge.blog.entity.User;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
public interface UserService
{
    User checkUser(String username,String password);
}
