package com.roysmond.loafer.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by wuyuexin on 2017/6/3.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTimeModel extends AbstractModel implements Serializable {


    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createTime;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateTime;

}
