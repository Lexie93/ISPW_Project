package javaFxController;

import control.ControlloreUtente;
import entity.Utente;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrazioneController 
{
	SceneUpdater sceneUpdater;
	
	@FXML
	private TextField username;
	@FXML
    private PasswordField password;
	@FXML
	PasswordField password2;
	@FXML
    private TextField nome;
	@FXML
    private TextField cognome;
	@FXML
    private TextField email;
	@FXML
    private TextField telefono;
	@FXML
    private TextField indirizzo;
	
	public RegistrazioneController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void registrazione()
	{
		ControlloreUtente cUtente = new ControlloreUtente();
		if(password.getText().equals(password2.getText()))
		{
		try {
			cUtente.registrazione(getUtente());
			goToIndex();
		} catch (Exception e) {
			AlertMessageGenerator.createAlertForError("registrazione", e);
		}
		}
		else
			AlertMessageGenerator.createAlert("errore registrazione", "le due password devono coincidere");
	}
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlertForError("registrazione", e);
		}
	}
	private Utente getUtente()
	{
		return new Utente(username.getText(), password.getText(),nome.getText(),cognome.getText(),email.getText(),telefono.getText(),indirizzo.getText());
	}
}
