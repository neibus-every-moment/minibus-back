package com.minibus.moment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication
public class MinibusBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibusBackApplication.class, args);

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "https://minibus.netlify.app")
                        .allowedMethods(
                                HttpMethod.GET.name(),
                                HttpMethod.PATCH.name(),
                                HttpMethod.HEAD.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name()
                        )
                        .allowCredentials(true)
                        .allowedHeaders("*")
                ;
            }
        };
    }
}
