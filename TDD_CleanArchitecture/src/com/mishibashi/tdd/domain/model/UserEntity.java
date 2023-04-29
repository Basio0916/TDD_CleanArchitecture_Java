package com.mishibashi.tdd.domain.model;

public class UserEntity extends Entity<User> {
	public UserEntity(User entity) {
		super(entity);
	}

	public String getUpperName() {
		return getData().getName().toUpperCase();
	}
}
