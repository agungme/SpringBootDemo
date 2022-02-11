package com.springboot.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ToolsApp {
    public static void main(String args[]){
        SpringApplication.run(ToolsApp.class);

        log.info("test info logger");
    }
}
