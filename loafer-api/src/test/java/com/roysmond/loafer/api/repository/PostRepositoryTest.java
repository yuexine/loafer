package com.roysmond.loafer.api.repository;

import com.roysmond.loafer.api.domain.Post;
import com.roysmond.loafer.api.domain.emun.PostStatus;
import com.roysmond.loafer.api.domain.emun.PostType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    public void getPostWithTagsById() throws Exception {
        Optional<Post> post = postRepository.findPostById(1L);
//        System.out.println(post);
    }

    @Test
    @Transactional
    public void findPublicHotPost() throws Exception {
        Page<Post> posts = postRepository.findPublicPost(PostStatus.PUBLIC, PostType.ARTICLE, new PageRequest(1, 10));
    }

}