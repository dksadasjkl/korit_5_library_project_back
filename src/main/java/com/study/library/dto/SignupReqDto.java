package com.study.library.dto;

import com.study.library.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// 정규표현식 주소
// https://adjh54.tistory.com/104#1.%20%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D%20%ED%8C%A8%ED%84%B4(Regular%20Expression%20Pattern)-1
// 어노테이션 주소
// https://hyeran-story.tistory.com/81

@Data
public class SignupReqDto {
    @Pattern(regexp = "^[a-z]{1}[a-z0-9]{2,10}+$", message = "영문 숫자 조합 6~10자리여야 합니다")
    private String username;
    @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{7,128}+$", message = "대소문자, 숫자, 특수문자 조합으로 8 ~ 128자리여야 합니다")
    private String password;
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣]{1,}$", message = "한글이여야 합니다")
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9]+@[0-9a-zA-Z]+\\.[a-z]+$", message = "이메일 형식")
    private String email;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .build();
    }
}
