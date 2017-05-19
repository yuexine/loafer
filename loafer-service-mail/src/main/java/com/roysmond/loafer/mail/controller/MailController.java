package com.roysmond.loafer.mail.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuyuexin on 2017/5/18.
 */
@RestController
public class MailController {

    private final DiscoveryClient discoveryClient;

    public MailController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String mailTo){
        return "Mail to " + mailTo;
    }

    /**
     * 本地服务实例的信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
