package javaFxController;

import control.ControlloreAdapter;
import control.ControlloreArticoli;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreazioneAnnuncioController implements UpdatableController{
	SceneUpdater sceneUpdater;
	@FXML
	private TextField nome;
	@FXML
    private TextField prezzo;
	@FXML
    private TextField descrizione;
	
	public CreazioneAnnuncioController(SceneUpdater sceneUpdater) {
		this.sceneUpdater = sceneUpdater;
	}
	
	public void creazione()
	{
		ControlloreArticoli contAr = new ControlloreArticoli();
		ControlloreAdapter contAd =  ControlloreAdapter.getSingletonInstance();
		try {
			contAr.creaArticolo(nome.getText().trim(), descrizione.getText().trim(), prezzo.getText().trim(), contAd.getUser().getUsername().trim());
			goToIndex();
		} catch (Exception e) {
			AlertMessageGenerator.createAlert("creazione annuncio", "dati non validi");
		}
	}
	
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlertForError("creazione annuncio", new Exception("Errore durante la creazione dell'annuncio"));
		}
	}

	@Override
	public void update() {
		nome.clear();
		prezzo.clear();
		descrizione.clear();
	}
	
}
