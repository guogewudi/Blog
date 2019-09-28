package com.guoge.blog.controller.admin;

import com.guoge.blog.entity.Blog;
import com.guoge.blog.service.impl.BlogServiceImpl;
import com.guoge.blog.service.impl.TagServiceImpl;
import com.guoge.blog.service.impl.TypeServiceImpl;
import com.guoge.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */

@Controller
@RequestMapping("/admin")
public class BlogsController {
    public static final String INPUT ="admin/blogs-input";
    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private TypeServiceImpl typeService;

    @Autowired
    private TagServiceImpl tagService;
    @GetMapping("/blogs")
    public String getBlogs(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, BlogQuery  blog, Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs :: blogList";
    }


    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
       return INPUT;
    }


}
