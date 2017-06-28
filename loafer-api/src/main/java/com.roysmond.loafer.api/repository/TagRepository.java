package com.roysmond.loafer.api.repository;

import com.roysmond.loafer.api.domain.Tag;
import com.roysmond.loafer.api.property.TagProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/23.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT post.tags FROM Post post where post.id = ?1")
    Set<TagProperty> findTagsByPostId(Long postId);
}
