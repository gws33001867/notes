package com.lance.learningnotes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.lance.learningnotes",exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.lance.learningnotes.mapper")
@EnableSwagger2
@EnableTransactionManagement(proxyTargetClass = true)
public class LearningNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningNotesApplication.class, args);
    }

}
