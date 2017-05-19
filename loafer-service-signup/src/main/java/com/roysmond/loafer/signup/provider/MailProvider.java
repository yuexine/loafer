package com.roysmond.loafer.signup.provider;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wuyuexin on 2017/5/18.
 */
@FeignClient(name = "service-provider-mail")
public interface MailProvider {

    @RequestMapping("/sendMail")
    String sendMail(@RequestParam("mailTo") String mailTo);
}
