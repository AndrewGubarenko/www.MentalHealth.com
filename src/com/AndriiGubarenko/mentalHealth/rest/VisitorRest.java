package com.AndriiGubarenko.mentalHealth.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.service.IVisitorService;

@RestController
public class VisitorRest {
	@Autowired
	private IVisitorService visitorService;
	
	@RequestMapping(path = "/UserViewPage/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object[]> getFullProfile(HttpServletRequest request, 
			@PathVariable Long id) {
		Object[] result = visitorService.getFullProfile(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
