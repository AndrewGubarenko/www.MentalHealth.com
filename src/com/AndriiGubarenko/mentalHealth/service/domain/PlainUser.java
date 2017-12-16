package com.AndriiGubarenko.mentalHealth.service.domain;

import java.util.Set;

public class PlainUser {
	private Long id;
	private String login;
	private String password;
	private Set<Long> userProfileId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Set<Long> getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(Set<Long> userProfileId) {
		this.userProfileId = userProfileId;
	}
	
	
}
