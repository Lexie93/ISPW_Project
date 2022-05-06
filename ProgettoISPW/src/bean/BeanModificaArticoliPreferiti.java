package bean;

import control.ControlloreArticoliPreferiti;
import exception.ErroreDbException;

public class BeanModificaArticoliPreferiti 
{
	int id;

	public  BeanModificaArticoliPreferiti()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void aggiungiArticoloPreferito(String username) throws ErroreDbException
	{
		ControlloreArticoliPreferiti cAP = new ControlloreArticoliPreferiti();
		cAP.aggiungiArticoloPreferito(username, this.id);
	}
	
	public void eliminaArticoloPreferito(String username) throws ErroreDbException
	{
		ControlloreArticoliPreferiti cAP = new ControlloreArticoliPreferiti();
		cAP.eliminaArticoloPreferito(username, this.id);
	}
}
