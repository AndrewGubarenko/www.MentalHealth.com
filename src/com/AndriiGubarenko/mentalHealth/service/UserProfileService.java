package com.AndriiGubarenko.mentalHealth.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;
import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component("userProfileService")
public class UserProfileService {
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;

	public PlainUserProfile update(Long userId, PlainUserProfile plainUserProfile) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			validationForUpdate(entityManager, userId, plainUserProfile);
			authorizationForUpdate(entityManager, userId, plainUserProfile);

			UserProfile userProfile = entityManager.find(UserProfile.class, plainUserProfile.getId());

			userProfile.setName(plainUserProfile.getName());
			userProfile.setSurname(plainUserProfile.getSurname());
			userProfile.setSpeciality(plainUserProfile.getSpeciality());
			userProfile.setEssay(plainUserProfile.getEssay());
			userProfile.setPrice(plainUserProfile.getPrice());
			userProfile.setCurrency(plainUserProfile.getCurrency());
			userProfile.setExperience((Date) plainUserProfile.getExperience().clone());
			userProfile.setBirthday((Date) plainUserProfile.getBirthday().clone());
			userProfile.setRating(plainUserProfile.getRating());
			// userProfile.setComments(plainUserProfile.getComments());
			userProfile.setPhoneNumber(plainUserProfile.getPhoneNumber());
			userProfile.setEmail(plainUserProfile.getEmail());
			userProfile.setLinkedin(plainUserProfile.getLinkedin());
			userProfile.setFacebook(plainUserProfile.getFacebook());
			userProfile.setSkype(plainUserProfile.getSkype());
			
			userProfile.setUserPhotoSrc(plainUserProfile.getUserPhotoSrc());

			return Converter.toPlainUserProfile(userProfile);
		});
	}

	// TODO: implement this
	private void validationForUpdate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	// TODO: implement this
	private void authorizationForUpdate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	public PlainUserProfile get(Long userId, Long userProfileId) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			return get(entityManager, userId, userProfileId);
		});
	}

	private PlainUserProfile get(EntityManager entityManager, Long userId, Long userProfileId) {
		validationForGet(entityManager, userId, userProfileId);
		authorizationForGet(entityManager, userId, userProfileId);

		UserProfile userProfile = entityManager.find(UserProfile.class, userProfileId);

		return Converter.toPlainUserProfile(userProfile);
	}

	// TODO: implement this
	private void validationForGet(EntityManager entityManager, Long userId, Long userProfileId) {

	}

	// TODO: implement this
	private void authorizationForGet(EntityManager entityManager, Long userId, Long userProfileId) {

	}

	public PlainUserProfile create(Long userId, PlainUserProfile plainUserProfile) {
		return transactionUtils.performInsideTransaction(entityManager -> {
			validationForCreate(entityManager, userId, plainUserProfile);
			UserProfile userProfile = create(entityManager, userId, plainUserProfile);
			PlainUserProfile result = Converter.toPlainUserProfile(userProfile);
			return result;
		});
	}

	// TODO: implement this
	private void validationForCreate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	private UserProfile create(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {
		UserProfile userProfile = new UserProfile();

		userProfile.setId(plainUserProfile.getId());
		userProfile.setName(plainUserProfile.getName());
		userProfile.setSurname(plainUserProfile.getSurname());
		userProfile.setSpeciality(plainUserProfile.getSpeciality());
		userProfile.setEssay(plainUserProfile.getEssay());
		userProfile.setPrice(plainUserProfile.getPrice());
		userProfile.setCurrency(plainUserProfile.getCurrency());
		userProfile.setExperience((Date) plainUserProfile.getExperience().clone());
		userProfile.setBirthday((Date) plainUserProfile.getBirthday().clone());
		userProfile.setRating(plainUserProfile.getRating());
		// userProfile.setComments(plainUserProfile.getComments());
		userProfile.setPhoneNumber(plainUserProfile.getPhoneNumber());
		userProfile.setEmail(plainUserProfile.getEmail());
		userProfile.setLinkedin(plainUserProfile.getLinkedin());
		userProfile.setFacebook(plainUserProfile.getFacebook());
		userProfile.setSkype(plainUserProfile.getSkype());
		
		userProfile.setUserPhotoSrc(plainUserProfile.getUserPhotoSrc());
		
		User user = entityManager.find(User.class, userId);
		userProfile.setUser(user);
		
		entityManager.persist(userProfile);

		return userProfile;
	}

}
