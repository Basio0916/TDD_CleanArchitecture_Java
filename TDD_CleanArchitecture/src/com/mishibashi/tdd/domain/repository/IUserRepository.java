package com.mishibashi.tdd.domain.repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.mishibashi.tdd.domain.model.UserWrapperAggregate;

public interface IUserRepository {
	public UserWrapperAggregate findById(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	public void login(String id, String terminalNo);
}
