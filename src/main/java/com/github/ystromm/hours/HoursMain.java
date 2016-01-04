package com.github.ystromm.hours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.security.oauth2.client.DefaultOAuth2RequestAuthenticator;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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

    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    static class WorkaroundRestTemplateCustomizer implements UserInfoRestTemplateCustomizer {

        public void customize(OAuth2RestTemplate template) {
            template.setInterceptors(new ArrayList<>(template.getInterceptors()));
        }
    }

    @Component
    static class GoogleOAuth2RestTemplate implements UserInfoRestTemplateCustomizer {

        @Override
        public void customize(OAuth2RestTemplate template) {
            template.setAuthenticator(new DefaultOAuth2RequestAuthenticator() {
                @Override
                public void authenticate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext clientContext, ClientHttpRequest request) {
                    final OAuth2AccessToken accessToken = clientContext.getAccessToken();
                    request.getHeaders().set("Authorization", String.format("%s %s", OAuth2AccessToken.BEARER_TYPE, accessToken.getValue()));
                }
            });
        }
    }
}
