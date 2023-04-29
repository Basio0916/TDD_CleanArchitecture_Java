package com.mishibashi.tdd.application.usecase.login;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mishibashi.tdd.domain.repository.IUserRepository;
import com.mishibashi.tdd.domain.service.LoginService;
import com.mishibashi.tdd.exception.NotFoundException;
import com.mishibashi.tdd.infrastructure.UserRepository;

public class LoginUseCase {
	private final LoginService loginService;
	private final ILoginUseCaseOutputPort outputPort;
	
	public LoginUseCase(Connection connection, ILoginUseCaseOutputPort outputPort) {
		this.outputPort = outputPort;
		IUserRepository userRepository = new UserRepository(connection);
		loginService = new LoginService(userRepository);
	}
	
	public void getUserName(String id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, NotFoundException {
		if(!loginService.isExist(id)) {
			outputPort.userNotFound();
			return;
		}
		final String name = loginService.getName(id);
		outputPort.successGetUserName(name);
	}
	
	public void login(String id, String terminalNo) {
		
	}
}
