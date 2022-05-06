package database;

import java.util.Vector;

import entity.Articolo;
import exception.ErroreDbException;

public interface ArticoliPreferitiDaoInterface 
{
	Vector <Articolo> getArticoliPreferiti(String username)throws ErroreDbException;
	void addArticoloPreferito(String username, int id)throws ErroreDbException;
	void removeArticoloPreferito(String username, int id)throws ErroreDbException;
	
}
