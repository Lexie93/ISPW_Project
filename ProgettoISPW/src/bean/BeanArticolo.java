package bean;

import entity.Articolo;
import control.ControlloreArticoli;

public class BeanArticolo {
	
	private String nome;
	private String descrizione;
	private String prezzo;
	private String venditore;
	private int ID;
	
	public BeanArticolo()
	{
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getVenditore() {
		return venditore;
	}

	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}
	
	public void setArticolo(Articolo articolo){
		this.nome=articolo.getNome();
		this.descrizione=articolo.getDescrizione();
		this.prezzo=articolo.getPrezzo();
		this.venditore=articolo.getVenditore();
		this.ID=articolo.getID();
	}
	
	public void creaArticolo() throws Exception{
		ControlloreArticoli conA=new ControlloreArticoli();
		conA.creaArticolo(nome, descrizione, prezzo, venditore);
	}
	
	public void rimuoviArticolo() throws Exception{
		ControlloreArticoli conA=new ControlloreArticoli();
		conA.rimuoviArticolo(ID);
	}
	
	public void modificaArticolo() throws Exception{
		ControlloreArticoli conA=new ControlloreArticoli();
		conA.modificaArticolo(ID, nome, descrizione, prezzo);
	}
	
	public void findArticolo() throws Exception{
		ControlloreArticoli conA=new ControlloreArticoli();
		setArticolo(conA.findArticolo(ID));
	}
}
