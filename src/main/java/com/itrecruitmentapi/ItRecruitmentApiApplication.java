package com.itrecruitmentapi;

import com.itrecruitmentapi.service.ImageStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties
@RequiredArgsConstructor
public class ItRecruitmentApiApplication implements CommandLineRunner {

    private final ImageStorageService imageStorageService;

    public static void main(String[] args) {
        SpringApplication.run(ItRecruitmentApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        imageStorageService.deleteAll();
        this.imageStorageService.init();
    }
}
