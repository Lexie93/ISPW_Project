package javaFxController;

import java.util.Vector;

import control.ControlloreArticoli;
import entity.Articolo;
import fxGraphics.ArticoliPaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CercaAnnunciController implements UpdatableController{
	SceneUpdater sceneUpdater;
	@FXML
	private ScrollPane SearchResponsePane;
	@FXML
	private VBox ResponseVBox;
	@FXML
	private TextField ricerca;
	
	
	public CercaAnnunciController(SceneUpdater sceneUpdater) throws Exception{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlertForError("ricerca annunci", new Exception("Errore durante la ricerca degli annunci"));
		}
	}

	public void cerca(){
		ResponseVBox.getChildren().clear();
		ricerca.setText(ricerca.getText().trim());
		if(!ricerca.getText().equals("")){
			try{
				ControlloreArticoli conAr=new ControlloreArticoli();
				Vector<Articolo> articoli= conAr.cerca(ricerca.getText());
		
				ArticoliPaneFactory factory = new ArticoliPaneFactory();
				ResponseVBox = factory.createArticoloPane(articoli, sceneUpdater, "ricerca").append(ResponseVBox);
		
			} catch (Exception e){
				AlertMessageGenerator.createAlert("Errore ricerca annunci", "si è verificato un errore nella visualizzazione degli annunci");
			}
		}
}

	@Override
	public void update() {
		ResponseVBox.getChildren().clear();
		ricerca.clear();
	}
}
