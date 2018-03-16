package com.AndriiGubarenko.mentalHealth.service;

import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;

public interface ICommentService {

	PlainComment create(Long userProfileId, PlainComment plainComment);

}