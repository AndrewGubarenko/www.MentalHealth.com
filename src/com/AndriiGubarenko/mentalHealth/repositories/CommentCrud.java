package com.AndriiGubarenko.mentalHealth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.Comment;

public interface CommentCrud extends CrudRepository<Comment, Long>{
	@Query("SELECT comment FROM Comment comment JOIN comment.userProfile userProfile WHERE userProfile.id = ?1")
	List<Comment> findByUserProfileId(Long userProfileId);
}
