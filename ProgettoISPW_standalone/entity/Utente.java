package entity;

public class Utente {

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private String numeroTelefono;
	private String indirizzo;
	
	public Utente( String username, String password,String nome,String cognome,String email,String numeroTelefono,String indirizzo)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setNumeroTelefono(numeroTelefono);
		this.setIndirizzo(indirizzo);
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

}
