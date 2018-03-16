/*package com.AndriiGubarenko.mentalHealth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.UserListRepresentation;

public interface UserListRepresentationCrud extends CrudRepository<UserListRepresentation, Long>{
	
	@Query("SELECT representation FROM UserListRepresentation representation "
			+ " WHERE userProfile.name=?1")
	List<UserListRepresentation> findByName(String name);
}
*/