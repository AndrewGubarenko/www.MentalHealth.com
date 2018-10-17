package com.AndriiGubarenko.mentalHealth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;

public interface UserListRepresentationRepository extends CrudRepository<UserProfile, Long>{
	@Query("SELECT userProfile FROM UserProfile userProfile")
	List<UserProfile> findAllUserProfiles();
}
