package com.mishibashi.tdd.domain.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mishibashi.tdd.domain.model.User;
import com.mishibashi.tdd.domain.model.UserAggregate;
import com.mishibashi.tdd.exception.NotFoundException;
import com.mishibashi.tdd.infrastructure.UserRepository;

class LoginServiceTest {

	@Test
	void IDが存在しない場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = "0001";
		boolean expected = false;
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(null));
		LoginService loginService = new LoginService(mockRepository);
		
		assertEquals(expected, loginService.isExist(id));
	}
	
	@Test
	void IDが存在する場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = "0001";
		boolean expected = true;
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		User[] users = new User[] {new User("0001", "Makoto Ishibashi")};
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(users));
		LoginService loginService = new LoginService(mockRepository);
		
		assertEquals(expected, loginService.isExist(id));
	}
	
	@Test
	void IDが存在しない場合のgetName() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = "0001";
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(null));
		LoginService loginService = new LoginService(mockRepository);
		
		assertThrows(NotFoundException.class, ()->{loginService.getName(id);});
	}
	
	@Test
	void IDが存在する場合のgetName() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NotFoundException, SQLException {
		String id = "0001";
		String expected = "Makoto Ishibashi";
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		User[] users = new User[] {new User("0001", "Makoto Ishibashi")};
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(users));
		LoginService loginService = new LoginService(mockRepository);
		
		assertEquals(expected, loginService.getName(id));
	}
	
	@Test
	void IDが存在しない場合のlogin() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = "0001";
		String terminalNo = "0001";
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(null));
		LoginService loginService = new LoginService(mockRepository);
		
		assertThrows(NotFoundException.class, ()->{loginService.login(id, terminalNo);});
		verify(mockRepository, times(0)).login(id, terminalNo);
	}
	
	@Test
	void IDが存在する場合のlogin() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		String id = "0001";
		String terminalNo = "0001";
		
		UserRepository mockRepository = mock(UserRepository.class);

		User[] users = new User[] {new User("0001", "Makoto Ishibashi")};
		when(mockRepository.findById(id)).thenReturn(new UserAggregate(users));
		LoginService loginService = new LoginService(mockRepository);
		
		assertDoesNotThrow(()->{loginService.login(id, terminalNo);});
		verify(mockRepository, times(1)).login(id, terminalNo);
	}
	

}
