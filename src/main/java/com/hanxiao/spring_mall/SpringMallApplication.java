package com.hanxiao.spring_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hanxiao.spring_mall.mapper")
@SpringBootApplication
public class SpringMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMallApplication.class, args);
    }

}
