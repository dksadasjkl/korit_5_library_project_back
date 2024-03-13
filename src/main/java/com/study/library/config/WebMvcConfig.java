package com.study.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링의 설정 클래스임을 나타냅니다.
public class WebMvcConfig implements WebMvcConfigurer { // WebMvc Configurer 인터페이스를 구현하여 웹 MVC 구성을 설정합니다.

    @Override
    public void addCorsMappings(CorsRegistry registry) { // CORS(Cross-Origin Resource Sharing) 설정을 추가합니다.
        registry.addMapping("/**") // 모든 경로에 대해서 CORS 설정을 적용합니다.
                .allowedMethods("*") // 모든 HTTP 메서드를 허용합니다.
                .allowedOrigins("*"); // 모든 오리진(Origin)을 허용합니다.
    }
}