package control;


import database.UtenteDAO;
import entity.Utente;

public class ControlloreUtente
{
	public ControlloreUtente()
	{
		
	}
	
	public boolean validateLogin(String username, String password) throws Exception
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		//ControlloreDatiImmessi.controlloStringaNonVuota(username);
		//ControlloreDatiImmessi.controlloStringaNonVuota(password);
		return uDao.validateUtente(username, password);
		//java.security.MessageDigest.getInstance("MD5");
		
	}
	
	public void registrazione(Utente utente) throws Exception
	{
		ControlloreDatiImmessiUtente.controlloCampiUtente(utente);
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		uDao.createUtente(utente);
	}
	
	public void modificaProfilo(String sessionUsername,Utente utente) throws Exception
	{
		ControlloreDatiImmessiUtente.controlloCampiUtente(utente);
		//ControlloreDatiImmessi.controlloStringaNonVuota(sessionUsername, "username");
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		uDao.updateUtente(sessionUsername, utente);
	}
	
	public void modificaPassword(String sessionUsername, String password) throws Exception
	{
		ControlloreDatiImmessiUtente.controlloPassword(password);
		password=password.trim();
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		uDao.updatePassword(sessionUsername, password);
	}
	
	
	public Utente getProfilo(String sessionUsername) throws Exception
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		return uDao.getUtente(sessionUsername);
	}
	
	public void eliminaProfilo(String sessionUsername) throws Exception
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		//controllo articoli dell' utente
		uDao.deleteUtente(sessionUsername);
	}
}
