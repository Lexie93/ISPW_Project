package bean;

import java.util.Vector;

import entity.Articolo;
import control.ControlloreArticoli;
import control.ControlloreArticoliPreferiti;

public class BeanRicerca {
	
	private String ricerca;
	private int num_articoli=0;
	private Vector<Articolo> articoli=new Vector<Articolo>();
	private String venditore;

	public BeanRicerca(){
		
	}
	
	public void setRicerca(String ricerca){
		this.ricerca=ricerca;
	}
	
	public String getRicerca(){
		return ricerca;
	}
	
	public String getVenditore() {
		return venditore;
	}

	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}

	
	public void cerca() throws Exception{
		articoli.removeAllElements();
		ControlloreArticoli conA= new ControlloreArticoli();
		articoli=conA.cerca(ricerca.trim());
		num_articoli=articoli.size();
	}
	
	public void cercaPerUtente() throws Exception{
		articoli.removeAllElements();
		ControlloreArticoli conA= new ControlloreArticoli();
		articoli=conA.cercaPerUtente(venditore);
		num_articoli=articoli.size();
	}
	
	public void cercaPreferitiUtente() throws Exception{
		articoli.removeAllElements();
		ControlloreArticoliPreferiti cAP= new ControlloreArticoliPreferiti();
		articoli=cAP.visuallizzaArticoliPreferiti(venditore);
		num_articoli=articoli.size();
	}
	public int getNum_articoli() {
		return num_articoli;
	}

	public Vector<Articolo> getArticoli() {
		return articoli;
	}
	
	public Articolo getArticolo(int i){
		return articoli.get(i);
	}
	
}
