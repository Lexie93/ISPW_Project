package database;

import java.util.Vector;

import entity.Articolo;

public interface ArticoloDaoInterface {
	void creaArticolo(String nome, String descrizione, String p, String venditore) throws Exception;
	Vector<Articolo> cerca(String ricerca) throws Exception;
	Vector<Articolo> cercaPerUtente(String u) throws Exception;
	void rimuoviArticolo(int id) throws Exception;
	void modificaArticolo(int id, String nome, String descrizione, String p) throws Exception;
	Articolo getArticolo(int id) throws Exception;
}
