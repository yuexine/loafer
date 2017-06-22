package com.roysmond.loafer.api.support;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by wuyuexin on 2017/5/24.
 */
@Data
public class UserInfo implements Serializable {

    private Long userId;

    private String username;

    private Long createTime;

    //...


    public UserInfo() {
    }

    public UserInfo(Long userId, String username) {
        this.userId = userId;
        this.username = username;
        this.createTime = Timestamp.valueOf(LocalDate.now().atStartOfDay()).getTime();
    }

    public UserInfo(Long userId, String username, LocalDate createDate) {
        this.userId = userId;
        this.username = username;
        this.createTime = Timestamp.valueOf(createDate.atStartOfDay()).getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        if (!super.equals(o)) return false;

        UserInfo userInfo = (UserInfo) o;

        return getUserId() != null ? getUserId().equals(userInfo.getUserId()) : userInfo.getUserId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        return result;
    }
}
