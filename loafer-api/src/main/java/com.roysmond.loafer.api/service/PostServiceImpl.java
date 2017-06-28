package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.domain.Post;
import com.roysmond.loafer.api.domain.Tag;
import com.roysmond.loafer.api.domain.emun.PostStatus;
import com.roysmond.loafer.api.domain.emun.PostType;
import com.roysmond.loafer.api.property.PostProperty;
import com.roysmond.loafer.api.property.PostPropertyImpl;
import com.roysmond.loafer.api.property.TagPropertyImpl;
import com.roysmond.loafer.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wuyuexin on 2017/6/22.
 */
@Service
@Validated
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    private String[] ignores;

    @Override
    public Page<PostProperty> findPostsSummaryByType(String type, int page, int size) {
        return null;
    }

    @Override
    public Page<PostProperty> findPostsSummaryByTopicNameAndType(String topicName, String type, int page, final int size) {
        final String[] types = new String[]{"latest", "recommend", "hot", "comment"};
        page = page - 1 > 0 ? page - 1 : 0;

        Pageable pageable = new PageRequest(page, size);

        if (Arrays.asList(types).contains(type)) {
            switch (type) {
                case "latest": {
                    if (StringUtils.isEmpty(topicName)) {
                        return convertPost(postRepository.findPublicPost(PostStatus.PUBLIC, pageable), page, size);
                    } else {
                        return convertPost(postRepository.findPublicPost(topicName, PostStatus.PUBLIC, pageable), page, size);
                    }
                }
                case "recommend": {
                    if (StringUtils.isEmpty(topicName)) {
                        return convertPost(postRepository.findPublicRecommendPost(PostStatus.PUBLIC, true, pageable), page, size);
                    } else {
                        return convertPost(postRepository.findPublicRecommendPost(topicName, PostStatus.PUBLIC, true, pageable), page, size);
                    }
                }
                case "hot": {
                    if (StringUtils.isEmpty(topicName)) {
                        return convertPost(postRepository.findPublicHotPost(PostStatus.PUBLIC, true, pageable), page, size);
                    } else {
                        return convertPost(postRepository.findPublicHotPost(topicName, PostStatus.PUBLIC, true, pageable), page, size);
                    }
                }
                case "comment": {
                    if (StringUtils.isEmpty(topicName)) {
                        return convertPost(postRepository.findPublicPost(PostStatus.PUBLIC, PostType.ISSUE, pageable), page, size);
                    } else {
                        return convertPost(postRepository.findPublicPost(topicName, PostStatus.PUBLIC, PostType.ISSUE, pageable), page, size);
                    }
                }
                default: {
                    break;
                }
            }
            return null;
        } else {
            throw new IllegalArgumentException(type);
        }
    }

    @Override
    public PostProperty findPostById(Long id) {
        return convertSinglePost(postRepository.findPostById(id).get());
    }

    @Override
    public void createPost(PostPropertyImpl postProperty) {

    }

    @Override
    public void updatePost(PostProperty postProperty) {

    }

    @Override
    public void removePost(Long id) {

    }


    private Page<PostProperty> convertPost(Page<Post> posts, int page, int size, String... ignores) {
        List<PostProperty> postProperties = posts.getContent().stream().map(post -> {
            //TODO ignores impl
            return convertSinglePost(post);
        }).collect(Collectors.toList());
        PageImpl pi = new PageImpl(postProperties, new PageRequest(page, size), posts.getTotalPages());
        return pi;
    }


    private PostProperty convertSinglePost(Post post) {
        PostPropertyImpl pp = new PostPropertyImpl();
        pp.setHits(post.getHits());
        pp.setId(post.getId());
        pp.setSummary(post.getSummary());
        pp.setTitle(post.getTitle());
        pp.setVoteUp(post.getVoteUp());
        pp.setContent(post.getContent());
        pp.setTags(convertTag(post.getTags()));
        return pp;
    }

    private Set<TagPropertyImpl> convertTag(Set<Tag> tags) {
        return tags.stream().map(tag -> {
            TagPropertyImpl tp = new TagPropertyImpl();
            tp.setId(tag.getId());
            tp.setInfo(tag.getInfo());
            tp.setName(tag.getName());
            tp.setPostCount(tag.getPostCount());
            tp.setFollowersCount(tag.getFollowersCount());
            return tp;
        }).collect(Collectors.toSet());
    }

}

