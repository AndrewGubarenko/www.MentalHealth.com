package com.AndriiGubarenko.mentalHealth.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "VISITOR_NAME")
	private String visitorName;

	@Column(name = "COMMENT_TEXT", columnDefinition = "TEXT")
	private String commentText;

	@Column(name = "RATING")
	private double rating;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Comment parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<Comment> children = new HashSet<>();

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
	
	//=============================================================
	
	public Set<Comment> getChildren() {
		return this.children;
	}

	public void setChildren(Set<Comment> children) {
		removeChildren();
		children.forEach(this::addChild);
	}

	public void removeChildren() {
		this.getChildren().stream().collect(Collectors.toList()).forEach(this::removeChild);
	}

	public void removeChild(Comment child) {
		removeChild(child, false);
	}

	private void removeChild(Comment child, boolean otherSideWasAffected) {
		this.getChildren().remove(child);
		if (otherSideWasAffected) {
			return;
		}
		child.removeParent(true);
	}

	public void addChild(Comment child) {
		addChild(child, false);
	}

	private void addChild(Comment child, boolean otherSideWasAffected) {
		this.getChildren().add(child);
		if (otherSideWasAffected) {
			return;
		}
		child.setParent(this, true);
	}

	public Comment getParent() {
		return this.parent;
	}

	public void setParent(Comment parent) {
		if (parent == null) {
			removeParent();
		} else {
			setParent(parent, false);
		}
	}

	public void removeParent() {
		removeParent(false);
	}

	private void removeParent(boolean otherSideWasAffected) {
		Comment parent = getParent();
		if (parent == null) {
			return;
		}

		this.parent = null;
		if (otherSideWasAffected) {
			return;
		}
		parent.removeChild(this, true);
	}

	private void setParent(Comment parent, boolean otherSideWasAffected) {
		this.parent = parent;
		if (otherSideWasAffected) {
			return;
		}
		parent.addChild(this, true);
	}

	public int hash() {
		return Objects.hash(this.getId(), this.getVisitorName(), this.getCommentText(), this.getRating());
	}

	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof Comment)) {
			return false;
		}

		Comment that = (Comment) object;

		if (!Objects.equals(this.getId(), that.getId())) {
			return false;
		}

		if (!Objects.equals(this.getVisitorName(), that.getVisitorName())) {
			return false;
		}

		if (!Objects.equals(this.getCommentText(), that.getCommentText())) {
			return false;
		}

		if (!Objects.equals(this.getRating(), that.getRating())) {
			return false;
		}

		return true;
	}
	
	//=============================================================

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		setUserProfile(userProfile, false);
	}

	public void setUserProfile(UserProfile userProfile, boolean otherSideHasBeenAlreadySet) {
		this.userProfile = userProfile;
		if (otherSideHasBeenAlreadySet) {
			return;
		}
		userProfile.addComment(this, true);
	}
	
	public void removeUserProfile() {
		removeUserProfile(false);
	}
	
	public void removeUserProfile(boolean otherSideRemoved) {
		UserProfile userProfile = this.getUserProfile();
		this.setUserProfile(null);
		if(otherSideRemoved) {
			return;
		}
		userProfile.removeComment(this, true);
	}
}
