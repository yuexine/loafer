package com.roysmond.loafer.api.web.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wuyuexin on 2017/6/23.
 */
@Data
public class TagDTO implements Serializable {

    private Long id;

    private String name;
}
