package com.AndriiGubarenko.mentalHealth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.UserCrud;
import com.AndriiGubarenko.mentalHealth.repositories.UserProfileCrud;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component
public class UserProfileService implements IUserProfileService {
	
	@Autowired
	private UserProfileCrud userProfileCrud;
	
	@Autowired
	private UserCrud userCrud;

	@Override
	@Transactional
	public PlainUserProfile update(Long userId, PlainUserProfile plainUserProfile) {
		validationForUpdate(userId, plainUserProfile);
		authorizationForUpdate(userId, plainUserProfile);
		
		// TODO: Correct getting userProfile
		UserProfile userProfile = userProfileCrud.findById(plainUserProfile.getId()).get();

		userProfile.setName(plainUserProfile.getName());
		userProfile.setSurname(plainUserProfile.getSurname());
		userProfile.setSpeciality(plainUserProfile.getSpeciality());
		userProfile.setLocation(plainUserProfile.getLocation());
		userProfile.setEssay(plainUserProfile.getEssay());
		userProfile.setPrice(plainUserProfile.getPrice());
		userProfile.setCurrency(plainUserProfile.getCurrency());
		userProfile.setExperience((Date) plainUserProfile.getExperience().clone());
		userProfile.setBirthday((Date) plainUserProfile.getBirthday().clone());
		userProfile.setPhoneNumber(plainUserProfile.getPhoneNumber());
		userProfile.setEmail(plainUserProfile.getEmail());
		userProfile.setLinkedin(plainUserProfile.getLinkedin());
		userProfile.setFacebook(plainUserProfile.getFacebook());
		userProfile.setSkype(plainUserProfile.getSkype());
		
		userProfile.setUserPhoto(plainUserProfile.getUserPhoto());
		userProfile.setUserDiploma(plainUserProfile.getUserDiploma());
		
		//userProfile.setComments(plainUserProfile.getCommentIds()).forEach(userProfile::addComment);

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

		UserProfile userProfile = userProfileCrud.findById(userProfileId).get();

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

		userProfile.setName(plainUserProfile.getName());
		userProfile.setSurname(plainUserProfile.getSurname());
		userProfile.setSpeciality(plainUserProfile.getSpeciality());
		userProfile.setLocation(plainUserProfile.getLocation());
		userProfile.setEssay(plainUserProfile.getEssay());
		userProfile.setPrice(plainUserProfile.getPrice());
		userProfile.setCurrency(plainUserProfile.getCurrency());
		userProfile.setExperience((Date) plainUserProfile.getExperience().clone());
		userProfile.setBirthday((Date) plainUserProfile.getBirthday().clone());
		userProfile.setPhoneNumber(plainUserProfile.getPhoneNumber());
		userProfile.setEmail(plainUserProfile.getEmail());
		userProfile.setLinkedin(plainUserProfile.getLinkedin());
		userProfile.setFacebook(plainUserProfile.getFacebook());
		userProfile.setSkype(plainUserProfile.getSkype());
		
		userProfile.setUserPhoto(plainUserProfile.getUserPhoto());
		userProfile.setUserDiploma(plainUserProfile.getUserDiploma());
		
		User user = userCrud.findById(userId).get();
		userProfile.setUser(user);
		
		userProfileCrud.save(userProfile);
		
		//createComments(plainUserProfile.getCommentIds()).forEach(userProfile::addComment);
		
		PlainUserProfile result = Converter.toPlainUserProfile(userProfile);
		
		return result;
	}

	// TODO: implement method
	private void validationForCreate(Long userId, PlainUserProfile plainUserProfile) {

	}
	
/*	private List<Comment> createComments(EntityManager entityManager, Collection<PlainComment> plainComments) {
		return plainComments.stream().map(plainComment -> {
			Comment comment = new Comment();
			entityManager.persist(comment);
			return comment;
		}).collect(Collectors.toList());
	}*/

}
