package com.mishibashi.tdd.domain.service;

import com.mishibashi.tdd.domain.repository.IUserRepository;

public class LoginService {
	IUserRepository _repository;
	
	public LoginService(IUserRepository repository) {
		_repository = repository;
	}
	
	public boolean isExist(String id) {
		return false;
	}
	
	public String getName(String name) {
		return "";
	}
	
	public void login(String id) {
		
	}
}
