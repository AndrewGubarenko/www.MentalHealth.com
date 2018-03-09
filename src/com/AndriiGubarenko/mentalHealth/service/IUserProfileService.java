package com.AndriiGubarenko.mentalHealth.service;

import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;

public interface IUserProfileService {

	PlainUserProfile update(Long userId, PlainUserProfile plainUserProfile);

	PlainUserProfile get(Long userId, Long userProfileId);

	PlainUserProfile create(Long userId, PlainUserProfile plainUserProfile);

}