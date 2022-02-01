package com.minibus.moment.config.auth.config;

import com.minibus.moment.config.auth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //권한 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/my-page/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .formLogin()
                .loginPage("/oauth-login")
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/login-success",true)
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}
