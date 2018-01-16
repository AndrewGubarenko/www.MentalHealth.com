package com.AndriiGubarenko.mentalHealth.rest;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.rest.utils.AuthenticationUtils;
import com.AndriiGubarenko.mentalHealth.security.TokenManager;
import com.AndriiGubarenko.mentalHealth.security.TokenPayload;
import com.AndriiGubarenko.mentalHealth.service.UserService;


@RestController
public class UserRest {
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "authenticationUtils")
	private AuthenticationUtils authenticationUtils;
	
	@Resource(name = "tokenManager")
	private TokenManager tokenManager;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		try {
			User createdUser = userService.create(user);
			return new ResponseEntity<>(createdUser, HttpStatus.OK);
		} catch (RollbackException ex) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	}
	@RequestMapping(path = "/authentication", method = RequestMethod.POST)
	public ResponseEntity<String> authentication(@RequestBody User user) {
		User authenticationUser = userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
		if(authenticationUser == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		String token = createToken(authenticationUser);
		return new ResponseEntity<>(token, HttpStatus.OK);
		
	}
	
	private String createToken(User user) {
		Date createdTime = Calendar.getInstance().getTime();
		TokenPayload payload = new TokenPayload(user.getId(), user.getLogin(), createdTime);
		String token = tokenManager.createToken(payload);
		return token;
	}
	

	//TODO: verify this
	@RequestMapping(path = "/userProfile/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> remove(HttpServletRequest request, @PathVariable Long id) {
		return authenticationUtils.performAfterAuthentication(request, userId -> {
			User result = userService.remove(userId);
			return new ResponseEntity<>(result, HttpStatus.OK);
		});
	}
}
