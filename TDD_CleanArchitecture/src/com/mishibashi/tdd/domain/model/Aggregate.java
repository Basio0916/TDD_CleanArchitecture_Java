package com.mishibashi.tdd.domain.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class Aggregate <T extends Entity<U>, U extends Data>{
	private final List<T> _entityList;
	private final Class<T> _type; 
	
	public Aggregate(Class<T> type ,U data[]) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(type == null) {
			throw new NullPointerException();
		}
		_type = type;
		_entityList = new ArrayList<T>();
		
		if(data == null) {
			return;
		}
		
		for (U d : data) {
			T entity = type.getDeclaredConstructor().newInstance();
			entity.setData(d);
			_entityList.add(entity);
		}
	}
	
	public List<T> getEntityList() {
		return _entityList;
	}
	
	public boolean isExist() {
		return getEntityList().size() != 0;
	}
}
