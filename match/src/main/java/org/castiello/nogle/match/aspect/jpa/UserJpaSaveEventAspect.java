package org.castiello.nogle.match.aspect.jpa;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.castiello.nogle.match.po.User;
import org.castiello.nogle.match.subscriber.AbstractEventMgmtService;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class UserJpaSaveEventAspect extends AbstractEventMgmtService<User> {

	private ExecutorService executorService = Executors.newFixedThreadPool(2);

	@Override
	protected ExecutorService getTaskExecutor() {
		return executorService;
	}

	@PostConstruct
	private void init() {
		log.info("UserJpaSaveEventAspect init");
		singleThread("UserJpaSaveEventAspectTask");
	}

	@AfterReturning(pointcut = "execution(public !void org.castiello.nogle.match.repos.UserRepository.save(..))", returning = "returnValue")
	private void savePoEvent(final JoinPoint joinPoint, final Object returnValue) {
		if (returnValue instanceof User)
			asyncQueue.add((User) returnValue);
	}

//	@AfterReturning(pointcut = "execution(public !void org.castiello.nogle.match.repos.UserRepository.delete.*(..))", returning = "returnValue")
//	private void deletePoEvent(final JoinPoint joinPoint, final Object returnValue) {
//		if (returnValue instanceof User)
//			asyncQueue.add((User) returnValue);
//	}
}
