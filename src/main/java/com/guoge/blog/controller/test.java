package com.guoge.blog.controller;

import com.guoge.blog.common.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/19
 * Description:
 */
@Controller
public class test {
    @GetMapping("/")
    public String index(){
//        int i = 9/0;
//        String blog = null;
//        if(blog==null){
//            throw new NotFoundException("blog不存在");
//        }
        System.out.println("--------index--------");


        return "index";
    }

    @GetMapping("/hh")
    public String error(){
        return "/error/404";
    }

}
