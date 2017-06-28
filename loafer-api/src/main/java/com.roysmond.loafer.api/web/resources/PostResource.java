package com.roysmond.loafer.api.web.resources;

import com.roysmond.loafer.api.service.PostService;
import com.roysmond.loafer.api.web.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wuyuexin on 2017/6/22.
 */
@RestController
@RequestMapping("api")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("posts")
    public Result getPostByPage() {
        return new Result();
    }

    @GetMapping("post/{id}")
    public Result getPostById(@PathVariable Long id) {

        return new Result(postService.findPostById(id));
    }

    @GetMapping("post/summary/{type}")
    public Result getPostSummaries(@PathVariable String type,
                                   @RequestParam(name = "topic", required = false) String topic,
                                   @RequestParam int page,
                                   @RequestParam int size) {
        Page resource = postService.findPostsSummaryByTopicNameAndType(topic, type, page, size);
        return new Result(resource);
    }
}
