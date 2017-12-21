package com.AndriiGubarenko.mentalHealth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "user")
	private UserProfile userProfile;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void addUserProfile(UserProfile userProfile) {
		addUserProfile(userProfile, false);
	}
	
	public void addUserProfile(UserProfile userProfile, boolean otherSideHasBeenAlreadySet) {
		this.userProfile = userProfile;
		if(otherSideHasBeenAlreadySet) {
			return;
		}
		userProfile.setUser(this, true);
	}
}
