package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hand.infra.mapper")
@EnableCaching
@EnableTransactionManagement
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestSpringBoot1Application {
    public static void main(String[] args) {
        SpringApplication.run(TestSpringBoot1Application.class, args);
    }
}
