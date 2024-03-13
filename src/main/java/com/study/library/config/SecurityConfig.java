package com.study.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 기본 세팅 x , 재설정한 세팅으로
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // CSRF(Cross-Site Request Forgery) 토큰 방식 설정을 비활성화합니다.
        http.authorizeRequests() // HttpSecurity 객체를 통해 요청에 대한 인가 설정을 구성합니다.
                .antMatchers("/server/**", "/auth/**") // "/server/**" 패턴의 URL 에 대한 요청은
                .permitAll() // 모든 사용자에게 허용됩니다.
                .anyRequest() // 다른 모든 요청에 대해서는
                .authenticated(); // 인증된 사용자만 접근할 수 있도록 설정합니다.
    }
}
