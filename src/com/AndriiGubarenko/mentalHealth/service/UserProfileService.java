package com.AndriiGubarenko.mentalHealth.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.TransactionUtils;

@Component("userProfileService")
public class UserProfileService {
	@Resource(name = "transactionUtils")
	private TransactionUtils transactionUtils;
	
	
	public PlainUserProfile create(Long userId, PlainUserProfile plainUserProfile) {
		return transactionUtils.performInsideTransaction(entityManager ->{
			UserProfile userProfile = create(entityManager, userId, plainUserProfile);
			PlainUserProfile result = convert(userProfile);
			return result;
		});		
	}
	
	private PlainUserProfile convert(UserProfile userProfile) {
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
		//plainUserProfile.setComments(userProfile.getComments());
		plainUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
		plainUserProfile.setEmail(userProfile.getEmail());
		plainUserProfile.setLinkedin(userProfile.getLinkedin());
		plainUserProfile.setFacebook(userProfile.getFacebook());
		plainUserProfile.setSkype(userProfile.getSkype());
		plainUserProfile.setUserId(userProfile.getUser().getId());
		//plainUserProfile.setUserPhoto(userProfile.getUserPhoto());
		
		return plainUserProfile;
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
		userProfile.setExperience((Date)plainUserProfile.getExperience().clone());
		userProfile.setBirthday((Date)plainUserProfile.getBirthday().clone());
		userProfile.setRating(plainUserProfile.getRating());
		//userProfile.setComments(plainUserProfile.getComments());
		userProfile.setPhoneNumber(plainUserProfile.getPhoneNumber());
		userProfile.setEmail(plainUserProfile.getEmail());
		userProfile.setLinkedin(plainUserProfile.getLinkedin());
		userProfile.setFacebook(plainUserProfile.getFacebook());
		userProfile.setSkype(plainUserProfile.getSkype());
		//userProfile.setUserPhoto(plainUserProfile.getUserPhoto());
		
		User user = entityManager.find(User.class, userId);
		userProfile.setUser(user);
		
		entityManager.persist(userProfile);
		
		return userProfile;
	}
}
