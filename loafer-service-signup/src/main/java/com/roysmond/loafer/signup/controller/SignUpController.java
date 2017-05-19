package com.roysmond.loafer.signup.controller;

import com.roysmond.loafer.signup.provider.MailProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuyuexin on 2017/5/18.
 */
@RestController
public class SignUpController {

    private final MailProvider mailProvider;

    public SignUpController(MailProvider mailProvider) {
        this.mailProvider = mailProvider;
    }

    @GetMapping("feign/{mailTo}")
    public String mailTo(@PathVariable String mailTo){
        return mailProvider.sendMail(mailTo);
    }
}
