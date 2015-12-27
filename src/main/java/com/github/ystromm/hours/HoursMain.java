package com.github.ystromm.hours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The main class for hours.
 * Created by mac on 2015-12-21.
 */
@EnableOAuth2Sso
@SpringBootApplication
public class HoursMain extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll();
    }
    public static void main(String[] args) {
        SpringApplication.run(HoursMain.class, args);
    }
}
