package javaFxController;

import java.util.Vector;

import control.ControlloreAdapter;
import entity.Articolo;
import entity.ArticoloFX;
import exception.ErroreDbException;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class VisualizzaArticoliPreferitiController implements UpdatableController
{
	
	@FXML
	TableView<ArticoloFX> tabella;
	/*@FXML
	TableColumn colonnaNome;
	@FXML
	TableColumn colonnaDescrizione;
	@FXML
	TableColumn colonnaPrezzo;
	@FXML
	TableColumn colonnaVenditore;*/
	
	//private final ObservableList<ArticoloFX> articoliFX=FXCollections.observableArrayList( );;
	
	SceneUpdater sceneUpdater;
	
	public  VisualizzaArticoliPreferitiController(SceneUpdater sceneUpdater)
	{
		this.sceneUpdater = sceneUpdater;
	}
	@Override
	public void update() 
	{
		  //colonnaNome.setCellValueFactory(new PropertyValueFactory<ArticoloFX,String>("nome"));
		  //colonnaDescrizione.setCellValueFactory(new PropertyValueFactory<ArticoloFX,String>("descrizione"));
		  //colonnaPrezzo.setCellValueFactory(new PropertyValueFactory<ArticoloFX,String>("prezzo"));
		  //colonnaVenditore.setCellValueFactory(new PropertyValueFactory<ArticoloFX,String>("venditore"));
		ControlloreAdapter cAdapter = ControlloreAdapter.getSingletonInstance();
		Vector<Articolo> articoli;
		try {
			articoli = cAdapter.getArticoliPreferiti();
		} catch (ErroreDbException e) {
		AlertMessageGenerator.createAlertForError("visualizzazione articoli preferiti", e);
		articoli=null;
		}
		for(Articolo a:articoli)
		{	
		tabella.getItems().add(new ArticoloFX(a));
		}
		
	}
	
}
