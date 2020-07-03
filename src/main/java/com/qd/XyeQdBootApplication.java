package com.qd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.qd.dao")
@ServletComponentScan
public class XyeQdBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyeQdBootApplication.class, args);
    }

}
