package com.AndriiGubarenko.mentalHealth.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.domain.User;

@RestController
public class UserRest {
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
