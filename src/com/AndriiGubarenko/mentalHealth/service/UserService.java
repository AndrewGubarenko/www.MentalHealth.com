package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.User;

@Component("userService")
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public User create(User user) {
		User result = new User();
		result.setId(user.getId());
		result.setLogin(user.getLogin());
		
		entityManager.persist(user);
		
		return result;
	}
	
	@Transactional
	public User findUserByLoginAndPassword(String login, String password) {
		List<User> users = entityManager
				.createQuery("SELECT user FROM User user WHERE user.login = :login AND user.password = :password", User.class)
				.setParameter("login", login)
				.setParameter("password", password).getResultList();
		return users.size() == 1 ? users.get(0) : null;
	}
	
	//TODO: implement correct return statement 
	@Transactional
	public String remove(Long userId) {
		validationForRemove(entityManager, userId);
		authorizationForRemove(entityManager, userId);
		
		User user = entityManager.find(User.class, userId);
		user.getUserProfile().removeAllComments();
		entityManager.remove(user.getUserProfile());
		entityManager.remove(user);
		
		String result = "Your profile was completely removed";
		return result;
	}
	
	// TODO: implement method
	private void validationForRemove(EntityManager entityManager, Long userId) {

	}

	// TODO: implement method
	private void authorizationForRemove(EntityManager entityManager, Long userId) {

	}
}
