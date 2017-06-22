package loafer.domain;

import loafer.domain.emun.VoteType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A vote
 *
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Table(name = "vote")
@Entity
public class Vote extends AbstractTimeModel implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type")
    private VoteType type;

}
