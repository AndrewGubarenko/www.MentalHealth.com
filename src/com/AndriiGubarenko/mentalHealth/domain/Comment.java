package com.AndriiGubarenko.mentalHealth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ID")
	private Long id;
	
	@Column(name = "VISITOR_NAME")
	private String visitorName;
	
	@Column(name = "COMMENT_TEXT", columnDefinition = "TEXT")
	private String commentText;
	
	@Column(name = "RATING")
	private double rating;
	
	@ManyToOne
	@JoinColumn(name = "USER_PROFILE_ID", nullable = false)
	private UserProfile userProfile;

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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		setUserProfile(userProfile, false);
	}
	
	public void setUserProfile(UserProfile userProfile, boolean otherSideHasBeenAlreadySet) {
		this.userProfile = userProfile;
		if(otherSideHasBeenAlreadySet) {
			return;
		}
		userProfile.addComment(this, true);
	}
}
