package com.roysmond.loafer.api.service;

import java.util.List;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/23.
 */
public interface TagService {

    Set findTagsByPostId(Long postId);
}
