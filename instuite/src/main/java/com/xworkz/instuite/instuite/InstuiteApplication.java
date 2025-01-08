package com.xworkz.instuite.instuite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication\
@SpringBootApplication(scanBasePackages = "com.xworkz.instuite")
@EnableAspectJAutoProxy(proxyTargetClass = false)  // Enable proxy-based AOP
public class InstuiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(InstuiteApplication.class, args);
    }
}
