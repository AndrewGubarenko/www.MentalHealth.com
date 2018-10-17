package com.AndriiGubarenko.mentalHealth.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.AndriiGubarenko.mentalHealth.rest.aspect.Authenticational;
import com.AndriiGubarenko.mentalHealth.service.ICommentService;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;

@RestController
public class CommentRest {
	@Autowired
	private ICommentService commentService;
	
	private Long userId;
	
	@RequestMapping(path = "/UserViewPage/{id}", method = RequestMethod.POST)
	public ResponseEntity<PlainComment> create(HttpServletRequest request, 
			@RequestBody PlainComment plainComment, 
			@PathVariable Long id) {
		PlainComment result = commentService.create(id, plainComment);
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
	
//	@RequestMapping(path = "/UserViewPage/{id}", method = RequestMethod.GET)
//	public ResponseEntity<List<PlainComment>> getList(HttpServletRequest request, 
//			@PathVariable Long id) {
//		List<PlainComment> result = commentService.getList(id);
//		return new ResponseEntity<>(result, HttpStatus.OK);	
//	}
	
	@RequestMapping(path = "/UserViewPage/{userProfileId}", method = RequestMethod.DELETE)
	@Authenticational
	public ResponseEntity<PlainComment> remove(HttpServletRequest request, @PathVariable Long userProfileId) {
		Long commentId = Long.valueOf(request.getHeader("commentId"));
		PlainComment result = commentService.remove(userId, userProfileId, commentId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}