package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.property.TopicProperty;

import java.util.List;

/**
 * Created by wuyuexin on 2017/6/23.
 */
public interface TopicService {

    List<TopicProperty> getHotTopics();
}
