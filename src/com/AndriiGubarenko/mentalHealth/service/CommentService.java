package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.Comment;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.CommentRepository;
import com.AndriiGubarenko.mentalHealth.repositories.UserProfileRepository;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component("commentService")
public class CommentService implements ICommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	@Transactional
	public PlainComment create(Long userProfileId, PlainComment plainComment) {
		Comment comment = new Comment();
		
		comment.setVisitorName(plainComment.getVisitorName());
		comment.setCommentText(plainComment.getCommentText());
		comment.setRating(plainComment.getRating());
		setParent(comment, plainComment.getParentId());
		
		
		UserProfile userProfile = userProfileRepository.findById(userProfileId).get();
		comment.setUserProfile(userProfile);
		
		commentRepository.save(comment);
		
		PlainComment result = Converter.toPlainComment(comment);
		
		return result;
	}
	
	private void setParent(Comment target, Long parentId) {
		if (parentId == null) {
			target.removeParent();
		} else {
			target.setParent(commentRepository.findById(parentId).get());
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PlainComment> getList(Long userProfileId) {
		
		List<Comment> commentList = commentRepository.findByUserProfileId(userProfileId);
		return commentList.stream().map(Converter::toPlainComment).collect(Collectors.toList());
	}
	
	//TODO: implement correct return statement 
		@Override
		@Transactional
		public PlainComment remove(Long userId, Long userProfileId, Long commentId) {
			validationForRemoveComment(userId, userProfileId, commentId);
			authorizationForRemoveComment(userId, userProfileId, commentId);
			
			Comment comment = commentRepository.findById(commentId).get();
			PlainComment result = Converter.toPlainComment(comment);
			commentRepository.delete(comment);

			return result;
		}
		
		// TODO: implement method
		private void validationForRemoveComment(Long userId, Long userProfileId, Long commentId) {

		}

		// TODO: implement method
		private void authorizationForRemoveComment(Long userId, Long userProfileId, Long commentId) {

		}
}
