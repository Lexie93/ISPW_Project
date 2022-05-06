package entity;

import javafx.beans.property.SimpleStringProperty;

public class ArticoloFX {
	final private SimpleStringProperty nome;
	final private SimpleStringProperty descrizione;
	final private SimpleStringProperty prezzo;
	final private SimpleStringProperty venditore;
	
	
	public ArticoloFX(String nome,String descrizione,String prezzo,String venditore)
	{
		this.nome = new SimpleStringProperty(nome);
		this.descrizione = new SimpleStringProperty(descrizione);
		this.prezzo = new SimpleStringProperty(prezzo);
		this.venditore = new SimpleStringProperty(venditore);
	}
	
	public ArticoloFX(Articolo articolo)
	{
		this.nome = new SimpleStringProperty(articolo.getNome());
		this.descrizione = new SimpleStringProperty(articolo.getDescrizione());
		this.prezzo = new SimpleStringProperty(articolo.getPrezzo());
		this.venditore = new SimpleStringProperty(articolo.getVenditore());
	}
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	public String getDescrizione() {
		return descrizione.get();
	}
	public void setDescrizione(String descrizione) {
		this.descrizione.set(descrizione);
	}
	public String getVenditore() {
		return venditore.get();
	}
	public void setVenditore(String venditore) {
		this.venditore.set(venditore);
	}
	public String getPrezzo() {
		return prezzo.get();
	}
	public void setPrezzo(String prezzo) {
		this.prezzo.set(prezzo);
	}

}
