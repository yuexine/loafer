package com.roysmond.loafer.api.domain;

import com.roysmond.loafer.api.domain.emun.PostStatus;
import com.roysmond.loafer.api.domain.emun.PostType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Post Or A Issue
 * <p>
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "post")
public class Post extends AbstractAuditingModel implements Serializable {

    @NotNull
    @Size(max = 100)
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "summary")
    private String summary;

    @Size(max = 1048576)
    @Column(name = "content", length = 1048576)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type")
    private PostType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "share_at")
    private LocalDateTime shareAt;

    @Column(name = "vote_up", nullable = false)
    private int voteUp = 0;

    @Column(name = "vote_down", nullable = false)
    private int voteDown = 0;

    @Column(name = "hits", nullable = false)
    private int hits = 0;

    @Column(name = "replies", nullable = false)
    private int replies = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_focus",
            joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> focus = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "posts_tags",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)})
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private Set<Vote> votes = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
    private Set<Reply> replySet = new HashSet<>();

    @OneToMany(orphanRemoval = true, mappedBy = "post")
    private Set<Message> messages = new HashSet<>();

}
