package com.roysmond.loafer.api.property;

import com.roysmond.loafer.api.domain.Tag;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

/**
 * Created by wuyuexin on 2017/6/23.
 */
public interface PostProperty {

    Long getId();

    String getTitle();

    String getSummary();

    String getContent();

    int getHits();

    int getVoteUp();

    Set getTags();
}
