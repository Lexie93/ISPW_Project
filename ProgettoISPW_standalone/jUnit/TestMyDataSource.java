package jUnit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import database.MyDataSourceStandalone;
import exception.ErroreDbException;

public class TestMyDataSource {

	@Test
	public void test(){
		try {
			Connection c= null;
			c=MyDataSourceStandalone.getConnection();
			assertNotNull(c);
		} catch (ErroreDbException e) {
			fail("Connessione non riuscita");
		}
	}

}
