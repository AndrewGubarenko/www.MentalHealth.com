package com.AndriiGubarenko.mentalHealth.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.rest.utils.AuthenticationUtils;
import com.AndriiGubarenko.mentalHealth.service.IUserProfileService;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;

@RestController
public class UserProfileRest {
	@Resource(name = "userProfileService")
	private IUserProfileService userProfileService;
	
	@Resource(name = "authenticationUtils")
	private AuthenticationUtils authenticationUtils;

	@RequestMapping(path = "/userProfile", method = RequestMethod.POST)
	public ResponseEntity<PlainUserProfile> create(HttpServletRequest request, @RequestBody PlainUserProfile plainUserProfile) {
		
		return authenticationUtils.performAfterAuthentication(request, userId -> {
			
			PlainUserProfile result = userProfileService.create(userId, plainUserProfile);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		}); 		
	}
	
	@RequestMapping(path = "/userProfile/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlainUserProfile> get(HttpServletRequest request, @PathVariable Long id) {
		return authenticationUtils.performAfterAuthentication(request, userId -> {
			
			PlainUserProfile result = userProfileService.get(userId, id);
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		});
	}
	
	@RequestMapping(path = "/userProfile", method = RequestMethod.PUT)
	public ResponseEntity<PlainUserProfile> update(HttpServletRequest request, @RequestBody PlainUserProfile plainUserProfile) {
		return authenticationUtils.performAfterAuthentication(request, userId -> {
			PlainUserProfile result = userProfileService.update(userId, plainUserProfile);
			return new ResponseEntity<>(result, HttpStatus.OK);
		});
	}
}
