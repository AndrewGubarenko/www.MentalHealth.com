/*package com.AndriiGubarenko.mentalHealth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.AndriiGubarenko.mentalHealth.domain.UserListRepresentation;
import com.AndriiGubarenko.mentalHealth.repositories.UserListRepresentationCrud;
import com.AndriiGubarenko.mentalHealth.service.domain.PlainUserListRepresentation;
import com.AndriiGubarenko.mentalHealth.service.utils.Converter;

@Component
public class UserListRepresentationService implements IUserListRepresentationService {
	@Autowired
	private UserListRepresentationCrud crud;
	
	@Override
	@Transactional
	public PlainUserListRepresentation create(PlainUserListRepresentation plainRepresentation) {
		UserListRepresentation representation = new UserListRepresentation();
		
		representation.setByName(plainRepresentation.getByName());
		representation.setBySurname(plainRepresentation.getBySurname());
		representation.setByLocation(plainRepresentation.getByLocation());
		representation.setBySpeciality(plainRepresentation.getBySpeciality());
		representation.setByPrice(plainRepresentation.getByPrice());
		representation.setByCurrency(plainRepresentation.getByCurrency());
		
		crud.save(representation);
		
		return Converter.toPlain(representation);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PlainUserListRepresentation> getList(String name) {
		return crud.findByName(name).stream().map(Converter::toPlain).collect(Collectors.toList());
	}

	@Override
	public PlainUserListRepresentation update(PlainUserListRepresentation plainUserListRepresentation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlainUserListRepresentation remove(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
*/