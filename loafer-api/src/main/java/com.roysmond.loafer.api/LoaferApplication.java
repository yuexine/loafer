package com.roysmond.loafer.api;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by w on 2017/4/24.
 */
@EnableCaching
@SpringBootApplication
public class LoaferApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");

        new SpringApplicationBuilder()
                .sources(LoaferApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);

    }
}
