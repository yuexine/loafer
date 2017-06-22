package com.roysmond.loafer.api.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by w on 2017/5/2.
 */
public class UserNotActivatedException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActivatedException(String msg) {
        super(msg);
    }
}
