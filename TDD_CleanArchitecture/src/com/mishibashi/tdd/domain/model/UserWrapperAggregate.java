package com.mishibashi.tdd.domain.model;

import java.lang.reflect.InvocationTargetException;

public class UserWrapperAggregate extends EntityWrapperAggregate<UserWrapper, User> {

	public UserWrapperAggregate(User[] data) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(UserWrapper.class, data);
	}

}
