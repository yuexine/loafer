package com.roysmond.loafer.api.property;

import java.io.Serializable;

/**
 * define projections to serve up simplified and reduced views of resources
 * <p>
 * Created by wuyuexin on 2017/6/23.
 */
public interface TopicProperty extends Serializable {

    Long getId();

    /**
     * add @Value annotation will find all filed from db
     *
     * @return
     */
//    @Value("#{target.name}")
    String getName();

    String getDescription();

    String getImage();
}
