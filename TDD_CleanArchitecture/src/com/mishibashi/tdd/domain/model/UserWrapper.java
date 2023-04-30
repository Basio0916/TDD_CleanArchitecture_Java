package com.mishibashi.tdd.domain.model;

public class UserWrapper extends EntityWrapper<User> {

	public String getUpperName() {
		return getData().getName().toUpperCase();
	}
}
