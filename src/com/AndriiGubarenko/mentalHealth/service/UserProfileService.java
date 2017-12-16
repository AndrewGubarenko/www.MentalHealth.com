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
		
		plainUserProfile.setName(userProfile.getName());
		plainUserProfile.setSpeciality(userProfile.getSpeciality());
		plainUserProfile.setEssay(userProfile.getEssay());
		plainUserProfile.setPrice(userProfile.getPrice());
		plainUserProfile.setExperience(userProfile.getExperience());
		plainUserProfile.setBirthday(userProfile.getBirthday());
		plainUserProfile.setRaiting(userProfile.getRaiting());
		plainUserProfile.setComments(userProfile.getComments());
		plainUserProfile.setContacts(userProfile.getContacts());
		//plainUserProfile.setUserPhoto(userProfile.getUserPhoto());
		
		return plainUserProfile;
	}
	
	private UserProfile create(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {
		UserProfile userProfile = new UserProfile();

		userProfile.setName(plainUserProfile.getName());
		userProfile.setSpeciality(plainUserProfile.getSpeciality());
		userProfile.setEssay(plainUserProfile.getEssay());
		userProfile.setPrice(plainUserProfile.getPrice());
		userProfile.setExperience((Date)plainUserProfile.getExperience().clone());
		userProfile.setBirthday((Date)plainUserProfile.getBirthday().clone());
		userProfile.setRaiting(plainUserProfile.getRaiting());
		userProfile.setComments(plainUserProfile.getComments());
		userProfile.setContacts(plainUserProfile.getContacts());
		//userProfile.setUserPhoto(plainUserProfile.getUserPhoto());
		
		User user = entityManager.find(User.class, userId);
		userProfile.setUser(user);
		
		entityManager.persist(userProfile);
		
		return userProfile;
	}
}
