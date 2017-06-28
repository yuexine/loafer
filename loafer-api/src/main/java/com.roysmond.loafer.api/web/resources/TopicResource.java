package com.roysmond.loafer.api.web.resources;

import com.roysmond.loafer.api.service.TopicService;
import com.roysmond.loafer.api.web.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@RestController
@RequestMapping("api")
public class TopicResource {

    @Autowired
    private TopicService topicService;

    @GetMapping("topic/active")
    public Result findHotTopics() {
        return new Result(topicService.getHotTopics());
    }
}
