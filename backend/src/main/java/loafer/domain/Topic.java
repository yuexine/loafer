package loafer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wuyuexin on 2017/6/3.
 */
@Data
@Entity
@Table(name = "topic")
public class Topic extends AbstractAuditingModel implements Serializable{

    private String name;

    private String description;
}
