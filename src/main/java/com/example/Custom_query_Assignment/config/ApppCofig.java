package com.example.Custom_query_Assignment.config;

import com.example.Custom_query_Assignment.utils.StudentUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApppCofig {
    @Bean
    public StudentUtils studentUtils(){
        return new StudentUtils();
    }
}
