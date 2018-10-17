package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

public interface IUserListRepresentationService {

	List<List<Object>> getFullUserProfileList();
	
	List<List<Object>> getShortUserProfileList();

}