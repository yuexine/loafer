package com.roysmond.loafer.api.repository;

import com.roysmond.loafer.api.domain.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void findTopicByWeightAfter() throws Exception {
        List topics = topicRepository.findTopicByWeightAfter(0, new Sort("weight"));
        System.out.println(topics.size());
    }

}