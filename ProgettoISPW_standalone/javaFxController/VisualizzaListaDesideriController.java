package javaFxController;

import java.util.Vector;

import control.ControlloreAdapter;
import control.ControlloreArticoliPreferiti;
import entity.Articolo;
import fxGraphics.ArticoliPaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class VisualizzaListaDesideriController implements UpdatableController{
	SceneUpdater sceneUpdater;
	@FXML
	private ScrollPane SearchResponsePane;
	@FXML
	private VBox ResponseVBox;
	/*@FXML
	private TextField ricerca;*/
	
	
	public VisualizzaListaDesideriController(SceneUpdater sceneUpdater) throws Exception{
		this.sceneUpdater = sceneUpdater;
	}
	
	public void goToIndex() 
	{
		try
		{
		sceneUpdater.updateScene("index");
		}catch (Exception e) {
			AlertMessageGenerator.createAlertForError("ricerca annunci preferiti", new Exception("Errore durante la ricerca degli annunci preferiti"));
		}
	}

	@Override
	public void update(){
		ResponseVBox.getChildren().clear();
		try{
			ControlloreAdapter conAd=ControlloreAdapter.getSingletonInstance();
			ControlloreArticoliPreferiti conAP=new ControlloreArticoliPreferiti();
			Vector<Articolo> articoli= conAP.visuallizzaArticoliPreferiti(conAd.getUser().getUsername());
			
			ArticoliPaneFactory factory = new ArticoliPaneFactory();
			ResponseVBox = factory.createArticoloPane(articoli, sceneUpdater, "preferiti").append(ResponseVBox);
		
		} catch (Exception e){
			AlertMessageGenerator.createAlert("Errore ricerca annunci preferiti", "si è verificato un errore nella visualizzazione degli annunci preferiti");
		}
	}
}
