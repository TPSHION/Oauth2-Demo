package com.tpshion.oauth2.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tpshion.oauth2.demo.mapper")
public class Oauth2Demo {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Demo.class,args);
    }
}
