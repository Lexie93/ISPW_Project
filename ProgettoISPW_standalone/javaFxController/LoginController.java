package javaFxController;

import control.ControlloreAdapter;
import exception.ErroreFxController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController  implements UpdatableController
{
	SceneUpdater sceneUpdater;
	
public LoginController(SceneUpdater sceneUpdater) 
{
		this.sceneUpdater = sceneUpdater;
}

@FXML
private TextField username;

@FXML
private TextField password;

public void login()
{
	ControlloreAdapter cAdapter = ControlloreAdapter.getSingletonInstance();
	try 
	{
		cAdapter.validateLogin(username.getText(),password.getText());
		goToIndex();
	}
	catch (Exception e) 
	{
	AlertMessageGenerator.createAlertForError("login", e);
	}
	
}

public void goToIndex() throws ErroreFxController
{
	sceneUpdater.updateSceneAndController("index");;
}

@Override
public void update() 
{
	this.username.setText("");
	this.password.setText("");
	
}

 
}
