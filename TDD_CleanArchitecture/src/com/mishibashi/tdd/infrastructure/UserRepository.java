package com.mishibashi.tdd.infrastructure;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mishibashi.tdd.domain.model.User;
import com.mishibashi.tdd.domain.model.UserWrapperAggregate;
import com.mishibashi.tdd.domain.repository.IUserRepository;

public class UserRepository implements IUserRepository {
	private final Connection _connection;
	
	public UserRepository(Connection connection) {
		_connection = connection;
	}

	@Override
	public UserWrapperAggregate findById(String id) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String query = "SELECT * FROM user WHERE id='" + id + "';";
        Statement statement = _connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<User> users = new ArrayList<User>();
		while(resultSet.next()) {
			users.add(new User(resultSet.getString(1), resultSet.getString(2)));
		}
		return new UserWrapperAggregate((User[])users.toArray(new User[0]));
	}

	@Override
	public void login(String id, String terminalNo) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
