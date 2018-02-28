package com.AndriiGubarenko.mentalHealth.service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.domain.Comment;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;
import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component("commentService")
public class CommentService {
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;
	
	public PlainComment create(Long userProfileId, PlainComment plainComment) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			Comment comment = create(entityManager, userProfileId, plainComment);
			PlainComment result = Converter.toPlainComment(comment);
			return result;
		});
	}
	
	private Comment create(EntityManager entityManager, Long userProfileId, PlainComment plainComment) {
		Comment comment = new Comment();
		
		comment.setVisitorName(plainComment.getVisitorName());
		comment.setCommentText(plainComment.getCommentText());
		comment.setRating(plainComment.getRating());
		
		
		UserProfile userProfile = entityManager.find(UserProfile.class, userProfileId);
		comment.setUserProfile(userProfile);
		
		entityManager.persist(comment);

		return comment;
	}
}
