package com.mishibashi.tdd.domain.model;

public class UserEntity extends Entity<User> {

	public String getUpperName() {
		return getData().getName().toUpperCase();
	}
}
