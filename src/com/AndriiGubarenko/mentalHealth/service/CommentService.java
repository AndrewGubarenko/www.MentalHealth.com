package com.AndriiGubarenko.mentalHealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.Comment;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.CommentCrud;
import com.AndriiGubarenko.mentalHealth.repositories.UserProfileCrud;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component("commentService")
public class CommentService implements ICommentService {
	@Autowired
	private CommentCrud commentCrud;
	
	@Autowired
	private UserProfileCrud userProfileCrud;
	
	@Override
	@Transactional
	public PlainComment create(Long userProfileId, PlainComment plainComment) {
		Comment comment = new Comment();
		
		comment.setVisitorName(plainComment.getVisitorName());
		comment.setCommentText(plainComment.getCommentText());
		comment.setRating(plainComment.getRating());
		
		
		UserProfile userProfile = userProfileCrud.findById(userProfileId).get();
		comment.setUserProfile(userProfile);
		
		commentCrud.save(comment);
		
		PlainComment result = Converter.toPlainComment(comment);
		
		return result;
	}
}
