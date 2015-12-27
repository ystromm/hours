package com.github.ystromm.hours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * The main class for hours.
 * Created by mac on 2015-12-21.
 */
@EnableOAuth2Client
@SpringBootApplication
public class HoursMain {

    public static void main(String[] args) {
        SpringApplication.run(HoursMain.class, args);
    }
}
