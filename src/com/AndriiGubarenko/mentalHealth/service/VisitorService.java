package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.UserProfile;
import com.AndriiGubarenko.mentalHealth.repositories.VisitorCrud;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainComment;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserProfile;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component
public class VisitorService implements IVisitorService {
	@Autowired
	private VisitorCrud visitorCrud;
	
	@Autowired
	private ICommentService commentService;
	
	@Override
	@Transactional(readOnly = true)
	public Object[] getFullProfile(Long userProfileId) {

		UserProfile userProfile = visitorCrud.findById(userProfileId).get();
		
		List<PlainComment> commentList = commentService.getList(userProfileId);
		
		PlainUserProfile plainUserProfile = Converter.toPlainUserProfile(userProfile);
		
		Object[] result = new Object[2];
		result[0] = plainUserProfile;
	    result[1] = commentList;
		return result;
	}
}
