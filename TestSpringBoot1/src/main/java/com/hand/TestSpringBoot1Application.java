package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hand.infra.mapper")
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestSpringBoot1Application {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBoot1Application.class, args);
    }
}
