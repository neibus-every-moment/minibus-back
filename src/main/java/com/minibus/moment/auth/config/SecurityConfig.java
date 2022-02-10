package com.minibus.moment.auth.config;

import com.minibus.moment.auth.security.CustomUserDetailsService;
import com.minibus.moment.auth.security.TokenAuthenticationFilter;
import com.minibus.moment.auth.security.oauth2.CustomOAuth2UserService;
import com.minibus.moment.auth.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.minibus.moment.auth.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.minibus.moment.auth.security.oauth2.OAuth2AuthenticationSuccessHandler;
import com.minibus.moment.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity           // Spring Security 활성화
@EnableGlobalMethodSecurity( // SecurityMethod 활성화
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // CORS 허용
                .cors()
                .and()
                // 토큰을 사용하기 위해 sessionCreationPolicy를 STATELESS로 설정 (Session 비활성화)
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // CSRF 비활성화
                    .csrf().disable()
                // 로그인폼 비활성화
                    .formLogin().disable()
                // 기본 로그인 창 비활성화
                    .httpBasic().disable()
                    .authorizeRequests()
//                .antMatchers("/css/**", "/images/**","/js/**","/h2-console").permitAll()
//                        .antMatchers("/", "/test").permitAll()
//                        .antMatchers("/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
//                        .antMatchers("/auth/**", "/oauth2/**").permitAll()
//                        .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                    .oauth2Login()
                        .authorizationEndpoint()
                // 클라이언트 처음 로그인 시도 URI
                        .baseUri("/oauth2/authorize")
                        .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                    .baseUri("/oauth2/callback/*")
                    .and()
                .userInfoEndpoint()
                    .userService(customOAuth2UserService)
                .and()
                    .successHandler(oAuth2AuthenticationSuccessHandler)
                    .failureHandler(oAuth2AuthenticationFailureHandler);

        http.addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
