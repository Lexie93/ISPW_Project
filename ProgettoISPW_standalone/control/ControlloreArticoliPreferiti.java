package control;

import java.util.Vector;

import database.ArticoliPreferitiDao;
import entity.Articolo;
import exception.ErroreDbException;

public class ControlloreArticoliPreferiti 
{

	public ControlloreArticoliPreferiti()
	{
		
	}
	
	public void aggiungiArticoloPreferito(String username,int id) throws ErroreDbException
	{
		ArticoliPreferitiDao aPDao =  ArticoliPreferitiDao.getSingletonInstance();
		aPDao.addArticoloPreferito(username, id);
		
	}
	
	public void eliminaArticoloPreferito(String username,int id) throws ErroreDbException
	{
		ArticoliPreferitiDao aPDao =  ArticoliPreferitiDao.getSingletonInstance();
		
		aPDao.removeArticoloPreferito(username, id);
		
	}
	
	public Vector <Articolo> visuallizzaArticoliPreferiti(String username) throws ErroreDbException
	{
		ArticoliPreferitiDao aPDao =  ArticoliPreferitiDao.getSingletonInstance();
		return aPDao.getArticoliPreferiti(username);
	}
	
}
