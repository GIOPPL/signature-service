package com.ppl.signature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//nohup java -jar signature-service-1.0.0.jar >xxx.log 2>&1 &
public class Signature2Application {
    public static void main(String[] args) {
        SpringApplication.run(Signature2Application.class, args);
    }
}
