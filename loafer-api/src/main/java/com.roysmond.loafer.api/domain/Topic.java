package com.roysmond.loafer.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Topic
 * <p>
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "topic")
public class Topic extends AbstractAuditingModel implements Serializable {

    @Column(name = "name", nullable = false, length = 60, unique = true)
    private String name;

    @Column(name = "friendly_name", nullable = false)
    private String friendlyName;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "weight")
    private Integer weight = 0;

    @ManyToMany
    @JoinTable(name = "topic_tags",
            joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();
}
