package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.naming.InitialContext;



//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource ;

import entity.Utente;
import exception.ErroreDbException;
import exception.PasswordException;
import exception.UtenteNonTrovatoException;

public class UtenteDAO implements UtenteDaoInterface{

	private static UtenteDAO instance;	
	
	public synchronized static final UtenteDAO getSingletonInstance() {
		if (UtenteDAO.instance == null)
			UtenteDAO.instance = new UtenteDAO();		
		return instance;
	}
	
	private UtenteDAO()
	{
		
	}
	
	@Override
	public Utente getUtente(String username) throws UtenteNonTrovatoException, ErroreDbException 
	{
		String command="select * from utenti where username = ?";
		PreparedStatement statement;
		try {
				Connection connection=MyDataSource.getConnection();
				
				
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
		
				ResultSet rs=statement.executeQuery();
				
				if(!rs.next())
				{
					System.out.println("user non trovato");
					throw new UtenteNonTrovatoException();
				}
					
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String email = rs.getString("email");
				String numeroTelefono = rs.getString("num_telefono");
				String indirizzo = rs.getString("indirizzo");
				Utente u= new Utente(username.trim(),password.trim(),nome.trim(),cognome.trim(),email.trim()
						,numeroTelefono.trim(),indirizzo.trim());
			
				statement.close();
				connection.close();
				return u;
		} catch (SQLException e) {
			System.out.println("errore in query");
			e.printStackTrace();
			throw new ErroreDbException();
		}
	}
	
	@Override
	public boolean validateUtente(String username, String password) throws UtenteNonTrovatoException, ErroreDbException, PasswordException 
	{
		//DataSource datasource=new DataSource();
		String command="select password from utenti where username = ?";
		PreparedStatement statement;
		String passwordFromDb;
				Connection connection;
				try {
					connection = MyDataSource.getConnection();
				
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
		
				ResultSet rs=statement.executeQuery();
				
				if(!rs.next())
				{
					System.out.println("user non trovato");
					throw new UtenteNonTrovatoException();
				}
				
				
		
				passwordFromDb= rs.getString("password");
								
				statement.close();
				connection.close();
				
				} catch (SQLException e) {
					throw new ErroreDbException();
				}
				if(password.equals(passwordFromDb.trim()))
					return true;
				else
				throw new PasswordException();	
	}

	@Override
	public void createUtente(Utente utente) throws ErroreDbException {
		//DataSource datasource=new DataSource();
		String command="insert into utenti (username,password,nome,cognome,email,num_telefono,indirizzo) values (?,?,?,?,?,?,?)";
		PreparedStatement statement;
		try {
				Connection connection=MyDataSource.getConnection();
			
				statement = connection.prepareStatement(command);	
				statement.setString(1, utente.getUsername());
				statement.setString(2, utente.getPassword());
				statement.setString(3, utente.getNome());
				statement.setString(4, utente.getCognome());
				statement.setString(5, utente.getEmail());
				statement.setString(6, utente.getNumeroTelefono());
				statement.setString(7, utente.getIndirizzo());
				statement.executeUpdate();
				
				statement.close();
				connection.close();
		} catch (SQLException e) {
			throw new ErroreDbException();
		}
	}

	@Override
	public void updateUtente(String username, Utente utente) throws ErroreDbException {
		
		//DataSource datasource=new DataSource();
		String command="update utenti set username= ?, password = ?,nome = ?,cognome = ?,email = ?,num_telefono = ?,indirizzo = ? where username = ?";
		PreparedStatement statement;
		try {
			
				Connection connection=MyDataSource.getConnection();
				statement = connection.prepareStatement(command);	
				statement.setString(1, utente.getUsername());
				statement.setString(2, utente.getPassword());
				statement.setString(3, utente.getNome());
				statement.setString(4, utente.getCognome());
				statement.setString(5, utente.getEmail());
				statement.setString(6, utente.getNumeroTelefono());
				statement.setString(7, utente.getIndirizzo());
				
				statement.setString(8, username);
				
				statement.executeUpdate();
				
				statement.close();
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErroreDbException();
		}
	}

	@Override
	public void deleteUtente(String username) throws ErroreDbException 
	{
		String command="delete from utenti where username = ?";
		PreparedStatement statement;
		try {
				Connection connection=MyDataSource.getConnection();
				
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
		
				statement.executeUpdate();
				
				statement.close();
				connection.close();

		} catch (SQLException e) 
		{
			System.out.println("errore in query");
			e.printStackTrace();
			throw new ErroreDbException();
		}
		
	}
	@Override
	public void updatePassword(String username, String password) throws ErroreDbException {
		String command="update utenti set password = ? where username = ?";
		PreparedStatement statement;
		try {
			
				Connection connection=MyDataSource.getConnection();
				statement = connection.prepareStatement(command);	
				statement.setString(1, password);
				statement.setString(2, username);
				
				statement.executeUpdate();
				
				statement.close();
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErroreDbException();
		}
	}
	

	
}
