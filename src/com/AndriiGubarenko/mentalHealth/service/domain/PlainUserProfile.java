package com.AndriiGubarenko.mentalHealth.service.domain;

import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;

public class PlainUserProfile {

	private Long id;

	private String name;
	
	private String surname;

	private String speciality;

	private String essay;
	
	private Long price;
	
	private String currency;

	private Date experience;

	private Date birthday;
	
	private double rating;
	
	//private String comments;
	
	private String phoneNumber;
	
	private String email;
	
	private String linkedin;

	private String facebook;
	
	private String skype;
	
	private String userPhotoSrc;
	
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String spesiality) {
		this.speciality = spesiality;
	}

	public String getEssay() {
		return essay;
	}

	public void setEssay(String essay) {
		this.essay = essay;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getExperience() {
		return experience;
	}

	public void setExperience(Date experience) {
		this.experience = experience;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

/*
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
*/
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//----------------------------------------------------------
	
	public String getUserPhotoSrc() {
		return userPhotoSrc;
	}

	public void setUserPhotoSrc(byte[] userPhotoSrc) {
		this.userPhotoSrc = Base64.encodeBase64String(userPhotoSrc);
	}

	//----------------------------------------------------------
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}	
}
