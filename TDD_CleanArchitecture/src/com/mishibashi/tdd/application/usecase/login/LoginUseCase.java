package com.mishibashi.tdd.application.usecase.login;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mishibashi.tdd.domain.service.LoginService;
import com.mishibashi.tdd.exception.NotFoundException;

public class LoginUseCase {
	private final Connection connection;
	private final LoginService loginService;
	private final ILoginUseCaseOutputPort outputPort;
	
	public LoginUseCase(Connection connection, ILoginUseCaseOutputPort outputPort, LoginService loginService) {
		this.connection = connection;
		this.outputPort = outputPort;
		this.loginService = loginService;
	}
	
	public void getUserName(String id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, NotFoundException {
		if(!loginService.isExist(id)) {
			outputPort.userNotFound();
			return;
		}
		final String name = loginService.getName(id);
		outputPort.successGetUserName(name);
	}
	
	public void login(String id, String terminalNo) throws SQLException {
		
		connection.commit();
	}
}
