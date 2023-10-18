package com.example.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {
//    public SecurityFilterChain security(HttpSecurity http) throws Exception{
//          //DEPRECATED!
////        return http
////                .authorizeRequests() //인증, 인가 설정을 시작함.
////                .requestMatchers("/login", "/signup", "/user", "/user-service/health-check").permitAll() //해당 주소는 인증, 인가
////                .anyRequest().authenticated() //나머지는 인증을 요구함.
////                .and()
////                .csrf().disable().build();
//
//        //스프링 6 이후 람다식
//        return http
//                // 변수명이 너무 길어 가독성이 해치지 않는 쪽에서 줄여도 된다. ex) a -> a 도 가능하나 가독성을 해친다.
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry
//                        .requestMatchers("/**").permitAll()
//                        .anyRequest().hasRole("ADMIN"))
//                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer
//                        .disable())
//                .build();
//    }

    //암호화 비밀번호 저장을 위한 BCryptEncoder 빈 생성
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
