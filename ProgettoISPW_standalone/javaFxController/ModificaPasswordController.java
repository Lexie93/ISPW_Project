package javaFxController;

import control.ControlloreAdapter;
import exception.ErroreFxController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class ModificaPasswordController {

	@FXML
	PasswordField password;
	@FXML
	PasswordField password2;
	
	SceneUpdater sceneUpdater;
	
	public ModificaPasswordController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void conferma()
	{
		ControlloreAdapter cAdapter =  ControlloreAdapter.getSingletonInstance();
		if(password.getText().equals(password2.getText()))
		{
			try {
				cAdapter.modificaPassword(password.getText());
				sceneUpdater.updateScene("index");
			} catch (Exception e) {
				AlertMessageGenerator.createAlertForError("modifica Password", e);
			}
		}
		else
			AlertMessageGenerator.createAlert("errore modifica Password", "le due password devono coincidere");
			
	}
	
	public void annulla()
	{
		try {
			sceneUpdater.updateScene("index");
		} catch (ErroreFxController e) 
		{
			AlertMessageGenerator.createAlertForError("modifica Password", e);
		}
	}
	
}
