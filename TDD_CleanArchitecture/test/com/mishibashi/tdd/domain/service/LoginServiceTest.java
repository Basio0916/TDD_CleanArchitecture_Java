package com.mishibashi.tdd.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.mishibashi.tdd.domain.model.User;
import com.mishibashi.tdd.domain.model.UserAggregate;
import com.mishibashi.tdd.infrastructure.UserRepository;

class LoginServiceTest {

	@Test
	void IDが存在しない場合のisExist() {
		String id = "0001";
		boolean expected = false;
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		when(mockRepository.findById(id)).thenReturn(null);
		LoginService loginService = new LoginService(mockRepository);
		
		assertEquals(expected, loginService.isExist(id));
	}
	
	@Test
	void IDが存在する場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String id = "0001";
		boolean expected = true;
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		User[] users = new User[] {new User("0001", "Makoto Ishibashi")};
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(users));
		LoginService loginService = new LoginService(mockRepository);
		
		assertEquals(expected, loginService.isExist(id));
	}
	
	@Test
	void IDが存在しない場合のgetName() {
		fail("まだ実装されていません");
	}
	
	@Test
	void IDが存在する場合のgetName() {
		fail("まだ実装されていません");
	}
	
	@Test
	void IDが存在しない場合のlogin() {
		fail("まだ実装されていません");
	}
	
	@Test
	void IDが存在する場合のlogin() {
		fail("まだ実装されていません");
	}
	

}
