package com.roysmond.loafer.api.domain;

import com.roysmond.loafer.api.domain.emun.ReplyStatus;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "reply")
public class Reply extends AbstractTimeModel implements Serializable {

    @NotNull
    @Size(max = 65535)
    @Column(name = "context", length = 65535, nullable = false)
    @Type(type = "text")
    private String content;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReplyStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_to_id")
    private Reply replyTo;
}
