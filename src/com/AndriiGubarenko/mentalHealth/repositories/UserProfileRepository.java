package com.AndriiGubarenko.mentalHealth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long>{

}
