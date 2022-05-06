package control;

import entity.Utente;
import exception.DatoNonValidoException;

public class ControlloreDatiImmessiUtente 
{
	static final int lunghezzaMassimaUsername = 20;
	static final int lunghezzaMassimaPassword = 20;
	static final int lunghezzaMassimaNome = 20;
	static final int lunghezzaMassimaCognome = 20;
	static final int lunghezzaMassimaEmail = 35;
	static final int lunghezzaMassimaNumeroTelefono = 15;
	static final int lunghezzaMassimaIndirizzo = 50;
	
	
	public static void controlloCampiUtente(Utente u) throws DatoNonValidoException
	{
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getUsername(),lunghezzaMassimaUsername, "username");
		ControlloreDatiImmessi.controlloStringaNonVuota(u.getUsername(),"username");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getPassword(),lunghezzaMassimaPassword, "password");
		ControlloreDatiImmessi.controlloLunghezzaMinima(u.getPassword(),8,"password");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getNome(),lunghezzaMassimaNome, "nome");
		ControlloreDatiImmessi.controlloStringaNonVuota(u.getNome(),"nome");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getCognome(),lunghezzaMassimaCognome, "cognome");
		ControlloreDatiImmessi.controlloStringaNonVuota(u.getCognome(),"cognome");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getEmail(),lunghezzaMassimaEmail, "e-mail");
		ControlloreDatiImmessi.controlloEMail(u.getEmail(),"e-mail");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getNumeroTelefono(),lunghezzaMassimaNumeroTelefono, "numero di telefono");
		ControlloreDatiImmessi.controlloNumero(u.getNumeroTelefono(),"numero di telefono");
		
		ControlloreDatiImmessi.controlloLunghezzaMassima(u.getIndirizzo(),lunghezzaMassimaIndirizzo, "indirizzo");
		ControlloreDatiImmessi.controlloStringaNonVuota(u.getIndirizzo(),"indirizzo");	
	}
	
	public static void controlloPassword(String password) throws DatoNonValidoException
	{
		ControlloreDatiImmessi.controlloLunghezzaMassima(password,lunghezzaMassimaPassword, "password");
		ControlloreDatiImmessi.controlloLunghezzaMinima(password,8,"password");
	}
	
}
