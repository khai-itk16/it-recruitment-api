package com.itrecruitmentapi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties
@RequiredArgsConstructor
public class ItRecruitmentApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItRecruitmentApiApplication.class, args);
    }
}
