package control;

import java.util.Vector;

import entity.Articolo;
import entity.Utente;
import exception.ErroreDbException;

public class ControlloreAdapter 
{
	//private String user;
	private Utente utente;
	private ControlloreArticoliPreferiti cAPref;
	private ControlloreUtente cUtente;
	public static ControlloreAdapter instance=null;
	
	public synchronized static final ControlloreAdapter getSingletonInstance() {
		if (ControlloreAdapter.instance == null)
			ControlloreAdapter.instance = new ControlloreAdapter();		
		return instance;
	}
	private ControlloreAdapter()
	{
		utente=null;
		cUtente= new ControlloreUtente();
		cAPref = new ControlloreArticoliPreferiti();
	}
	
	public void validateLogin(String username, String password) throws Exception
	{
		//ControlloreUtente cUtente = new ControlloreUtente();
		if(cUtente.validateLogin(username, password))
			instance.setUser(new Utente(username,"","","","","",""));
	}
	
	public boolean isUserLogged()
	{
		return instance.utente!=null;
	}
	
	public void logout()
	{
		instance.setUser(null);
	}
	public Utente getUser() {
		return utente;
	}
	public void setUser(Utente user) {
		instance.utente = user;
	}
	
	public Utente getProfilo() throws Exception
	{
		//ControlloreUtente cUtente = new ControlloreUtente();
		if(instance.utente.getNome()=="")
		instance.utente = cUtente.getProfilo(instance.utente.getUsername());
		return instance.utente;
	}
	public void eliminaProfilo() throws Exception
	{
		//ControlloreUtente cUtente = new ControlloreUtente();
		cUtente.eliminaProfilo(utente.getUsername());
		this.logout();
	}
	
	public void modificaProfilo(Utente u) throws Exception
	{
		u.setPassword(instance.utente.getPassword());
		cUtente.modificaProfilo(instance.utente.getUsername(), u);
		instance.utente = u;
	}
	
	public void modificaPassword(String password) throws Exception
	{
		cUtente.modificaPassword(instance.utente.getUsername(), password);
		instance.utente.setPassword(password);
	}
	
	public void aggiungiArticoloPreferito(int id) throws ErroreDbException
	{
		cAPref.aggiungiArticoloPreferito(instance.utente.getUsername(), id);
	}
	
	public void eliminaArticoloPreferito(int id) throws ErroreDbException
	{
		cAPref.eliminaArticoloPreferito(instance.utente.getUsername(), id);
	}
	
	public Vector<Articolo> getArticoliPreferiti() throws ErroreDbException
	{
		return cAPref.visuallizzaArticoliPreferiti(instance.utente.getUsername());
	}
}