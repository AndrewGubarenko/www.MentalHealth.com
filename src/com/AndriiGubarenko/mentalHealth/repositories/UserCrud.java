package com.AndriiGubarenko.mentalHealth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.User;

public interface UserCrud extends CrudRepository<User, Long> {
	List<User> findByLoginAndPassword(String login, String password);
}
