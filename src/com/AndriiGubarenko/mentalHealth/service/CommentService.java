package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;
import java.util.stream.Collectors;

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
		setParent(comment, plainComment.getParentId());
		
		
		UserProfile userProfile = userProfileCrud.findById(userProfileId).get();
		comment.setUserProfile(userProfile);
		
		commentCrud.save(comment);
		
		PlainComment result = Converter.toPlainComment(comment);
		
		return result;
	}
	
	private void setParent(Comment target, Long parentId) {
		if (parentId == null) {
			target.removeParent();
		} else {
			target.setParent(commentCrud.findById(parentId).get());
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PlainComment> getList(Long userProfileId) {
		
		List<Comment> commentList = commentCrud.findByUserProfileId(userProfileId);
		return commentList.stream().map(Converter::toPlainComment).collect(Collectors.toList());
	}
}
