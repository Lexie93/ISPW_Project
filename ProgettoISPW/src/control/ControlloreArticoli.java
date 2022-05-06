package control;

import java.util.Vector;

import database.ArticoloDao;
import entity.Articolo;

public class ControlloreArticoli {
	static final int lunghezzaMassimaNome = 20;
	
	public static void controllaArticolo(String n, String d, String p) throws Exception{
		ControlloreDatiImmessi.controlloLunghezzaMassima(n,lunghezzaMassimaNome, "nome");
		ControlloreDatiImmessi.controlloStringaNonVuota(n,"nome");
		ControlloreDatiImmessi.controlloStringaNonVuota(d,"descrizione");
		ControlloreDatiImmessi.controlloStringaNonVuota(p,"prezzo");
		ControlloreDatiImmessi.controlloDouble(p);
	}
	
	public void creaArticolo(String n, String d, String p, String v) throws Exception{
		controllaArticolo(n, d, p);
		ArticoloDao Adao=ArticoloDao.getSingletonInstance();
		Adao.creaArticolo(n, d, p, v);
	}

	public void modificaArticolo(int id, String n, String d, String p) throws Exception{
		controllaArticolo(n,d,p);
		ArticoloDao Adao=ArticoloDao.getSingletonInstance();
		Adao.modificaArticolo(id, n, d, p);
	}

	public void rimuoviArticolo(int id) throws Exception{
		ArticoloDao Adao=ArticoloDao.getSingletonInstance();
		Adao.rimuoviArticolo(id);
	}

	public Articolo findArticolo(int id) throws Exception{
		Articolo a;
		ArticoloDao Adao=ArticoloDao.getSingletonInstance();
		a=Adao.getArticolo(id);
		return a;
	}

	public Vector<Articolo> cerca(String ricerca) throws Exception {
		Vector<Articolo> articoli= new Vector<Articolo> ();
		articoli.removeAllElements();
		ArticoloDao adao=ArticoloDao.getSingletonInstance();
		articoli=adao.cerca(ricerca.trim());
		return articoli;
	}

	public Vector<Articolo> cercaPerUtente(String venditore) throws Exception {
		Vector<Articolo> articoli= new Vector<Articolo> ();
		articoli.removeAllElements();
		ArticoloDao adao=ArticoloDao.getSingletonInstance();
		articoli=adao.cercaPerUtente(venditore);
		return articoli;
	}
	
	
	
}
