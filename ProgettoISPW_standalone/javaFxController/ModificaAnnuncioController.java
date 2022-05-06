package javaFxController;

import control.ControlloreArticoli;
import entity.Articolo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ModificaAnnuncioController implements UpdatableController {
	SceneUpdater sceneUpdater;
	@FXML
	private TextField nome;
	@FXML
    private TextField prezzo;
	@FXML
    private TextField descrizione;
	int ID;
	
	public ModificaAnnuncioController(SceneUpdater sceneUpdater) {
		this.sceneUpdater = sceneUpdater;
	}
	
	public void modifica()
	{
		if(AlertMessageGenerator.askConfirmation("Conferma modifica", "Vuoi davvero modificare questo anuncio?")){
			ControlloreArticoli contAr = new ControlloreArticoli();
			try {
				contAr.modificaArticolo(ID, nome.getText().trim(), descrizione.getText().trim(), prezzo.getText().trim());
				goToIndex();
			} catch (Exception e) {
				AlertMessageGenerator.createAlert("errore modifica annuncio", "dati non validi");
			}
		}
	}
	
	public void setArticolo(Articolo a){
		nome.setText(a.getNome().trim());
		prezzo.setText(a.getPrezzo().trim());
		descrizione.setText(a.getDescrizione().trim());
	}
	
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlert("modifica annuncio", "errore nell'operazione");
		}
	}

	@Override
	public void update(int id) {
		this.ID=id;
		ControlloreArticoli conAr=new ControlloreArticoli();
		try {
			setArticolo(conAr.findArticolo(ID));
		} catch (Exception e) {
			AlertMessageGenerator.createAlertForError("caricamento annuncio", new Exception("Errore durante la modifica dell'annuncio"));
		}
		
	}
}
