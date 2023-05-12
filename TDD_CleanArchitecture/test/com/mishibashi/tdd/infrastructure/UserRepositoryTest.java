package com.mishibashi.tdd.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mishibashi.tdd.domain.model.UserWrapperAggregate;
import com.mishibashi.tdd.domain.repository.IUserRepository;

class UserRepositoryTest {
	private IDatabaseTester databaseTester;
	private Connection connection;
	private IUserRepository repository;
	
	private final String sqliteJdbc = "org.sqlite.JDBC";
	private final String sqliteDBPath = "jdbc:sqlite:./database/database.db";
	
	@BeforeEach
	public void setup() throws Exception{
		databaseTester = new JdbcDatabaseTester(sqliteJdbc, sqliteDBPath);
		
		IDataSet userDataSet = new CsvDataSet(new File("./testdata"));
		databaseTester.setDataSet(userDataSet);
		
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.onSetup();
		

        Class.forName(sqliteJdbc);
        connection = DriverManager.getConnection(sqliteDBPath);
        
        repository = new UserRepository(connection);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		databaseTester.setTearDownOperation(DatabaseOperation.NONE);
		databaseTester.onTearDown();
	}
	
	@Test
	void データがある場合のfindById() throws Exception {
        UserWrapperAggregate userAggregate = repository.findById("0001");

        assertEquals("0001", userAggregate.getFirstEntityWrapper().getData().getId());
        assertEquals("Makoto Ishibashi", userAggregate.getFirstEntityWrapper().getData().getName());
	}
	
	@Test
	void データがない場合のfindById() throws Exception{
        UserWrapperAggregate userAggregate = repository.findById("0003");
		
        assertEquals(false, userAggregate.isExist());
	}

}
