package com.AndriiGubarenko.mentalHealth.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.service.CommentService;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;

@RestController
public class CommentRest {
	@Resource(name = "commentService")
	private CommentService commentService;
	
	@RequestMapping(path = "/userProfile/comment", method = RequestMethod.POST)
	public ResponseEntity<PlainComment> create(HttpServletRequest request, @RequestBody PlainComment plainComment) {
		Long userProfileId = plainComment.getUserProfileId();
		PlainComment result = commentService.create(userProfileId, plainComment);
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
}