package org.castiello.nogle.match.aspect.jpa;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class JpaAspect {
	// 設定切入點
	@Pointcut("execution(* org.castiello.nogle.match.repos..*.save(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		log.info("@Before {}", joinPoint.getSignature().getName());
		Arrays.stream(joinPoint.getArgs()).forEach(log::info);
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		log.info("@Around {}, Time spent: {}", joinPoint.getSignature().getName(), System.currentTimeMillis() - startTime);
		return result;
	}

	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		log.info("@After {}", joinPoint.getSignature().getName());
		Arrays.stream(joinPoint.getArgs()).forEach(log::info);
	}
}
