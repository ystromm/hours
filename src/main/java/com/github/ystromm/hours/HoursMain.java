package com.github.ystromm.hours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * The main class for hours.
 * Created by mac on 2015-12-21.
 */
@EnableAutoConfiguration
public class HoursMain {
    public static void main(String[] args) {
        SpringApplication.run(HoursMain.class, args);
    }
}
