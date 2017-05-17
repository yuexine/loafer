package loafer.service;

import loafer.domain.User;
import loafer.web.models.UserVM;

/**
 * Created by wuyuexin on 2017/5/17.
 */
public interface UserService {

    User createUser(UserVM userVM);
}
