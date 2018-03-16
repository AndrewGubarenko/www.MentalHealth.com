package com.AndriiGubarenko.mentalHealth.service;

import com.AndriiGubarenko.mentalHealth.domain.User;

public interface IUserService {

	User create(User user);

	User findUserByLoginAndPassword(String login, String password);

	String remove(Long userId);

}