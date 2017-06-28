package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.property.TopicProperty;
import com.roysmond.loafer.api.property.TopicPropertyImpl;
import com.roysmond.loafer.api.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    @Cacheable(cacheNames = "hotTopic")
    public List<TopicProperty> getHotTopics() {
        //Spring Cache can not cache an interface bean as result
        return topicRepository.findTopicByWeightAfter(0, new Sort("weight")).stream()
                .map(tp -> new TopicPropertyImpl(tp))
                .collect(Collectors.toList());
    }
}
