package com.xworkz.instuite.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    
    public LoggingAspect() {
        System.out.println("LoggingAspect initialized");
    }

   
    @Before("execution(* com.xworkz.instuite.instuite.service..*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    
    @After("execution(* com.xworkz.instuite.instuite.service..*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
        
        
//      =======================================================================================
        
        
    }
}
