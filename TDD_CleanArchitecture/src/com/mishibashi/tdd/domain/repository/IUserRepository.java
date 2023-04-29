package com.mishibashi.tdd.domain.repository;

import com.mishibashi.tdd.domain.model.UserAggregate;

public interface IUserRepository {
	public UserAggregate findById(String id);
}
