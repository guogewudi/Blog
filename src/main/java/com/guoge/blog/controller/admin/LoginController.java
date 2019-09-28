package com.guoge.blog.controller.admin;

import com.guoge.blog.entity.User;
import com.guoge.blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    UserServiceImpl userService;
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }


    @PostMapping("/login")
    public String login(
            @RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
         User user = userService.checkUser(username, password);
         if(user!=null){
                 user.setPassword(null);
                 session.setAttribute("user",user);
                 return "admin/index";
         }else {
             attributes.addFlashAttribute("message","用户名或密码错误");
             return "redirect:/admin";
         }

    }

    @GetMapping("/logout")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin ";
    }


}
