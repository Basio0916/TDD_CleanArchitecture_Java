package com.mishibashi.tdd.domain.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.mishibashi.tdd.domain.model.UserWrapperAggregate;
import com.mishibashi.tdd.domain.repository.IUserRepository;
import com.mishibashi.tdd.exception.NotFoundException;

public class LoginService {
	IUserRepository _repository;
	
	public LoginService(IUserRepository repository) {
		_repository = repository;
	}
	
	public boolean isExist(String id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		UserWrapperAggregate users = _repository.findById(id);
		return users.isExist();
	}
	
	public String getName(String id) throws NotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		UserWrapperAggregate users = _repository.findById(id);
		if(!users.isExist()) {
			throw new NotFoundException();
		}
		
		return users.getEntityWrapperList().get(0).getData().getName();
	}
	
	public void login(String id, String terminalNo) throws NotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		UserWrapperAggregate users = _repository.findById(id);
		if(!users.isExist()) {
			throw new NotFoundException();
		}
		
		_repository.login(id, terminalNo);
	}
}
