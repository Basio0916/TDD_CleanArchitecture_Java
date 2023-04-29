package com.mishibashi.tdd.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserEntityTest {

	@Test
	void 大文字に変換した名前を取得する() {
		User user = new User("0001", "Makoto Ishibashi");
		String expectedString = "MAKOTO ISHIBASHI";
		
		UserEntity userEntity = new UserEntity();
		userEntity.setData(user);
		
		assertEquals(expectedString, userEntity.getUpperName());
	}

}
