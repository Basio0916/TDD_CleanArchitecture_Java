package com.mishibashi.tdd.application.usecase.login;

public interface ILoginUseCaseOutputPort {
	public void userNotFound();
	
	public void successGetUserName(String userName);
}
