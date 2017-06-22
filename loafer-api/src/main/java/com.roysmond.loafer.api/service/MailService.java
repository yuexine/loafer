package com.roysmond.loafer.api.service;

import com.roysmond.loafer.api.domain.User;

/**
 * Created by wuyuexin on 2017/5/17.
 */
public interface MailService {

    void sendActivationEmail(User user);
}
