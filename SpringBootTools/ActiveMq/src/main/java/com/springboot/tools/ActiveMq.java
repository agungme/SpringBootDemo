package com.springboot.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

#@ComponentScan("com.springboot.tools")
@SpringBootApplication
public class ActiveMq {
    public static void main(String args[]){
        SpringApplication.run(ActiveMq.class);

    }
}
