package com.AndriiGubarenko.mentalHealth.service.utils;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;

public class Converter {
	public static PlainUserProfile toPlainUserProfile(UserProfile userProfile) {
		PlainUserProfile plainUserProfile = new PlainUserProfile();

		plainUserProfile.setId(userProfile.getId());
		plainUserProfile.setName(userProfile.getName());
		plainUserProfile.setSurname(userProfile.getSurname());
		plainUserProfile.setSpeciality(userProfile.getSpeciality());
		plainUserProfile.setEssay(userProfile.getEssay());
		plainUserProfile.setPrice(userProfile.getPrice());
		plainUserProfile.setCurrency(userProfile.getCurrency());
		plainUserProfile.setExperience(userProfile.getExperience());
		plainUserProfile.setBirthday(userProfile.getBirthday());
		plainUserProfile.setRating(userProfile.getRating());
		// plainUserProfile.setComments(userProfile.getComments());
		plainUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
		plainUserProfile.setEmail(userProfile.getEmail());
		plainUserProfile.setLinkedin(userProfile.getLinkedin());
		plainUserProfile.setFacebook(userProfile.getFacebook());
		plainUserProfile.setSkype(userProfile.getSkype());
		plainUserProfile.setUserId(userProfile.getUser().getId());
		plainUserProfile.setUserPhoto(userProfile.getUserPhoto());

		return plainUserProfile;
	}
}
