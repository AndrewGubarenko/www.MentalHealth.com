package com.AndriiGubarenko.mentalHealth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.UserListRepresentationRepository;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component("userListRepresentationService")
public class UserListRepresentationService implements IUserListRepresentationService {
	
	@Autowired
	private UserListRepresentationRepository userListRepresentationRepository;

	@Override
	@Transactional(readOnly = true)
	public List<List<Object>> getFullUserProfileList() {
		List<UserProfile> userProfiles = userListRepresentationRepository.findAllUserProfiles();
		return userProfiles.stream().map(Converter::toPlainUserProfileList).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<List<Object>> getShortUserProfileList() {
		List<List<Object>> list = getFullUserProfileList();
		List<List<Object>> result = new ArrayList<>();
		int cycle;
		if(list.size() < 8) {
			cycle = list.size();
			} else {
				cycle = 8;
			}
		for(int i = 0; i < cycle; i++) {
			int profileNumber = 0 + (int) (Math.random() * list.size());
			result.add(list.get(profileNumber));
			list.remove(profileNumber);
		}
		return result;
	}
}
