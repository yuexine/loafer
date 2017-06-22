package com.roysmond.loafer.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Table(name = "tag")
@Entity
public class Tag extends AbstractTimeModel {

    @Column(name = "name", nullable = false, updatable = false, unique = true, length = 30)
    private String name;

    @Column(name = "info", nullable = false, length = 100)
    private String info;

    @Column(name = "image", nullable = false, length = 255)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "post_count", nullable = false)
    private Long postCount = 0L;

    @Column(name = "followers_count", nullable = false)
    private Long followersCount = 0L;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();
}
