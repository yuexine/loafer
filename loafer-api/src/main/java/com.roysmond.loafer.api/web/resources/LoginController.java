package com.roysmond.loafer.api.web.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by w on 2017/4/24.
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/hello")
    public String say(){
        return "Hello, World";
    }

    @GetMapping("/api/hello")
    public String loginSay(){
        return "Hello, World";
    }

}
