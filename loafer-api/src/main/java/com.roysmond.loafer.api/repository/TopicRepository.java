package com.roysmond.loafer.api.repository;

import com.roysmond.loafer.api.domain.Topic;
import com.roysmond.loafer.api.property.TopicProperty;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>, Serializable {

    List<TopicProperty> findTopicByWeightAfter(int weight, Sort sort);
}
