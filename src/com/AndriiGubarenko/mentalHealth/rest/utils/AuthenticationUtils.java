package com.AndriiGubarenko.mentalHealth.rest.utils;

import java.util.function.Function;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.security.TokenManager;
import com.AndriiGubarenko.mentalHealth.security.TokenPayload;

@Component("authenticationUtils")
public class AuthenticationUtils {
	
	@Resource(name = "tokenManager")
	private TokenManager tokenManager;
	
	public <R> ResponseEntity<R> performAfterAuthentication(HttpServletRequest request, Function<Long, ResponseEntity<R>> function) {

		String token = request.getHeader("token");

		if (!tokenManager.verifyToken(token)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		TokenPayload tokenPayload = tokenManager.extractPayload(token);

		return function.apply(tokenPayload.getUserId());
	}
}
