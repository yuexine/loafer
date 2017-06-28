package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.property.PostProperty;
import com.roysmond.loafer.api.property.PostPropertyImpl;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by wuyuexin on 2017/6/22.
 */
public interface PostService {

    Page<PostProperty> findPostsSummaryByType(String type, @NotNull int page, @NotNull int size);

    Page<PostProperty> findPostsSummaryByTopicNameAndType(String topicName, @NotNull String type, @NotNull int page, @NotNull @Max(value = 50) int size);

    PostProperty findPostById(@NotNull Long id);

    void createPost(PostPropertyImpl postProperty);

    void updatePost(PostProperty postProperty);

    void removePost(@NotNull Long id);
}
