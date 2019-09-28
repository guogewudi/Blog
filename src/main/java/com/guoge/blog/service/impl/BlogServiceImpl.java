package com.guoge.blog.service.impl;

import com.guoge.blog.common.NotFoundException;
import com.guoge.blog.entity.Blog;
import com.guoge.blog.entity.Type;
import com.guoge.blog.mapper.BlogDao;
import com.guoge.blog.service.BlogService;
import com.guoge.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/24
 * Description:
 */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;
    @Override
    public Blog getBlog(Long id) {
        Optional<Blog> optional = blogDao.findById(id);
        if(optional.isPresent()){
            Blog blog = optional.get();
            return blog;
        }
        return null;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%"+blog.getTitle()+"%"));
                }
                Long typeId = blog.getTypeId();

                if (typeId != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), typeId));
                }
                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
         Blog saveBlog = blogDao.save(blog);
         return saveBlog;
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog blog1 = this.getBlog(id);
        if(blog1!=null){
            BeanUtils.copyProperties(blog1,blog);
            Blog updateBlog = blogDao.save(blog1);
            return updateBlog;
        }else {
            throw new NotFoundException("更新失败");
        }
    }

    @Override
    public void deleteBlog(Long id) {
          blogDao.deleteById(id);
    }
}
