package com.roysmond.loafer.api.repository;

import com.roysmond.loafer.api.domain.Post;
import com.roysmond.loafer.api.domain.emun.PostStatus;
import com.roysmond.loafer.api.domain.emun.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @EntityGraph(attributePaths = {"tags"})
    Optional<Post> findPostById(Long id);

    @Query(value = "select post from Post post join fetch post.tags tag where post.status = :postStatus",
            countQuery = "select count(post) from Post post where post.status = :postStatus")
    Page<Post> findPublicPost(@Param("postStatus") PostStatus postStatus, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.hot = :hot and post.status = :postStatus",
            countQuery = "select count(post) from Post post join post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.hot = :hot and post.status = :postStatus")
    Page<Post> findPublicHotPost(@Param("topicName") String topicName, @Param("postStatus") PostStatus postStatus, @Param("hot") Boolean hot, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.recommend = :recommend and post.status = :postStatus",
            countQuery = "select count(post) from Post post join post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.recommend = :recommend and post.status = :postStatus")
    Page<Post> findPublicRecommendPost(@Param("topicName") String topicName, @Param("postStatus") PostStatus postStatus, @Param("recommend") Boolean recommend, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where post.hot = :hot and post.status = :postStatus",
            countQuery = "select count(post) from Post post join post.tags tag where post.hot = :hot and post.status = :postStatus")
    Page<Post> findPublicHotPost(@Param("postStatus") PostStatus postStatus, @Param("hot") Boolean hot, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where post.recommend = :recommend and post.status = :postStatus",
            countQuery = "select count(post) from Post post join post.tags tag where post.recommend = :recommend and post.status = :postStatus")
    Page<Post> findPublicRecommendPost(@Param("postStatus") PostStatus postStatus, @Param("recommend") Boolean recommend, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where post.status = :postStatus and post.type = :postType",
            countQuery = "select count(post) from Post post where post.status = :postStatus and post.type = :postType")
    Page<Post> findPublicPost(@Param("postStatus") PostStatus postStatus, @Param("postType") PostType postType, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName and post.status = :postStatus)",
            countQuery = "select count(post) from Post post join post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName and post.status = :postStatus)")
    Page<Post> findPublicPost(@Param("topicName") String topicName, @Param("postStatus") PostStatus postStatus, Pageable pageable);

    @Query(value = "select post from Post post join fetch post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.status = :postStatus and post.type = :postType",
            countQuery = "select count(post) from Post post join post.tags tag where tag.id in (select topicTag.id from Topic topic join topic.tags topicTag where topic.name = :topicName) and post.status = :postStatus and post.type = :postType")
    Page<Post> findPublicPost(@Param("topicName") String topicName, @Param("postStatus") PostStatus postStatus, @Param("postType") PostType postType, Pageable pageable);

}
