package com.AndriiGubarenko.mentalHealth.service.domain;

import java.util.HashSet;
import java.util.Set;

public class PlainComment {

	private Long id;
	private String visitorName;
	private String commentText;
	private double rating;
	private Long userProfileId;
	private Long parentId;
	private Set<Long> childIds = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Set<Long> getChildIds() {
		return childIds;
	}

	public void setChildIds(Set<Long> childIds) {
		this.childIds = childIds;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}
}
