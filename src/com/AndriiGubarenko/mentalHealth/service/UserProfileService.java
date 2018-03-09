package com.AndriiGubarenko.mentalHealth.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.AndriiGubarenko.mentalHealth.domain.Comment;
import com.AndriiGubarenko.mentalHealth.domain.User;
import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.service.annotation.Transactional;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component("userProfileService")
public class UserProfileService implements IUserProfileService {
	
	private EntityManager entityManager;

	@Override
	@Transactional
	public PlainUserProfile update(Long userId, PlainUserProfile plainUserProfile) {
		validationForUpdate(entityManager, userId, plainUserProfile);
		authorizationForUpdate(entityManager, userId, plainUserProfile);

		UserProfile userProfile = entityManager.find(UserProfile.class, plainUserProfile.getId());

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
		
		userProfile.setComments(createComments(entityManager, plainUserProfile.getCommentIds()));

		return Converter.toPlainUserProfile(userProfile);
	}

	// TODO: implement method
	private void validationForUpdate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	// TODO: implement method
	private void authorizationForUpdate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	@Override
	@Transactional
	public PlainUserProfile get(Long userId, Long userProfileId) {
		return get(entityManager, userId, userProfileId);
	}

	private PlainUserProfile get(EntityManager entityManager, Long userId, Long userProfileId) {
		validationForGet(entityManager, userId, userProfileId);
		authorizationForGet(entityManager, userId, userProfileId);

		UserProfile userProfile = entityManager.find(UserProfile.class, userProfileId);

		return Converter.toPlainUserProfile(userProfile);
	}

	// TODO: implement method
	private void validationForGet(EntityManager entityManager, Long userId, Long userProfileId) {

	}

	// TODO: implement method
	private void authorizationForGet(EntityManager entityManager, Long userId, Long userProfileId) {

	}

	@Override
	@Transactional
	public PlainUserProfile create(Long userId, PlainUserProfile plainUserProfile) {
		validationForCreate(entityManager, userId, plainUserProfile);
		UserProfile userProfile = create(entityManager, userId, plainUserProfile);
		PlainUserProfile result = Converter.toPlainUserProfile(userProfile);
		return result;
	}

	// TODO: implement method
	private void validationForCreate(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {

	}

	private UserProfile create(EntityManager entityManager, Long userId, PlainUserProfile plainUserProfile) {
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
		
		User user = entityManager.find(User.class, userId);
		userProfile.setUser(user);
		
		entityManager.persist(userProfile);
		
		createComments(entityManager, plainUserProfile.getCommentIds()).forEach(userProfile::addComment);

		return userProfile;
	}
	
	private List<Comment> createComments(EntityManager entityManager, Collection<PlainComment> plainComments) {
		return plainComments.stream().map(plainComment -> {
			Comment comment = new Comment();
			entityManager.persist(comment);
			return comment;
		}).collect(Collectors.toList());
	}

}
