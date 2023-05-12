package com.mishibashi.tdd.application.usecase.login;

import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mishibashi.tdd.domain.repository.IUserRepository;
import com.mishibashi.tdd.domain.service.LoginService;
import com.mishibashi.tdd.exception.NotFoundException;
import com.mishibashi.tdd.infrastructure.UserRepository;

class LoginUseCaseTest {

	private final String sqliteJdbc = "org.sqlite.JDBC";
	private final String sqliteDBPath = "jdbc:sqlite:./database/database.db";

	private Connection connection;
	@Test
	void ユーザーが存在しない場合のgetUserName() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NotFoundException, SQLException {
		String id = "0001";
		String name = "Makoto Ishibashi";
		
		ILoginUseCaseOutputPort outputPort = mock(ILoginUseCaseOutputPort.class);
		LoginService service = mock(LoginService.class);
		LoginUseCase useCase = new LoginUseCase(null, outputPort, service);
		
		when(service.isExist(id)).thenReturn(false);
		
		useCase.getUserName(id);

		verify(outputPort, times(1)).userNotFound();
		verify(outputPort, times(0)).successGetUserName(name);
	}
	
	@Test
	void ユーザーが存在する場合のgetUserName() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, NotFoundException {
		String id = "0001";
		String name = "Makoto Ishibashi";
		
		ILoginUseCaseOutputPort outputPort = mock(ILoginUseCaseOutputPort.class);
		LoginService service = mock(LoginService.class);
		LoginUseCase useCase = new LoginUseCase(null, outputPort, service);

		when(service.isExist(id)).thenReturn(true);
		when(service.getName(id)).thenReturn(name);

		useCase.getUserName(id);

		verify(outputPort, times(0)).userNotFound();
		verify(outputPort, times(1)).successGetUserName(name);
	}
	
	@Test
	void 結合テスト() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NotFoundException {
		String id = "0001";
		String name = "Makoto Ishibashi";
		

        Class.forName(sqliteJdbc);
        connection = DriverManager.getConnection(sqliteDBPath);
        
        ILoginUseCaseOutputPort outputPort = mock(ILoginUseCaseOutputPort.class);
        IUserRepository repository = new UserRepository(connection);
		LoginService service = new LoginService(repository);
		LoginUseCase useCase = new LoginUseCase(connection, outputPort, service);
		
		useCase.getUserName(id);

		verify(outputPort, times(0)).userNotFound();
		verify(outputPort, times(1)).successGetUserName(name);
	}

}
