package com.roysmond.loafer.api.property;

import lombok.Data;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Data
public class TagPropertyImpl implements TagProperty {

    private Long id;

    private String name;

    private String info;

    private Long postCount;

    private Long followersCount;
}
