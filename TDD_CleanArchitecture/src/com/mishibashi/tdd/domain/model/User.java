package com.mishibashi.tdd.domain.model;

public class User implements Data{
	private final String _id;
	
	private final String _name;
	
	public User(String id, String name) {
		_id = id;
		_name = name;
	}
	
	public String getId() {
		return _id;
	}
	
	public String getName() {
		return _name;
	}
}
