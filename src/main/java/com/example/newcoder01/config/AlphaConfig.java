package com.example.newcoder01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat getSimpleDate(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }
}
