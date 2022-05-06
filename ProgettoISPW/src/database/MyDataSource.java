package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class MyDataSource 
{
	private static BasicDataSource datasource;
	
	static
	{
		
		InitialContext cxt;
		try {
			cxt = new InitialContext();
		/*if ( cxt == null ) {
	   	throw new Exception("Uh oh -- no context!");
		}*/
	
		datasource = (BasicDataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );
		
		} catch (NamingException e) 
		{
			throw new ExceptionInInitializerError("Errore nella connessione al database");	
		}
		
		if ( datasource == null ) 
		{
			throw new ExceptionInInitializerError("Errore nella connessione al database");
		}
		
	}
	
	public static Connection getConnection() throws SQLException
	{
		return datasource.getConnection();
	}
}
