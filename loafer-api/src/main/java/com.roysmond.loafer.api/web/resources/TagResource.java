package com.roysmond.loafer.api.web.resources;

import com.roysmond.loafer.api.service.TagService;
import com.roysmond.loafer.api.web.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@RestController
@RequestMapping("tags")
public class TagResource {

    @Autowired
    private TagService tagService;

    @GetMapping("/{postId}")
    public Result getTagsByPostId(@PathVariable Long postId) {
        return new Result(tagService.findTagsByPostId(postId));
    }
}
