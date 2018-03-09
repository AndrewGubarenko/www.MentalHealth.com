package com.AndriiGubarenko.mentalHealth.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.service.annotation.Transactional;
import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component("userProfileServiceProxy")
public class UserProfileServiceProxy {
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;
	
	public IUserProfileService createTransactionalProxy(IUserProfileService userProfileService) {
		return (IUserProfileService) Proxy.newProxyInstance(IUserProfileService.class.getClassLoader(), new Class<?>[] {
				IUserProfileService.class
		}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(needProxy(method)) {
					return proxyMethod(proxy, method, args);
				} else {
					return method.invoke(userProfileService, args);
				}
			}
			private boolean needProxy(Method method) {
				return Stream.of(method.getAnnotations()).filter(annotation -> {
					return annotation.getClass().equals(Transactional.class);
				}).findAny().isPresent();
			}
			
			private Object proxyMethod(Object proxy, Method method, Object[] args) {
				return transactionUtils.performInsideTransaction(entityManager -> {
					try {
						Field entityManagerField = userProfileService.getClass().getDeclaredField("entityManager");
						entityManagerField.setAccessible(true);
						entityManagerField.set(userProfileService, entityManager);
						
						Object result = method.invoke(userProfileService, args);
						
						entityManagerField.set(userProfileService, null);
						entityManagerField.setAccessible(false);
						
						return result;
					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | SecurityException e) {
						throw new RuntimeException(e);
					}
				});
			}
		});
	}
}
