package com.roysmond.loafer.api.domain;

import com.roysmond.loafer.api.domain.emun.MessageStatus;
import com.roysmond.loafer.api.domain.emun.MessageType;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Stack
 * 1. https://stackoverflow.com/questions/25094410/hibernate-error-while-persisting-text-datatype?noredirect=1#comment39048566_25094410
 *
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "message")
public class Message extends AbstractTimeModel {

    @Column(name = "title", length = 120)
    private String title;

    @NotNull
    @Size(max = 65535)
    @Column(name = "content", length = 65535)
    @Type(type = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User toUser;

    @ManyToOne
    @JoinColumn(name = "by_user_id")
    private User byUser;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private MessageStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private MessageType type;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] params;
}
