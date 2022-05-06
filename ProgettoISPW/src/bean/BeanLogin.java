package bean;

import control.ControlloreUtente;

public class BeanLogin 
{
	private String username;
	private String password;
	//private boolean valid=false;
	
	public BeanLogin()
	{
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}*/
	
	public void validate() throws Exception
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		//this.setValid(cUtente.validateLogin(this.username,this.password));
		cUtente.validateLogin(username, password);
	}
	
}
