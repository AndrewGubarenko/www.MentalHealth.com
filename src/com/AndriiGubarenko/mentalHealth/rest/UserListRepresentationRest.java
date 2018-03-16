/*package com.AndriiGubarenko.mentalHealth.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.service.IUserListRepresentationService;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserListRepresentation;

@RestController
public class UserListRepresentationRest {
	@Autowired
	private IUserListRepresentationService service;
	
	private String name;
	
	@RequestMapping(path = "userListRepresentation", method = RequestMethod.GET)
	public ResponseEntity<List<PlainUserListRepresentation>> getList(HttpServletRequest request) {
		List<PlainUserListRepresentation> result = service.getList(name);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}*/
