package loafer.service;

import loafer.domain.User;

/**
 * Created by wuyuexin on 2017/5/17.
 */
public interface MailService {

    void sendActivationEmail(User user);
}
