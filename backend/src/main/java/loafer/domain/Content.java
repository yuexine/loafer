package loafer.domain;

import loafer.domain.emun.ContentStatus;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A Content
 * <p>
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "content")
public class Content extends AbstractTimeModel {

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @NotNull
    @Size(max = 1048576)
    @Column(name = "content", length = 1048576, nullable = false)
    private String content;

    @Size(max = 65535)
    @Column(name = "summary", length = 65535)
    @Type(type = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 60)
    private ContentStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
