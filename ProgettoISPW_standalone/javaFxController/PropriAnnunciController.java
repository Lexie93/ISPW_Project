package javaFxController;

import java.util.Vector;

import control.ControlloreAdapter;
import control.ControlloreArticoli;
import entity.Articolo;
import fxGraphics.ArticoliPaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PropriAnnunciController implements UpdatableController{
	SceneUpdater sceneUpdater;
	@FXML
	private ScrollPane SearchResponsePane;
	@FXML
	private VBox ResponseVBox;
	
	
	public PropriAnnunciController(SceneUpdater sceneUpdater) throws Exception{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlertForError("visualizzazione propri annunci", new Exception("Errore durante il riepilogo degli annunci"));
		}
	}

	
	@Override
	public void update(){
		try{
		ControlloreArticoli conAr=new ControlloreArticoli();
		ControlloreAdapter contAd =  ControlloreAdapter.getSingletonInstance();
		Vector<Articolo> articoli= conAr.cercaPerUtente(contAd.getUser().getUsername());
		
		ArticoliPaneFactory factory = new ArticoliPaneFactory();
		ResponseVBox = factory.createArticoloPane(articoli, sceneUpdater, "propri").append(ResponseVBox);
		
	} catch (Exception e){
		AlertMessageGenerator.createAlert("Errore propri annunci", "si è verificato un errore nella visualizzazione degli annunci");
		
	}
		
}
}
