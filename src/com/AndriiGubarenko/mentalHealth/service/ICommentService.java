package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;

public interface ICommentService {

	PlainComment create(Long userProfileId, PlainComment plainComment);
	
	List<PlainComment> getList(Long userProfileId);

	PlainComment remove(Long userId, Long userProfileId, Long commentId);

}