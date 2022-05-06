package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import entity.Articolo;
import exception.ErroreDbException;

public class ArticoliPreferitiDao implements ArticoliPreferitiDaoInterface{

	static ArticoliPreferitiDao instance=null;
	
	public synchronized static final ArticoliPreferitiDao getSingletonInstance() {
		if (ArticoliPreferitiDao.instance == null)
			ArticoliPreferitiDao.instance = new ArticoliPreferitiDao();		
		return instance;
	}
	
	private ArticoliPreferitiDao()
	{
		
	}
	
	@Override
	public Vector<Articolo> getArticoliPreferiti(String username) throws ErroreDbException {
		
		String command="select nome,descrizione,prezzo,venditore,id from articoli join articoli_preferiti"
				+ " on articoli.id= articoli_preferiti.articolo where articoli_preferiti.utente=?";
		
		Vector <Articolo> articoli=new Vector <>();
		
		PreparedStatement statement;
		try {
				Connection connection=MyDataSourceStandalone.getConnection();
				
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
		
				ResultSet rs=statement.executeQuery();
				
				while(rs.next())
				{
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descrizione = rs.getString("descrizione");
					double prezzo = rs.getInt("prezzo");
					prezzo= prezzo/100.0;
					String venditore= rs.getString("venditore");
					articoli.add( new Articolo(nome,descrizione,String.valueOf(prezzo),venditore,id));
				}
				
				statement.close();
				connection.close();
				return articoli;
		} catch (SQLException e) {
			System.out.println("errore in query");
			e.printStackTrace();
			throw new ErroreDbException();
		}
	}

	@Override
	public void addArticoloPreferito(String username,int id) throws ErroreDbException {
		String command="insert into articoli_preferiti (utente,articolo) values (?,?)";
		PreparedStatement statement;
		try {
				Connection connection=MyDataSourceStandalone.getConnection();
			
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
				statement.setInt(2, id);
				statement.executeUpdate();
				
				statement.close();
				connection.close();
		} catch (SQLException e) {
			throw new ErroreDbException();
		}
		
	}

	@Override
	public void removeArticoloPreferito(String username,int id) throws ErroreDbException 
	{
		String command="delete from articoli_preferiti where utente = ? and articolo = ?";
		PreparedStatement statement;
		try {
				Connection connection=MyDataSourceStandalone.getConnection();
				
				statement = connection.prepareStatement(command);	
				statement.setString(1, username);
				statement.setInt(2,id);
		
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

}
