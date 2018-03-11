package com.AndriiGubarenko.mentalHealth.service.aspects;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component
@Aspect
public class TransactionalAspect {
	
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;
	
	@Pointcut("execution(@com.AndriiGubarenko.mentalHealth.service.annotation.Transactional * *(..))")
	public void annotatedByTransactional() {}
	
	@Around("annotatedByTransactional()")
	public Object around(ProceedingJoinPoint joinPoint) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			Object target = joinPoint.getTarget();
			try {
				Field entityManagerField = target.getClass().getDeclaredField("entityManager");
				
				entityManagerField.setAccessible(true);
				entityManagerField.set(target, entityManager);
				
				Object result = joinPoint.proceed();
				
				entityManagerField.set(target, null);
				entityManagerField.setAccessible(false);
				
				return result;
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		});
	}
}
