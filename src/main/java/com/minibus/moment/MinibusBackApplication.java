package com.minibus.moment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinibusBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinibusBackApplication.class, args);
    }

}
