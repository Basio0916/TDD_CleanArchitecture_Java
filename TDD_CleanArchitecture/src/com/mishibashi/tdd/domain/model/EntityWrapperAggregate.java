package com.mishibashi.tdd.domain.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.mishibashi.tdd.exception.NotFoundException;

public abstract class EntityWrapperAggregate <T extends EntityWrapper<U>, U extends Entity>{
	private final List<T> _entityList;
	
	public EntityWrapperAggregate(Class<T> type ,U data[]) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(type == null) {
			throw new NullPointerException();
		}
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
	
	public T getFirstEntityWrapper() throws NotFoundException {
		if(!isExist()) {
			throw new NotFoundException();
		}
		return _entityList.get(0);
	}
	
	public List<T> getEntityWrapperList() {
		return _entityList;
	}
	
	public boolean isExist() {
		return getEntityWrapperList().size() != 0;
	}
}
