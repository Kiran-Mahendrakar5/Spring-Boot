package com.xworkz.instuite.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;

@Aspect   
@Component
public class LoggingAspect {

	public LoggingAspect() {
		System.out.println("LoggingAspect initialized");
	}
// catch () exc in spe cl
	@Before("execution(* com.xworkz.instuite.instuite.service..*(..))")
	public void logBeforeMethod(JoinPoint joinPoint) {
		System.out.println("Before method: " + joinPoint.getSignature().getName());
	}                                                        //pro info catch() 

	@After("execution(* com.xworkz.instuite.instuite.service..*(..))")
	public void logAfterMethod(JoinPoint joinPoint) {
		System.out.println("After method: " + joinPoint.getSignature().getName());
	}

	@Around("execution(* com.xworkz.instuite.instuite.service..*(..))")
	public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around advice: Before method execution: " + joinPoint.getSignature().getName());

		Object result = joinPoint.proceed();//used advice to continue exception

		System.out.println("Around advice: After method execution: " + joinPoint.getSignature().getName());

		return result;
	}
}



































//@AfterThrowing(pointcut = "execution(* com.xworkz.instuite.instuite.service..*(..))", throwing = "exception")
//public void logAfterThrowingException(JoinPoint joinPoint, Throwable exception) {
//	System.out.println("Exception in method: " + joinPoint.getSignature().getName());
//	System.out.println("Exception: " + exception.getMessage());
//}
