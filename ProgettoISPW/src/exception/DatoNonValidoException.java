package exception;

public class DatoNonValidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatoNonValidoException()
	{
		super("Il dato inserito non � valido");
	}
	
	public DatoNonValidoException(String dato)
	{
		super("Il seguente dato inserito non � valido "+dato);
	}
}
