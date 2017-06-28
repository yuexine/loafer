package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.property.TagProperty;
import com.roysmond.loafer.api.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Set<TagProperty> findTagsByPostId(Long postId) {
        return tagRepository.findTagsByPostId(postId);
    }
}
