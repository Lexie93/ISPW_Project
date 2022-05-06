package entity;


public class Articolo {

	private String nome;
	private String descrizione;
	private String prezzo;
	private String venditore;
	private Integer ID;
	//static int numeroProgressivoArticolo;
	
	public Articolo(String nome, String descrizione, String prezzo,String venditore,int ID)
	{
		this.ID=ID;
		this.setNome(nome);
		this.setDescrizione(descrizione);
		this.setPrezzo(prezzo);
		this.venditore=venditore;
		
		//ID=numeroProgressivoArticolo;
		//numeroProgressivoArticolo++;
	}
	
	public void setID(int id)
	{
		this.ID=id;
	}
	public Integer getID()
	{
		return ID;
	}
	
	public String getVenditore() 
	{
		return venditore;
	}
	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}

	public void modificaArticolo(String nome, String descrizione, String prezzo)
	{
		this.setNome(nome);
		this.setDescrizione(descrizione);
		this.setPrezzo(prezzo);
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
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

}
