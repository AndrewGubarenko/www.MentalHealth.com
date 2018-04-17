package com.AndriiGubarenko.mentalHealth.service.utils;

import java.util.stream.Collectors;

import com.AndriiGubarenko.mentalHealth.domain.Comment;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;

public class Converter {
	public static PlainUserProfile toPlainUserProfile(UserProfile userProfile) {
		PlainUserProfile plainUserProfile = new PlainUserProfile();

		plainUserProfile.setId(userProfile.getId());
		plainUserProfile.setName(userProfile.getName());
		plainUserProfile.setSurname(userProfile.getSurname());
		plainUserProfile.setSpeciality(userProfile.getSpeciality());
		plainUserProfile.setLocation(userProfile.getLocation());
		plainUserProfile.setEssay(userProfile.getEssay());
		plainUserProfile.setPrice(userProfile.getPrice());
		plainUserProfile.setCurrency(userProfile.getCurrency());
		plainUserProfile.setExperience(userProfile.getExperience());
		plainUserProfile.setBirthday(userProfile.getBirthday());
		plainUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
		plainUserProfile.setEmail(userProfile.getEmail());
		plainUserProfile.setLinkedin(userProfile.getLinkedin());
		plainUserProfile.setFacebook(userProfile.getFacebook());
		plainUserProfile.setSkype(userProfile.getSkype());
		plainUserProfile.setUniversity(userProfile.getUniversity());
		plainUserProfile.setUserId(userProfile.getUser().getId());
		
		plainUserProfile.setCommentIds(userProfile.getCommentList().stream().map(Converter::toPlainComment).collect(Collectors.toSet()));
		
		plainUserProfile.setUserPhoto(userProfile.getUserPhoto());
		plainUserProfile.setUserDiploma(userProfile.getUserDiploma());

		return plainUserProfile;
	}
	
	public static PlainComment toPlainComment(Comment comment) {
		PlainComment plainComment = new PlainComment();
		
		plainComment.setId(comment.getId());
		plainComment.setVisitorName(comment.getVisitorName());
		plainComment.setCommentText(comment.getCommentText());
		plainComment.setRating(comment.getRating());
		plainComment.setUserProfileId(comment.getUserProfile().getId());
		plainComment.setChildIds(comment.getChildren().stream().map(child -> child.getId()).collect(Collectors.toSet()));
		setParentId(plainComment, comment.getParent());
		return plainComment;
	}
	
	private static void setParentId(PlainComment target, Comment parent) {
		if (parent == null) {
			target.setParentId(null);
		} else {
			target.setParentId(parent.getId());
		}
	}
	
/*	public static PlainUserListRepresentation toPlain(UserListRepresentation userListRepresentation) {
		PlainUserListRepresentation result = new PlainUserListRepresentation();
		
		result.setByName(userListRepresentation.getByName());
		result.setBySurname(userListRepresentation.getBySurname());
		result.setBySpeciality(userListRepresentation.getBySpeciality());
		result.setByLocation(userListRepresentation.getByLocation());
		result.setByPrice(userListRepresentation.getByPrice());
		result.setByCurrency(userListRepresentation.getByCurrency());
		
		return result;
	}*/
}
