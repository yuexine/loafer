package com.roysmond.loafer.api.web.models;

import com.roysmond.loafer.api.domain.Tag;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/22.
 */
@Data
public class PostDTO implements Serializable {

    private Long id;

    private String author;

    private String summary;

    private String title;

    private String content;

    private Set<TagDTO> tags;

}
