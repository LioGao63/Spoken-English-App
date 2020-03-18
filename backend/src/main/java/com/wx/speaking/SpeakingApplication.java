package com.wx.speaking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wx.speaking.mapper")
@EnableCaching
public class SpeakingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeakingApplication.class, args);
    }

}
