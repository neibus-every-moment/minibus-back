package com.minibus.moment;


import com.minibus.moment.auth.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MinibusBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibusBackApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods(
//                                HttpMethod.GET.name(),
//                                HttpMethod.PATCH.name(),
//                                HttpMethod.HEAD.name(),
//                                HttpMethod.PUT.name(),
//                                HttpMethod.POST.name(),
//                                HttpMethod.DELETE.name()
//                        );
//            }
//        };
//    }
}
