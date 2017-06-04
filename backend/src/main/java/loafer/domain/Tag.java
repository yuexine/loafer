package loafer.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
