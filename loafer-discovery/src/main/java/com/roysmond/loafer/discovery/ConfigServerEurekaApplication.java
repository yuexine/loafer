package com.roysmond.loafer.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wuyuexin on 2017/5/17.
 */
@SpringBootApplication
//@EnableConfigServer
@EnableEurekaServer
@EnableDiscoveryClient
public class ConfigServerEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerEurekaApplication.class, args);
    }
}
