package com.roysmond.loafer.api.property;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wuyuexin on 2017/6/23.
 */
public interface TagProperty {

    Long getId();

    String getName();

    String getInfo();

    Long getPostCount();

    Long getFollowersCount();
}
