package com.AndriiGubarenko.mentalHealth.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.service.IUserListRepresentationService;

@RestController
public class UserListRepresentationRest {
	
	@Autowired
	private IUserListRepresentationService userListRepresentationService;
	
	@RequestMapping(path = "/UserListRepresentation", method = RequestMethod.GET)
	public ResponseEntity<List<List<Object>>> getFullList(HttpServletRequest request) {
		List<List<Object>> result = userListRepresentationService.getFullUserProfileList();
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<List<Object>>> getShortList(HttpServletRequest request) {
		List<List<Object>> result = userListRepresentationService.getShortUserProfileList();
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
}
