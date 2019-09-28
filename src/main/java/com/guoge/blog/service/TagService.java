package com.guoge.blog.service;

import com.guoge.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/24
 * Description:
 */
public interface TagService {
    Tag saveTag(Tag type);
    Tag getTag(Long id);
    Tag getTagByName(String name);
    Page<Tag> listTag(Pageable pageable);
    Tag updateTag(Long id,Tag type);
    void deleteTag(Long id);

    List<Tag> listTag();
 }
