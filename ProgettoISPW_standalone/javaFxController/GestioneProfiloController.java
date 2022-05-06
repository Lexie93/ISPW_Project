package javaFxController;

import control.ControlloreAdapter;
import entity.Utente;
import exception.ErroreFxController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GestioneProfiloController implements UpdatableController
{
	SceneUpdater sceneUpdater;
	@FXML
	private Label username;
	@FXML
    private Label nome;
	@FXML
    private Label cognome;
	@FXML
    private Label email;
	@FXML
    private Label telefono;
	@FXML
    private Label indirizzo;
	
	public GestioneProfiloController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	@Override
	public void update() 
	{
		ControlloreAdapter cAdapter = ControlloreAdapter.getSingletonInstance();
		try {
			this.setUtente(cAdapter.getProfilo());
		} catch (Exception e) 
		{
			e.printStackTrace();
			AlertMessageGenerator.createAlertForError("Visualizza profilo", e);
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
	
	public void goToModificaProfilo()
	{
		try {
			sceneUpdater.updateSceneAndController("modificaProfilo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AlertMessageGenerator.createAlertForError("Passaggio a modifica profilo",e);
		}
	}
	
	public void goToModificaPassword()
	{
		try {
			sceneUpdater.updateScene("modificaPassword");
		} catch (ErroreFxController e) {
			AlertMessageGenerator.createAlertForError("Passaggio a modifica password",e);
		}
	}
	
	public void goToEliminaProfilo()
	{
		
		try {
			sceneUpdater.updateScene("eliminaProfilo");
		} catch (ErroreFxController e) {
			AlertMessageGenerator.createAlertForError("passaggio a eliminazione profilo", e);
			e.printStackTrace();
		}
	}
	
	public void goToIndex()
	{
		try {
			sceneUpdater.updateScene("index");
		} catch (ErroreFxController e) {
			AlertMessageGenerator.createAlertForError("passaggio a eliminazione profilo", e);
			e.printStackTrace();
		}
	}
	
}
