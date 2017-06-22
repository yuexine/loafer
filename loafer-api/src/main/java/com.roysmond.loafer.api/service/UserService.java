package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.domain.User;
import com.roysmond.loafer.api.web.models.VMUser;

/**
 * Created by wuyuexin on 2017/5/17.
 */
public interface UserService {

    User createUser(VMUser userVM);
}
