package bean;

import control.ControlloreUtente;
//import database.UtenteDAO;
import entity.Utente;

public class BeanUtente 
{
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private String numeroTelefono;
	private String indirizzo;
	
	public BeanUtente()
	{
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public void setUtente(Utente utente)
	{
		this.username = utente.getUsername();
		this.password = utente.getPassword();
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.email = utente.getEmail();
		this.numeroTelefono= utente.getNumeroTelefono();
		this.indirizzo = utente.getIndirizzo();
	}
	
	public Utente getUtente()
	{
		return new Utente(this.username,this.password,this.nome,this.cognome,this.email,this.numeroTelefono,this.indirizzo);
	}
	
	/*public void provaGetUtente() throws Exception
	{
		UtenteDAO dao = new UtenteDAO();
		Utente utente = dao.getUtente(username);
		this.setUtente(utente);
	}*/
	
	public void registrazione() throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		cUtente.registrazione(this.getUtente());
	}
	
	public void modificaProfilo(String sessionUsername) throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		cUtente.modificaProfilo(sessionUsername, this.getUtente());
	}
	
	public void modificaPassword(String sessionUsername) throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		cUtente.modificaPassword(sessionUsername, this.password);
	}
	
	public void visualizzaProfilo(String sessionUsername) throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		Utente utente=cUtente.getProfilo(sessionUsername);
		setUtente(utente);
	}
	
	public void eliminaProfilo(String sessionUsername) throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		cUtente.eliminaProfilo(sessionUsername);
	}
}
