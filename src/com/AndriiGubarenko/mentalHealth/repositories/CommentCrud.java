package com.AndriiGubarenko.mentalHealth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AndriiGubarenko.mentalHealth.domain.Comment;

public interface CommentCrud extends CrudRepository<Comment, Long>{

}
