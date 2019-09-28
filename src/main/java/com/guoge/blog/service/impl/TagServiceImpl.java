package com.guoge.blog.service.impl;

import com.guoge.blog.common.NotFoundException;
import com.guoge.blog.entity.Tag;
import com.guoge.blog.mapper.TagDao;
import com.guoge.blog.service.TagService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by limi on 2017/10/16.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Transactional
    @Override
    public Tag saveTag(Tag tag) {

        return tagDao.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {

        Optional<Tag> optional = tagDao.findById(id);
        if(optional.isPresent()){
            Tag tag = optional.get();
            return tag;
        }
        return null;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {

        return tagDao.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {

        return tagDao.findAll();
    }


    public List<Tag> listTagTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = new PageRequest(0, size, sort);
        return tagDao.findTop(pageable);
    }






    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag tag1 = this.getTag(id);
        if(tag1!=null){
            BeanUtils.copyProperties(tag1,tag);
            Tag updateTag = tagDao.save(tag1);
            return updateTag;
        }else {
            throw new NotFoundException("更新失败");
        }
    }



    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagDao.deleteById(id);
    }
}
