package com.mishibashi.tdd.domain.model;

import java.lang.reflect.InvocationTargetException;

public class UserAggregate extends Aggregate<UserEntity, User> {

	public UserAggregate(User[] data) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(UserEntity.class, data);
	}

}
