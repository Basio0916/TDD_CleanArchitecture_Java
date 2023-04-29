package com.mishibashi.tdd.domain.model;

public abstract class Entity <T extends Data>{
	private T _data;
	
	public T getData() {
		return _data;
	}
	
	public void setData(T data) {

		if(data == null) {
			throw new NullPointerException();
		}
		_data = data;
	}
}
