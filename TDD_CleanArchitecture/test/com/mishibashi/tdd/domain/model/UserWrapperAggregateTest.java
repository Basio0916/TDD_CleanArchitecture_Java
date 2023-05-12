package com.mishibashi.tdd.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

class UserWrapperAggregateTest {

	@Test
	void nullの場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		User[] user = null;
		boolean expected = false;
		
		UserWrapperAggregate userAggregate = new UserWrapperAggregate(user);
		
		assertEquals(expected, userAggregate.isExist());
	}
	
	@Test
	void データがない場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		User[] user = new User[]{};
		boolean expected = false;
		
		UserWrapperAggregate userAggregate = new UserWrapperAggregate(user);
		
		assertEquals(expected, userAggregate.isExist());
	}
	
	@Test
	void データがある場合のisExist() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		User[] user = new User[]{new User("0001", "Makoto Ishibashi")};
		boolean expected = true;
		
		UserWrapperAggregate userAggregate = new UserWrapperAggregate(user);
		
		assertEquals(expected, userAggregate.isExist());
	}

}
