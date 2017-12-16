package com.AndriiGubarenko.mentalHealth.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	//Решить проблему
	@OneToMany(mappedBy = "user")
	private Set<UserProfile> userProfile = new HashSet<>();
	
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

	public Set<UserProfile> getUserProfile() {
		return userProfile;
	}

	public void addUserProfile(UserProfile userProfile) {
		addUserProfile(userProfile, false);
	}
	
	public void addUserProfile(UserProfile userProfile, boolean otherSideHasBeenAlreadySet) {
		getUserProfile().add(userProfile);
		if(otherSideHasBeenAlreadySet) {
			return;
		}
		userProfile.setUser(this, true);
	}
}
