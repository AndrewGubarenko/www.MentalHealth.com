package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component("userService")
public class UserService {
	
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;

	public User create(User user) {
		return transactionUtils.performInsideTransaction(entityManager -> {

			User result = new User();
			result.setId(user.getId());
			result.setLogin(user.getLogin());
			
			entityManager.persist(user);
			
			return result;
		});
	}

	public User findUserByLoginAndPassword(String login, String password) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			List<User> users = entityManager
					.createQuery("SELECT user FROM User user WHERE user.login = :login AND user.password = :password", User.class)
					.setParameter("login", login)
					.setParameter("password", password).getResultList();
			return users.size() == 1 ? users.get(0) : null;
		});
			
	}
	
	//TODO: implement correct return statement
	public String remove(Long userId) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			validationForRemove(entityManager, userId);
			authorizationForRemove(entityManager, userId);
			
			User user = entityManager.find(User.class, userId);
			entityManager.remove(user.getUserProfile());
			entityManager.remove(user);
			
			String result = "Your profile was completely removed";
			return result;
		});
	}
	
	// TODO: implement this
	private void validationForRemove(EntityManager entityManager, Long userId) {

	}

	// TODO: implement this
	private void authorizationForRemove(EntityManager entityManager, Long userId) {

	}
}
