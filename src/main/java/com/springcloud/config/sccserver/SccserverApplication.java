package com.springcloud.config.sccserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SccserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SccserverApplication.class, args);
    }

}
