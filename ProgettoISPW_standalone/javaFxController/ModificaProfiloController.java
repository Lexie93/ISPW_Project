package javaFxController;

import control.ControlloreAdapter;
import entity.Utente;
import exception.ErroreFxController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ModificaProfiloController implements UpdatableController
{	
	SceneUpdater sceneUpdater;
	@FXML
	private TextField username;
	@FXML
    private PasswordField password;
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
	

public ModificaProfiloController(SceneUpdater sceneUpdater)
{
	this.sceneUpdater = sceneUpdater;
}

public void conferma()
{
	ControlloreAdapter cAdapter =  ControlloreAdapter.getSingletonInstance();
	try {
		cAdapter.modificaProfilo(getUtente());
		sceneUpdater.updateScene("index");
	} catch (Exception e) {
		AlertMessageGenerator.createAlertForError("modifica profilo", e);
	}
}

public void annulla()
{
	try {
		sceneUpdater.updateScene("index");
	} catch (ErroreFxController e) 
	{
		AlertMessageGenerator.createAlertForError("passaggio a index", e);
	}
}

@Override
public void update() 
{
	ControlloreAdapter cAdapter =  ControlloreAdapter.getSingletonInstance();
	try {
		setUtente(cAdapter.getProfilo());
	} catch (Exception e) {
		AlertMessageGenerator.createAlertForError("visualizzazione profilo", e);
	}
	
}
public  void setUtente(Utente u)
{
	username.setText(u.getUsername());
	nome.setText(u.getNome());
	cognome.setText(u.getCognome());
	email.setText(u.getEmail());
	telefono.setText(u.getNumeroTelefono());
	indirizzo.setText(u.getIndirizzo());
}

public Utente getUtente()
{
	return new Utente(
	username.getText(),
	"",
	nome.getText(),
	cognome.getText(),
	email.getText(),
	telefono.getText(),
	indirizzo.getText());
	
}

}
