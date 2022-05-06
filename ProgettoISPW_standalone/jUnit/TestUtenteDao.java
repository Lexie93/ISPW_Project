package jUnit;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import database.UtenteDAO;
import entity.Utente;
import exception.ErroreDbException;
import exception.PasswordException;
import exception.UtenteNonTrovatoException;

public class TestUtenteDao {

	
	 @Before
	 public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException 
	 	{
	       Field instance = UtenteDAO.class.getDeclaredField("instance");
	       instance.setAccessible(true);
	       instance.set(null, null);
	    }
	 @AfterClass
	 public static void resetDatabase()
	 {
		 UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		 try {
			uDao.deleteUtente("userprova2");
		} catch (ErroreDbException e) {
			e.printStackTrace();
		}
	 }
	@Test
	public void TestValidateUtente()
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		try {
			uDao.validateUtente("userprova", "passprova");
		} catch (UtenteNonTrovatoException | ErroreDbException | PasswordException e) {
			fail("Login non riuscito");
		}
	}
	
	@Test
	public void TestCreateUtente()
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		try {
			Utente utenteProva = new Utente("userprova2", "passprova","nomeProva","cognomeProva","emailProva@","12345678","indirizzoProva");
			uDao.createUtente(utenteProva);
		} catch ( ErroreDbException  e) {
			fail("Registrazione non riuscita");
		}
	}
	
	@Test
	public void TestGetUtente()
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		try {
			Utente uProva = uDao.getUtente("userprova");
			//Utente utenteProvaExpected = new Utente("userprova", "passprova","nomeprova","cognomeprova","emailprova@","12345678","indirizzoprova");
			//Assert.assertEquals("",utenteProvaExpected, utenteProva);
			//Assert.assertArrayEquals("userprova", "passprova","nomeprova","cognomeprova","emailprova@","12345678","indirizzoprova",
			Assert.assertEquals("userprova", uProva.getUsername());
			Assert.assertEquals("passprova", uProva.getPassword());
			Assert.assertEquals("nomeprova", uProva.getNome());
			Assert.assertEquals("cognomeprova", uProva.getCognome());
			Assert.assertEquals("emailprova@prova.it", uProva.getEmail());
			Assert.assertEquals("12345678", uProva.getNumeroTelefono());
			Assert.assertEquals("indirizzoprova", uProva.getIndirizzo());
		} catch (UtenteNonTrovatoException | ErroreDbException e) {
			fail("Utente non trovato");
		}
		
		
		
	}
	/*@Test
	public void TestModificaUtente()
	{
		UtenteDAO uDao = UtenteDAO.getSingletonInstance();
		Utente utenteProva = new Utente("userprova", "passprova","nomeProva","cognomeProva","emailProva@","12345678","indirizzoProva");
	}*/
	/*@Test
	public void TestEliminaUtente()
	{
		
	}*/
}
