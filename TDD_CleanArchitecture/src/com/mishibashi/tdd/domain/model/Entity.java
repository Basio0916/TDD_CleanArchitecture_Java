package com.mishibashi.tdd.domain.model;

public abstract class Entity <T>{
	private final T _entity;
	
	public Entity(T entity) {
		if(entity == null) {
			throw new NullPointerException();
		}
		_entity = entity;
	}
	
	public T getEntity() {
		return _entity;
	}
}
