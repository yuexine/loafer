package loafer.service;

import loafer.domain.User;
import loafer.web.models.VMUser;

/**
 * Created by wuyuexin on 2017/5/17.
 */
public interface UserService {

    User createUser(VMUser userVM);
}
