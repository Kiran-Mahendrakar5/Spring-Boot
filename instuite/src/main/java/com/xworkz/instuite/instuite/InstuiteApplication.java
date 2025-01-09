package com.xworkz.instuite.instuite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication(scanBasePackages = "com.xworkz.instuite")
@EnableAspectJAutoProxy
public class InstuiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(InstuiteApplication.class, args);
    }
}
