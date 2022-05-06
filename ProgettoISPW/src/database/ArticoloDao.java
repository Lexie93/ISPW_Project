package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import entity.Articolo;

public class ArticoloDao implements ArticoloDaoInterface {
	
	boolean printEccezioni=false;
	boolean printStatement=false;
	static private final boolean testing=true;
	
	private static ArticoloDao instance;
	
	public synchronized static final ArticoloDao getSingletonInstance() {
		if (testing){
			return testOnlyConstructor();
		} else{
			if (ArticoloDao.instance == null)
				ArticoloDao.instance = new ArticoloDao();
			return instance;
		}
	}
	
	private static ArticoloDao testOnlyConstructor(){						//ONLY FOR UNIT-TESTING PURPOSE!!!!
		return new ArticoloDao();
	}
	
	private ArticoloDao() {
		
	}

	@Override
	public void creaArticolo(String nome, String descrizione, String p, String venditore) throws Exception {
		try{
			Connection con=MyDataSource.getConnection();
			String command="insert into articoli (nome,descrizione,prezzo,venditore) values (?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(command);
			statement.setString(1, nome);
			statement.setString(2, descrizione);
			Double prezzo=Double.parseDouble(p)*100;
			statement.setInt(3, prezzo.intValue());
			statement.setString(4, venditore);
			if(printStatement)	System.out.println(statement.toString());
			statement.executeUpdate();
			statement.close();
			con.close();
			
		}catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nell'inserimento dell'annuncio");
			throw new Exception("Errore nell'inserimento dell'annuncio");
		}
		
	}
	
	@Override
	public Vector<Articolo> cerca(String ricerca) throws Exception{
		
		Vector<Articolo> articoli=new Vector<Articolo>();
		
		try{
			
			Connection con=MyDataSource.getConnection();
			
			articoli.removeAllElements();
			
			String command="select * from articoli where lower(nome) like ? or descrizione like ?";
			PreparedStatement statement = con.prepareStatement(command);
			statement.setString(1, "%" + ricerca.toLowerCase() + "%");
			statement.setString(2, "%" + ricerca.toLowerCase() + "%");
			if(printStatement)	System.out.println(statement.toString());
			ResultSet result=statement.executeQuery();
			while(result.next()){
				String nome=result.getString("nome");
				String descrizione=result.getString("descrizione");
				String prezzo=String.valueOf((Double.parseDouble(result.getString("prezzo"))/100));
				String venditore=result.getString("venditore");
				int ID=result.getInt("id");
				Articolo a=new Articolo(nome,descrizione,prezzo,venditore,ID);
				articoli.add(a);
				
			}
			
		} catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nella ricerca degli annunci");
			throw new Exception("Errore nella ricerca degli annunci");
		}
		
		return articoli;
	}
	
	@Override
	public Vector<Articolo> cercaPerUtente(String u) throws Exception{
		
		Vector<Articolo> articoli=new Vector<Articolo>();
		
		try{
			
			Connection con=MyDataSource.getConnection();
			
			articoli.removeAllElements();
			
			String command="select * from articoli where lower(venditore) = ?";
			PreparedStatement statement = con.prepareStatement(command);
			statement.setString(1, u.toLowerCase());
			if(printStatement)	System.out.println(statement.toString());
			ResultSet result=statement.executeQuery();
			
			while(result.next()){
				String nome=result.getString("nome");
				String descrizione=result.getString("descrizione");
				String prezzo=String.valueOf(Double.parseDouble(result.getString("prezzo"))/100);
				String venditore=result.getString("venditore");
				int ID=result.getInt("id");
				Articolo a=new Articolo(nome,descrizione,prezzo,venditore,ID);
				articoli.add(a);
				
			}
			statement.close();
			con.close();
			
		} catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nella ricerca degli annunci");
			throw new Exception("Errore nella ricerca degli annunci");
		}
		
		return articoli;
	}
	
	@Override
	public void rimuoviArticolo(int id) throws Exception{
		try{
			if(id<0)	throw new Exception();
			Connection con=MyDataSource.getConnection();
			String command="delete from articoli where id = ?";
			PreparedStatement statement = con.prepareStatement(command);
			statement.setInt(1, id);
			if(printStatement)	System.out.println(statement.toString());
			statement.executeUpdate();
			statement.close();
			con.close();
			
		}catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nella rimozione dell'annuncio");
			throw new Exception("Errore nella rimozione dell'annuncio");
		}
	}

	@Override
	public void modificaArticolo(int id, String nome, String descrizione, String p) throws Exception {
		try {
			
				Connection connection=MyDataSource.getConnection();
				String command="update articoli set nome= ?, descrizione = ?,prezzo = ? where id = ?";
				PreparedStatement statement;
				statement = connection.prepareStatement(command);	
				statement.setString(1, nome);
				statement.setString(2, descrizione);
				double prezzo=Double.parseDouble(p)*100;
				statement.setDouble(3, prezzo);
				statement.setInt(4, id);
				
				if(printStatement)	System.out.println(statement.toString());
				statement.executeUpdate();
				
				statement.close();
				connection.close();
		}catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nella modifica dell'annuncio");
			throw new Exception("Errore nella modifica dell'annuncio");
		}
		
	}

	@Override
	public Articolo getArticolo(int id) throws Exception {
		
		Articolo a=null;
		try{
			Connection con=MyDataSource.getConnection();
			String command="select * from articoli where id = ?";
			PreparedStatement statement = con.prepareStatement(command);
			statement.setInt(1, id);
			if(printStatement)	System.out.println(statement.toString());
			ResultSet result=statement.executeQuery();
			result.next();
			int ID=result.getInt("id");
			String nome=result.getString("nome");
			String descrizione=result.getString("descrizione");
			String venditore=result.getString("venditore");
			String prezzo=String.valueOf((Double.parseDouble(result.getString("prezzo"))/100));
			a=new Articolo(nome,descrizione,prezzo,venditore,ID);
			
			statement.close();
			con.close();
			
		}catch(Exception e){
			if(printEccezioni)	System.out.println("Errore nella ricerca dell'annuncio");
			throw new Exception("Errore nella ricerca dell'annuncio");
		}
		return a;
	}

}
