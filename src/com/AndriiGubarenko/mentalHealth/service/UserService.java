package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.repositories.UserCrud;

@Component("userService")
public class UserService implements IUserService {
	
	@Autowired
	private UserCrud crud;
	
	@Override
	@Transactional
	public User create(User user) {
		crud.save(user);
		
		User result = new User();
		result.setId(user.getId());
		result.setLogin(user.getLogin());
		
		return result;
	}
	

	@Override
	@Transactional
	public User findUserByLoginAndPassword(String login, String password) {
		List<User> users = crud.findByLoginAndPassword(login, password);		

		return users.size() == 1 ? users.get(0) : null;
	}
	
	//TODO: implement correct return statement 
	@Override
	@Transactional
	public String remove(Long userId) {
		validationForRemove(userId);
		authorizationForRemove(userId);
		
		crud.deleteById(userId);
		
		return "Your profile was completely removed";
	}
	
	// TODO: implement method
	private void validationForRemove(Long userId) {

	}

	// TODO: implement method
	private void authorizationForRemove(Long userId) {

	}
}
