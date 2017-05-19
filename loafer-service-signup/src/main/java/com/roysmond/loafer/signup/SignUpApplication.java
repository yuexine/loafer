package com.roysmond.loafer.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by wuyuexin on 2017/5/18.
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SignUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SignUpApplication.class, args);
    }
}
