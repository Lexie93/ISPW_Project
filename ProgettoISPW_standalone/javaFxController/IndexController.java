package javaFxController;

import control.ControlloreAdapter;
import exception.ErroreFxController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IndexController implements UpdatableController
{
	SceneUpdater sceneUpdater;
	
	@FXML
	Button buttonRegistrazione;
	@FXML
	Button buttonLogin;
	@FXML
	Button buttonGestioneProfilo;
	@FXML
	Button buttonLogout;
	@FXML
	Label benvenutoLbl;
	@FXML
	Button buttonCreaAnnuncio;
	@FXML
	Button buttonPropriAnnunci;
	@FXML
	Button buttonVisualizzaListaDesideri;
	
	public IndexController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void goToLogin() throws Exception 
	{
		//sceneUpdater.updateScene(sceneUpdater.getSceneLogin());
		sceneUpdater.updateSceneAndController("login");
	}
	
	public void goToRegistrazione() throws ErroreFxController 
	{
		sceneUpdater.updateScene("registrazione");
	}
	
	public void goToGestioneProfilo() throws ErroreFxController
	{
		sceneUpdater.updateSceneAndController("gestioneProfilo");
	}
	public void logout()
	{
		ControlloreAdapter cAdapter =  ControlloreAdapter.getSingletonInstance();
		cAdapter.logout();
		try {
			sceneUpdater.updateSceneAndController("index");
		} catch (ErroreFxController e) {
			AlertMessageGenerator.createAlertForError("logout", e);
		}
	}
	
	public void goToCreaAnnuncio() throws ErroreFxController
	{
		sceneUpdater.updateSceneAndController("creazioneAnnuncio");
	}
	
	public void goToPropriAnnunci() throws ErroreFxController
	{
		sceneUpdater.updateSceneAndController("propriAnnunci");
	}
	
	public void goToCercaArticoli() throws Exception 
	{
		sceneUpdater.updateSceneAndController("cercaAnnunci");
	}
	
	public void goToVisualizzaListaDesideri() throws Exception 
	{
		sceneUpdater.updateSceneAndController("visualizzaListaDesideri");
	}

	@Override
	public void update() 
	{
		ControlloreAdapter cAdapter =  ControlloreAdapter.getSingletonInstance();
		if(cAdapter.isUserLogged())
		{
			buttonRegistrazione.setVisible(false);
			buttonLogin.setVisible(false);
			buttonGestioneProfilo.setVisible(true);
			buttonLogout.setVisible(true);
			buttonCreaAnnuncio.setVisible(true);
			buttonPropriAnnunci.setVisible(true);
			buttonVisualizzaListaDesideri.setVisible(true);
			benvenutoLbl.setText("Benvenuto "+cAdapter.getUser().getUsername());
		}
		else
		{
			buttonRegistrazione.setVisible(true);
			buttonLogin.setVisible(true);
			buttonGestioneProfilo.setVisible(false);
			buttonLogout.setVisible(false);
			buttonCreaAnnuncio.setVisible(false);
			buttonPropriAnnunci.setVisible(false);
			buttonVisualizzaListaDesideri.setVisible(false);
			benvenutoLbl.setText("Benvenuto utente anonimo");
		}
	}
	
}
