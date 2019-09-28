package com.guoge.blog.service.impl;

import com.guoge.blog.entity.User;
import com.guoge.blog.mapper.UserDao;
import com.guoge.blog.service.UserService;
import com.guoge.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User checkUser(String username, String password) {

        User byUsernameAndPassword = userDao.findByUsernameAndPassword(username, MD5Utils.code(password) );
        return byUsernameAndPassword;
    }
}
