package com.AndriiGubarenko.mentalHealth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;

public interface VisitorRepository extends CrudRepository<UserProfile, Long>{
	
}
