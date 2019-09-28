package com.guoge.blog.service.impl;

import com.guoge.blog.common.NotFoundException;
import com.guoge.blog.entity.Type;
import com.guoge.blog.mapper.TypeDao;
import com.guoge.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/23
 * Description:
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        Optional<Type> optional = typeDao.findById(id);
        if(optional.isPresent()){
            Type type = optional.get();
            return type;
        }
        return null;
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        Page<Type> all = typeDao.findAll(pageable);
        return all;
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type type1 = this.getType(id);
        if(type1!=null){
            type1.setId(type.getId());
            type1.setName(type.getName());
            type1.setBlogs(type.getBlogs());
            Type save = typeDao.save(type1);
            return save;
        }else {
            throw new NotFoundException("更新失败");
        }


    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteById(id);
    }

    @Transactional
    public Type getTypeByName(String name) {
        return typeDao.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeDao.findAll();
    }
}
