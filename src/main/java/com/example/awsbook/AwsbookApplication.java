package com.example.awsbook;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwsbookApplication {

    public static void main(String[] args) {


        SpringApplication application = new SpringApplication(AwsbookApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.setBannerMode(Banner.Mode.OFF);     // 배너 감추기
        application.run(args);
    }

}
