package com.mishibashi.tdd.domain.service;

import com.mishibashi.tdd.domain.model.UserAggregate;
import com.mishibashi.tdd.domain.repository.IUserRepository;
import com.mishibashi.tdd.exception.NotFoundException;

public class LoginService {
	IUserRepository _repository;
	
	public LoginService(IUserRepository repository) {
		_repository = repository;
	}
	
	public boolean isExist(String id) {
		UserAggregate users = _repository.findById(id);
		return users.isExist();
	}
	
	public String getName(String id) throws NotFoundException {
		UserAggregate users = _repository.findById(id);
		if(!users.isExist()) {
			throw new NotFoundException();
		}
		
		return users.getEntityList().get(0).getData().getName();
	}
	
	public void login(String id) throws NotFoundException {
		UserAggregate users = _repository.findById(id);
		if(!users.isExist()) {
			throw new NotFoundException();
		}
		
		_repository.login(id);
	}
}
