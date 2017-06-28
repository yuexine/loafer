package com.roysmond.loafer.api.property;

import com.roysmond.loafer.api.domain.Tag;
import lombok.Data;

import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Data
public class PostPropertyImpl implements PostProperty {

    private Long id;

    private String title;

    private String summary;

    private String content;

    private int hits;

    private int voteUp;

    private Set<TagPropertyImpl> tags;
}
