package com.itrecruitmentapi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class generateEncodePassword {

    public static void main(String[] args) {
        String pass = "Employer@123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode(pass));
    }
}
