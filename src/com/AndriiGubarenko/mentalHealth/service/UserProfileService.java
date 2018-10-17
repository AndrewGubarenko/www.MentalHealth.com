package com.AndriiGubarenko.mentalHealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.UserProfileRepository;
import com.AndriiGubarenko.mentalHealth.repositories.UserRepository;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component("userProfileService")
public class UserProfileService implements IUserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private void updatePartOfUserProfile(UserProfile target, PlainUserProfile source) {
		target.setName(source.getName());
		target.setSurname(source.getSurname());
		target.setSpeciality(source.getSpeciality());
		target.setLocation(source.getLocation());
		target.setEssay(source.getEssay());
		target.setPrice(source.getPrice());
		target.setCurrency(source.getCurrency());
		target.setExperience((Date) source.getExperience().clone());
		target.setBirthday((Date) source.getBirthday().clone());
		target.setPhoneNumber(source.getPhoneNumber());
		target.setEmail(source.getEmail());
		target.setLinkedin(source.getLinkedin());
		target.setFacebook(source.getFacebook());
		target.setSkype(source.getSkype());
		target.setUniversity(source.getUniversity());
		
		target.setUserPhoto(source.getUserPhoto());
		target.setUserDiploma(source.getUserDiploma());
	}

	@Override
	@Transactional
	public PlainUserProfile update(Long userId, PlainUserProfile plainUserProfile) {
		validationForUpdate(userId, plainUserProfile);
		authorizationForUpdate(userId, plainUserProfile);
		
		// TODO: Correct getting userProfile
		UserProfile userProfile = userProfileRepository.findById(plainUserProfile.getId()).get();

		updatePartOfUserProfile(userProfile, plainUserProfile);

		return Converter.toPlainUserProfile(userProfile);
	}

	// TODO: implement method
	private void validationForUpdate(Long userId, PlainUserProfile plainUserProfile) {

	}

	// TODO: implement method
	private void authorizationForUpdate(Long userId, PlainUserProfile plainUserProfile) {

	}

	@Override
	@Transactional(readOnly = true)
	public PlainUserProfile get(Long userId, Long userProfileId) {
		validationForGet(userId, userProfileId);
		authorizationForGet(userId, userProfileId);

		UserProfile userProfile = userProfileRepository.findById(userProfileId).get();

		return Converter.toPlainUserProfile(userProfile);
	}

	// TODO: implement method
	private void validationForGet(Long userId, Long userProfileId) {

	}

	// TODO: implement method
	private void authorizationForGet(Long userId, Long userProfileId) {

	}

	@Override
	@Transactional
	public PlainUserProfile create(Long userId, PlainUserProfile plainUserProfile) {
		validationForCreate(userId, plainUserProfile);

		UserProfile userProfile = new UserProfile();

		updatePartOfUserProfile(userProfile, plainUserProfile);
		
		User user = userRepository.findById(userId).get();
		userProfile.setUser(user);
		
		userProfileRepository.save(userProfile);
		
		PlainUserProfile result = Converter.toPlainUserProfile(userProfile);
		
		return result;
	}

	// TODO: implement method
	private void validationForCreate(Long userId, PlainUserProfile plainUserProfile) {

	}
}
