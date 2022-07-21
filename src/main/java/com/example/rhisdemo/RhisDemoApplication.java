package com.example.rhisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy
public class RhisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RhisDemoApplication.class, args);
    }

}
