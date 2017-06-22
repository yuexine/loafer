package com.roysmond.loafer.api;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by w on 2017/4/24.
 */
@SpringBootApplication
public class LoaferApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");

        new SpringApplicationBuilder()
                .sources(LoaferApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);

    }
}
