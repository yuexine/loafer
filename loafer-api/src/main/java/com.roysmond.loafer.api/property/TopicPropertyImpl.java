package com.roysmond.loafer.api.property;

import lombok.Data;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Data
public class TopicPropertyImpl implements TopicProperty {

    private Long id;

    private String name;

    private String description;

    private String image;

    public TopicPropertyImpl(TopicProperty tp) {
        this.id = tp.getId();
        this.description = tp.getDescription();
        this.name = tp.getName();
        this.image = tp.getImage();
    }

    public TopicPropertyImpl() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicPropertyImpl)) return false;
        if (!super.equals(o)) return false;

        TopicPropertyImpl that = (TopicPropertyImpl) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
